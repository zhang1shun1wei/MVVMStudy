package com.example.myapplication;

import android.util.Log;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

public class TestActivity {
    private final String TAG = TestActivity.class.getSimpleName();
    private Observable<Object> objectObservable;
    private AsyncSubject subject;
    private BehaviorSubject subject1;
    private ReplaySubject subject2;
    private PublishSubject subject3;

    public void main() {
//        objectObservable = Observable.create(new ObservableOnSubscribe<Object>() {
//            @Override
//            public void subscribe(ObservableEmitter<Object> emitter) throws Exception {
//                emitter.onNext(111);
//                emitter.onNext("2222");
//                emitter.onComplete();
//            }
//        });
//        objectObservable = Observable.just("111","2222","3333");
        //objectObservable = Observable.fromArray("111","2222","3333");
        ArrayList list = new ArrayList();
        list.add(111);
        list.add(112);
        list.add(113);
        list.add(114);
//        objectObservable = Observable.fromIterable(list).map(new Function() {
//            @Override
//            public Object apply(Object o) throws Exception {
//                return null;
//            }
//        });

//        objectObservable = Observable.fromIterable(list).map(o -> {
//            o = 11112222;
//            return o;
//        });
//        objectObservable = Observable.just("请求登陆").flatMap(new Function<String, ObservableSource<?>>() {
//            @Override
//            public ObservableSource<?> apply(String s) throws Exception {
//                return null;
//            }
//        });

        objectObservable = Observable.just("请求登陆").flatMap(s -> {
            Log.i(TAG, "main: ---->" + s);
            return Observable.just("登陆成功");
        });
        //使用obserable来监听
        //observerTest();
        //使用consumer来监听
        consumerTest();
    }

    private void consumerTest() {
        objectObservable.subscribe(new Consumer<Object>() {
            @Override
            public void accept(Object o) throws Exception {
                Log.i(TAG, "accept: --->" + o);
            }
        });
    }

    private void observerTest() {
        objectObservable.subscribe(new Observer<Object>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "onSubscribe: -->" + d);
            }

            @Override
            public void onNext(Object o) {
                Log.i(TAG, "onNext: -->" + o);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onError: -->" + e);
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
