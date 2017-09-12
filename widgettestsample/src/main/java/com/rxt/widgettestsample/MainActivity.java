package com.rxt.widgettestsample;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 测试控件用的demo
 */
public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CAMERA = 1;
    @BindView(R.id.btn_take_photo)
    Button btnTakePhoto;
    private File tempFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn_take_photo)
    public void onViewClicked() {
        if (Build.VERSION.SDK_INT >= 23) {
            checkPermissionsInNeed();
        } else
            capture();
    }

    private void checkPermissionsInNeed() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

            //没有权限
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CAMERA)) {
                //已经设置不再提示, 前往设置中心手动打开权限
//                turnToApplicationInfo();
                Log.e("tag", "申请权限");
                ToastUtils.show(this, "您已禁止该权限，需要重新开启");
            } else {
                ActivityCompat.requestPermissions(this, new String[]{
                        Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, 1);
            }
        } else {
            capture();
        }
    }

    private void capture() {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (TextUtils.equals(Environment.getExternalStorageState(), Environment.MEDIA_MOUNTED)) {
            String directoryPath = Environment.getExternalStoragePublicDirectory
                    (Environment.DIRECTORY_PICTURES).getAbsolutePath(); //+ File.separator + "temp_picture.jpg";
            SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddhhmmss");
            String currentTime = ft.format(new Date(System.currentTimeMillis()));
//            String filePath = directoryPath + File.separator + currentTime + ".jpg";
//            Log.e("文件路径", filePath);
            tempFile = new File(Environment.getExternalStoragePublicDirectory
                    (Environment.DIRECTORY_PICTURES), currentTime + ".jpg");
//            if (!tempFile.exists()) {
//                tempFile.mkdir();
//                Log.e("tag", "生成文件");
//            }
            try {
                tempFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Uri uri = FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID + ".sharedfile",
                    tempFile);
            cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
            startActivityForResult(cameraIntent, REQUEST_CAMERA);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CAMERA) {
            Log.e("文件大小:", String.valueOf(tempFile.length()));
        }
    }

    private void takePhoto() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        String imagePath = Environment.getExternalStorageDirectory() + "/image";
        File file = new File(imagePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String fileName = System.currentTimeMillis() + ".jpg";
        File tempFile = new File(imagePath, fileName);
        if (!tempFile.exists()) {
            try {
                tempFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                Log.i("tag", "读取文件权限不够");
//                startActivity(CommonUtil.getAppDetailSettingIntent(this));
            }
        }
        Uri imageUri = FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID + ".sharedfile",
                tempFile);
//        imageUris[position] = imageUri;
//        imagePaths[position] = imagePath + File.separator + fileName;
        intent.putExtra(MediaStore.EXTRA_OUTPUT,
                imageUri);
        try {
            startActivityForResult(intent, REQUEST_CAMERA);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                grantResults[1] == PackageManager.PERMISSION_GRANTED) {
            //已授权
            capture();
        }
    }
}
