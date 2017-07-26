package com.personal.rxjavasample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "Rxjava";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button start = (Button) findViewById(R.id.button);
        start.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int[] datas = new int[] {1, 2, 3};
        Observable.just(1, 2, 3)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .map(new Function<Integer, String>() {
                    @Override
                    public String apply(@NonNull Integer integer) throws Exception {
                        if (integer != 1)
                            Thread.sleep(1500);
                        return String.valueOf(integer);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull String integer) {
                        //打印进程
                        ToastUtils.show(MainActivity.this, integer);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "onComplete: " + "完成");
                    }
                });

        Observable.just(1, 2, 3)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .map(new Function<Integer, String>() {
                    @Override
                    public String apply(@NonNull Integer integer) throws Exception {
                        if (integer != 1)
                            Thread.sleep(1500);
                        return String.valueOf(integer);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull String integer) {
                        ToastUtils.show(MainActivity.this, integer);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "onComplete: " + "完成");
                    }
                });


    }
}
