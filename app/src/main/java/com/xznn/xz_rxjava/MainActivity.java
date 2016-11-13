package com.xznn.xz_rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;

// 给 Android 开发者的 RxJava 详解 -
// http://gank.io/post/560e15be2dca930e00da1083#toc_1

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        1) 创建 Observer :
        // new Observer
        Observer<String> observer1 =  newObserver_1();
        // new Subscriber (Subscriber 是对 Observer 接口进行了一些扩展)
        Observer<String> observer2 =  newSubscriber_2();

//        2) 创建 Observable
        // new Observer
        Observable<String> observable1 = newObservableByCreate_1();
        // new Subscriber (Subscriber 是对 Observer 接口进行了一些扩展)
        Observable<String> observable2 = newObservableByJust_2();

//        3) Subscribe (订阅)
        observable1.subscribe(observer1);
        observable2.subscribe(observer2);

        //------------------------------------------
//        不完整定义的回调，RxJava 会自动根据定义创建出 Subscriber 。

        observable1.subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d(TAG, "不完整定义 newObserver_1()...s = " + s);
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {

            }
        }, new Action0() {
            @Override
            public void call() {

            }
        });



        //------------------------------------------


    }

    private Observer<String> newObserver_1() {
       return new Observer<String>() {

            @Override
            public void onCompleted() {
                Log.d(TAG, "====== MainActivity{}... onCompleted() ======");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "====== MainActivity{}... onError() ======");
            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "newObserver_1()...s = " + s);
            }
        };
    }

    private Observer<String> newSubscriber_2() {
        return new Subscriber<String>() {
            @Override
            public void onStart() {
                super.onStart();
            }


            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "newSubscriber_2()...s = " + s);
            }
        };
    }

    private Observable<String> newObservableByCreate_1() {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("I");
                subscriber.onNext("Love");
                subscriber.onNext("You");
                subscriber.onCompleted();
            }
        });
    }

    private Observable<String> newObservableByJust_2() {
        return Observable.just("new", "Observable", "ByJust");
    }



}
