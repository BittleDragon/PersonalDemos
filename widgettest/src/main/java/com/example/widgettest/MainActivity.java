package com.example.widgettest;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.pb)
    ProgressBar pb;
    @BindView(R.id.coordinator)
    CoordinatorLayout coordinator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.pb)
    public void onClick() {
        Snackbar.make(coordinator, "正在刷新", Snackbar.LENGTH_SHORT)
                .setAction("这是action", this)
                .show();
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "action被点击了", Toast.LENGTH_SHORT).show();
    }
}
