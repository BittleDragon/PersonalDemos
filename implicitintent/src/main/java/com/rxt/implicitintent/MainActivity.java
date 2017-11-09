package com.rxt.implicitintent;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.rxt.action.1");
                intent.setDataAndType(Uri.parse("file://abc"), "image/jpg");
                ResolveInfo resolveInfo = getPackageManager()
                        .resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
                ComponentName componentName = intent.resolveActivity(getPackageManager());
//                if (componentName == null) {
//
//                }
                if (resolveInfo == null) {
                    Toast.makeText(MainActivity.this, "没有匹配的activity", Toast.LENGTH_SHORT).show();
                } else {
                    Log.e("activity名字", resolveInfo.activityInfo.targetActivity);
//                    startActivity(intent);
                }
            }
        });
    }
}
