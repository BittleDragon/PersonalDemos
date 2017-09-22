package com.rxt.rxjavasample.rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jakewharton.rxbinding2.widget.RxTextView;
import com.rxt.rxjavasample.R;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Rxjava";
    @BindView(R.id.btn_primary)
    Button btnPrimary;
    @BindView(R.id.btn_map)
    Button btnMap;
    @BindView(R.id.btn_zip)
    Button btnZip;
    @BindView(R.id.btn_sample_filter)
    Button btnSampleFilter;
    @BindView(R.id.btn_flowable)
    Button btnFlowable;
    @BindView(R.id.btn_concat)
    Button btnConcat;
    @BindView(R.id.btn_all_in_one)
    Button btnAllInOne;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.btn_first)
    Button btnFirst;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initSearch();

    }

    @OnClick({R.id.btn_primary, R.id.btn_map, R.id.btn_zip, R.id.btn_sample_filter,
            R.id.btn_flowable, R.id.btn_concat, R.id.btn_all_in_one, R.id.btn_first})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_primary:
                primary();
                break;
            case R.id.btn_map:
                mapTest(2);
                break;
            case R.id.btn_zip:
                zipTest();
                break;
            case R.id.btn_sample_filter:
                sampleOrFilter();
                break;
            case R.id.btn_flowable:
                //更详细的使用在FlowableTestClass
                flowableTest();
                break;
            case R.id.btn_concat:
                concatTest();
                break;
            case R.id.btn_all_in_one:
                test();
                break;
            case R.id.btn_first:
                first();
                break;
        }
    }

    private void first() {
        final String TAG = "firstTest";
        Observable<Object> observable1 = Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Object> e) throws Exception {
                e.onNext(1);
                e.onComplete();
            }
        });
        Observable<Object> observable2 = Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Object> e) throws Exception {
                e.onNext("彩云之南");
                e.onComplete();
            }
        });
        Observable.concat(observable1, observable2)
                .first("默认数据")//取第一个收到的数据，如果两个数据源都没有发射数据，则发射“默认数据”
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.e(TAG, "onSubscribe");
                    }

                    @Override
                    public void onSuccess(@NonNull Object o) {
                        if (o instanceof Integer) {
                            Log.e(TAG, "onSuccess: 数字：" + o);
                        }else {
                            Log.e(TAG, "onSuccess: 字符串：" + o);
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });
    }

    /**
     * 使用debounce和switchMap操作符优化app搜索联想功能
     */
    private void initSearch() {
        RxTextView.textChanges(etSearch)
                .subscribeOn(Schedulers.io())
                /*debounce原理类似于我们在收到请求之后，发送一个延时消息给下游，如果在这段延时时间
                内没有收到新的请求，那么下游就会收到该消息；而如果在这段延时时间内收到来新的请求，
                那么就会取消之前的消息，并重新发送一个新的延时消息，以此类推。
                而如果在这段时间内，上游发送了onComplete消息，那么即使没有到达需要等待的时间，
                下游也会立刻收到该消息。
                */
                .debounce(400, TimeUnit.MILLISECONDS)
                .filter(new Predicate<CharSequence>() {
                    @Override
                    public boolean test(CharSequence charSequence) throws Exception {
                        return charSequence.toString().trim().length() > 0;
                    }
                })
                /*
                只取最后输入的内容进行搜索, 防止出现比如停止输入400毫秒后, 那么肯定会开始请求Search
                接口, 但是用户又会输入新的关键字,这个时候上个请求还没有返回, 新的请求又去请求Search
                接口.这个时候有可能最后的一个请求返回, 第一个请求最后返回,导致最终显示的结果
                是第一次搜索的结果.也就是说，当400毫秒后，发出第一个搜索请求，当这个请求的过程中，
                用户又去搜索了，发出第二个请求，不管怎样，switchMap操作符只会发射第二次请求的Observable。
                */
                .switchMap(new Function<CharSequence, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(final CharSequence charSequence) throws Exception {
                        return Observable.create(new ObservableOnSubscribe<String>() {
                            @Override
                            public void subscribe(ObservableEmitter<String> e) throws Exception {
                                e.onNext(charSequence.toString());
                            }
                        });
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String value) {
                        Log.e(TAG, "onNext: 搜索的内容：" + value);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void test() {
        //distinct
//        Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
//                e.onNext("a");
//                e.onNext("a");
//                e.onNext("b");
//                e.onNext("b");
//                e.onNext("c");
//                e.onComplete();
//            }
//        })
//                .distinct()//去重
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<String>() {
//                    @Override
//                    public void accept(@NonNull String s) throws Exception {
//                        Log.e(TAG, "accept: " + s);
//                    }
//                });

        //buffer
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//                        @Override
//                        public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
//                            e.onNext(1);
//                            e.onNext(2);
//                            e.onNext(3);
//                            e.onNext(4);
//                            e.onNext(5);
//                            e.onComplete();
//                        }
//                    })
//                            .buffer(3, 2)//每次取3个事件，下一次拉取事件在前一次的基础上往后推2个
//                .subscribeOn(Schedulers.io())
//                            .observeOn(AndroidSchedulers.mainThread())
//                            .subscribe(new Consumer<List<Integer>>() {
//                        @Override
//                        public void accept(@NonNull List<Integer> integers) throws Exception {
//                            Log.e(TAG, "accept: " + integers.size());
//                            for (Integer i : integers) {
//                                Log.e(TAG, "value: " + i);
//                            }
//                        }
//                });

        //timer,延时发送
//        Log.e(TAG, "startTime: ");
//        Observable.timer(2, TimeUnit.SECONDS)
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<Long>() {
//                    @Override
//                    public void accept(@NonNull Long aLong) throws Exception {
//                        Log.e(TAG, "endTime:");
//                    }
//                });

        //interval,间隔发送long类型的数据，从0L开始, 可用于计时
        Observable.interval(2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Long>() {

                    private Disposable md;

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        md = d;
                    }

                    @Override
                    public void onNext(@NonNull Long aLong) {
                        Log.e(TAG, "accept: " + aLong);
                        if (aLong == 5)
                            md.dispose();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "onComplete: ");
                    }
                });


    }

    private void concatTest() {
        Observable<Integer> observable1 = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onNext(4);
                e.onComplete();
            }
        });
        Observable<Integer> observable2 = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                e.onNext(5);
                e.onNext(6);
                e.onNext(7);
                e.onComplete();
            }
        });
        Observable.concat(observable1, observable2)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(@NonNull Integer integer) throws Exception {
                        Log.e(TAG, "accept: " + integer);
                    }
                });

    }

    private void flowableTest() {
        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull FlowableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onNext(4);
                e.onNext(5);
            }
        }, BackpressureStrategy.ERROR)//BackpressureStrategy.BUFFER:存储事件的容器无限大，类似于observable，有可能OOM
                //BackpressureStrategy.DROP:超出下游处理能力的事件将被丢弃，不会存入容器造成OOM
                //BackpressureStrategy.LATEST:容器中保存最新的s.request(n)个数的事件
                .subscribe(new Subscriber<Integer>() {

                    @Override
                    public void onSubscribe(Subscription s) {
                        s.request(4);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e(TAG, "onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "onComplete: ");
                    }
                });
    }

    private void sampleOrFilter() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                for (int i = 1; ; i++) {
                    e.onNext(i);
                }
            }
        }).subscribeOn(Schedulers.io())
                //过滤，上游事件有损失
