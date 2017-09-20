package com.rxt.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.rxt.retrofit.model.NewsBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_test)
    Button btnTest;
    private ApiManager apiManager;
    public static final String TAG = "Rxjava";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiManager.baseUrl2)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(new MyConverterFactory())
                .client(OkHttpUtils.getInstance().obtainOkHttpClient())
                .build();
        apiManager = retrofit.create(ApiManager.class);
    }

    @OnClick(R.id.btn_test)
    public void onViewClicked() {
        testRxRetro();
    }

    /**
     * 结合rxjava请求
     */
    private void testRxRetro() {
        Observable<NewsBean> newsCall = apiManager.getNews("Android", 10, 1);
        newsCall.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .concatMap(new Function<NewsBean, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(NewsBean newsBean) throws Exception {
                        Log.e(TAG, "apply: 请求是否出错：" + newsBean.isError());
                        List<String> newsTitle = new ArrayList<>();
                        for (NewsBean.NewsResultBean bean : newsBean.getResults()) {
                            newsTitle.add(bean.getDesc());
                        }
                        return Observable.fromIterable(newsTitle);
                    }
                })
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "onSubscribe: ");
                    }

                    @Override
                    public void onNext(String value) {
                        Log.e(TAG, "onNext: 新闻标题：" + value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "onComplete: ");
                    }

                });
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.e(TAG, "onSubscribe: ");
//                    }
//
//                    @Override
//                    public void onNext(String title) {
//
////                        List<NewsBean.NewsResultBean> results = value.getResults();
////                        for (NewsBean.NewsResultBean bean : results) {
////                            Log.e(TAG, "onNext: 新闻描述：" + bean.getDesc());
////                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e(TAG, "onError: " + e.getMessage());
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.e(TAG, "onComplete: ");
//                    }
//                });

    }
}
