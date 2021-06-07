package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.AsyncSubject;

public class MainActivity extends BaseActivity<TestViewMoudle> implements TestViewMoudleInterface{

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.zsw_test_view);
        printf();
        mViewMoudle.mutableStringViewMoudle.observe(this, observer -> {
            mTextView.setText(observer);
        });
//        //mTestViewModle = ViewModelProviders.of(this).get(TestViewModle.class);
//        mTestViewModle = new ViewModelProvider(this).get(TestViewModle.class);
//        mTestViewModle.getLiveData().observe(this, new Observer<Integer>() {
//            @Override
//            public void onChanged(Integer integer) {
//                mTextView.setText(String.valueOf(integer));
//            }
//        });
//        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mTestViewModle.setLiveData(1);
//            }
//        });
//
//        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mTestViewModle.setLiveData(2);
//            }
//        });
//        AsyncSubject subject = AsyncSubject.create();
//        subject.onNext(11111);
//        subject.onNext(22222);
//        subject.onNext(333333);
//        subject.onComplete();
//        subject.subscribe(new Consumer() {
//            @Override
//            public void accept(Object o) throws Exception {
//                Log.i("TAG", "accept---->" + o);
//            }
//        });

//        findViewById(R.id.test_ceshi).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
//                startActivity(intent);
//            }
//        });
//        Observable.create(new ObservableOnSubscribe<Object>() {
//            @Override
//            public void subscribe(ObservableEmitter<Object> emitter) throws Exception {
//                emitter.onNext(11111);
//                emitter.onNext(11111);
//            }
//        }).subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<Object>() {
//                    @Override
//                    public void accept(Object o) throws Exception {
//                        Log.i("TAG", "accept: ");
//                    }
//                });
//        TestActivity testActivity = new TestActivity();
//        testActivity.main();
    }

    @Override
    public void printf() {
        mViewMoudle.printf();
    }
}