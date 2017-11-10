package com.rxt.implicitintent;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.rxt.action.1");
                File file = new File(Environment
                        .getExternalStorageDirectory().getAbsolutePath() + "/abc.jpg");
                Uri fileUri = FileProvider.getUriForFile(MainActivity.this, BuildConfig.
                        APPLICATION_ID + ".fileProvider", file);
                intent.setDataAndType(fileUri, "image/jpg");
                ResolveInfo resolveInfo = getPackageManager()
                        .resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
                ComponentName componentName = intent.resolveActivity(getPackageManager());
                if (componentName != null) {
                    Log.e("组件名", componentName.getShortClassName());//".SecondActivity"
                }
                if (resolveInfo == null) {
                    Toast.makeText(MainActivity.this, "没有匹配的activity", Toast.LENGTH_SHORT).show();
                } else {
                    String activityName = resolveInfo.activityInfo.name;//"com.rxt.implicitintent.SecondActivity"
                    String pureName = activityName.substring(activityName.lastIndexOf(".") + 1);
                    Log.e("activity名字", pureName);
                    if (TextUtils.equals(pureName, "SecondActivity"))
                        startActivity(intent);
                    else {
                        Log.e("activity", "不匹配");
                    }
                }
            }
        });
    }
}
