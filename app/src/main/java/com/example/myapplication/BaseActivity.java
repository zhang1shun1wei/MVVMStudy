package com.example.myapplication;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.ViewModelProviders;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class BaseActivity<T extends BaseViewMoudle> extends AppCompatActivity {
    protected T mViewMoudle;

    @NonNull
    private Class<T> getViewModelClass() {
        Type type = getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            Type[] args = ((ParameterizedType) type).getActualTypeArguments();
            if (args.length > 0) {
                return (Class<T>) args[0];
            }
        }
        return (Class<T>) BaseViewMoudle.class;
    }

    private <T extends BaseViewMoudle> T getViewModel(@NonNull Class<T> modelClass) {
        T t = ViewModelProviders.of(this).get(modelClass);
        return t;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mViewMoudle = ViewModelProviders.of(this).get();
        mViewMoudle = getViewModel(getViewModelClass());
//        Class<T> viewModelClass = getViewModelClass();
        Log.i("TAG", "onCreate:-->viewModelClass" + mViewMoudle.toString());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}