//                .filter(new Predicate<Integer>() {
//                    @Override
//                    public boolean test(@NonNull Integer integer) throws Exception {
//                        return integer % 20 == 0;
//                    }
//                })
                .sample(2, TimeUnit.SECONDS)//每两秒取样，上游事件有损失
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(@NonNull Integer integer) throws Exception {
                        Log.e(TAG, "accept: " + integer);
                    }
                });
    }

    private void zipTest() {
        Observable<Integer> observable1 = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                Log.e(TAG, "et: 1");
                e.onNext(1);
                Thread.sleep(1000);

                Log.e(TAG, "et: 2");
                e.onNext(2);
                Thread.sleep(1000);

                Log.e(TAG, "et: 3");
                e.onNext(3);
                Thread.sleep(1000);

                Log.e(TAG, "et: 4");
                e.onNext(4);
//                Thread.sleep(1000);

                Log.e(TAG, "et onComplete1");
                e.onComplete();
            }
        }).subscribeOn(Schedulers.io());
        Observable<String> observable2 = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                Log.e(TAG, "et: a");
                e.onNext("a");
                Thread.sleep(1000);

                Log.e(TAG, "et: b");
                e.onNext("b");
                Thread.sleep(1000);

                Log.e(TAG, "et: c");
                e.onNext("c");
                Thread.sleep(1000);

                Log.e(TAG, "et onComplete2");
                e.onComplete();
            }
        }).subscribeOn(Schedulers.io());

        Observable.zip(observable1, observable2, new BiFunction<Integer, String, String>() {
            @Override
            public String apply(@NonNull Integer integer, @NonNull String s) throws Exception {
                return integer + s;
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull String s) {
                        Log.e(TAG, "onNext: " + s);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "onComplete");
                    }
                });
    }

    private void mapTest(int flag) {
        switch (flag) {
            case 1:
                Observable.create(new ObservableOnSubscribe<Integer>() {
                    @Override
                    public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                        e.onNext(1);
                        e.onNext(2);
                        e.onNext(3);
                        e.onComplete();
                    }
                }).map(new Function<Integer, String>() {
                    @Override
                    public String apply(@NonNull Integer integer) throws Exception {
                        return String.valueOf(integer);
                    }
                }).subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<String>() {
                            @Override
                            public void accept(@NonNull String s) throws Exception {
                                Log.e(TAG, "accept: " + s);
                            }
                        });
                break;
            case 2:
                //flatMap无序发送，concatMap为严格按顺序发送
                Observable.create(new ObservableOnSubscribe<Integer>() {
                    @Override
                    public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                        e.onNext(1);
                        e.onNext(2);
                        e.onNext(3);
                        e.onComplete();
                    }
                }).flatMap(new Function<Integer, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(@NonNull Integer integer) throws Exception {
                        List<String> list = new ArrayList<>();
                        list.add("a");
                        list.add("b");
                        list.add("c");
                        list.add("d");
                        return Observable.fromIterable(list).delay
                                (100, TimeUnit.MILLISECONDS);
                    }
                }).subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<String>() {
                            @Override
                            public void accept(@NonNull String s) throws Exception {
                                Log.e(TAG, "accept: " + s);
                            }
                        });
                break;
            default:

                break;
        }

    }

    private void primary() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.e(TAG, "onSubscribe: ");
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                Log.e(TAG, "onNext: " + integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e(TAG, "onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete: " + "完成了");
            }
        });
    }
}
