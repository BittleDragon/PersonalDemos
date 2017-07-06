package com.myrepository.dataiodemo;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.start_copy)
    Button startCopy;
    @BindView(R.id.read_txt)
    Button readTxt;
    @BindView(R.id.scan)
    Button scan;
    private String filepath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    /**
     * 复制数据
     */
    private void copy() {
        //输入流
        InputStream inputStream = getResources().openRawResource(R.raw.yiruma_river_flows_in_you);
        BufferedInputStream bis = new BufferedInputStream(inputStream);
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bis));

        FileOutputStream fileOutputStream = null;
        BufferedOutputStream bos = null;

        int b = 0;
        byte[] buffer = new byte[1024];
        try {
//            fileOutputStream = openFileOutput("yiruma_river_flows_in_you.mp3", MODE_PRIVATE);

            String outpath = Environment.getExternalStorageDirectory()
                    .getAbsolutePath() + "/yiruma_copy.mp3";
            fileOutputStream = new FileOutputStream(outpath);
            bos = new BufferedOutputStream(fileOutputStream);

            while ((b = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, b);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();
                if (bos != null) {
                    bos.flush();
                    bos.close();
                    Log.e("复制完成", ".......");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        Toast.makeText(this, "复制完毕!", Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.start_copy, R.id.read_txt, R.id.scan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.start_copy:
                copy();
                break;
            case R.id.read_txt:
                read();
                break;
            case R.id.scan:
                scan();
                break;
        }
    }

    /**
     * 扫描文件
     */
    private void scan() {
        String aa = "dfaoiewjrgf";
        byte[] bytes = aa.getBytes();
    }

    /**
     * 读取txt数据
     */
    private void read() {

        String data = "";

        String path = Environment.getExternalStorageDirectory().
                getAbsolutePath() + "/testdata.txt";
        int b = 0;
        byte[] buffer = new byte[1024];
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            fis = new FileInputStream(path);

            bis = new BufferedInputStream(fis);

            while ((b = bis.read(buffer)) != -1) {
                baos.write(buffer, 0, b);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
                baos.flush();
                data = baos.toString();
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Log.e("读取的字符串", data);
    }
}
