package com.rxt.widgettestsample.dialog;

import android.app.Dialog;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.rxt.widgettestsample.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by raoxuting on 2017/9/28.
 */

public class DialogActivity extends AppCompatActivity {

    @BindView(R.id.btn_dialog)
    Button btnDialog;
    private Dialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        ButterKnife.bind(this);

        initDialog();
    }

    private void initDialog() {
        dialog = new CustomDialog(this);
//        dialog.setCancelable(false);
        View view = View.inflate(this, R.layout.loading, null);
        ImageView loadingIcon = (ImageView) view.findViewById(R.id.iv_loading);
        AnimationDrawable anim = (AnimationDrawable) loadingIcon.getDrawable();
        anim.start();
        dialog.setContentView(view);
//        dialog.setContentView(R.layout.loading);
    }

    @OnClick(R.id.btn_dialog)
    public void onViewClicked() {
        dialog.show();
    }
}
