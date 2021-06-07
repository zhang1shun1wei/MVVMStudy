package com.example.myapplication;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

public class TestViewMoudle extends BaseViewMoudle implements TestViewMoudleInterface {
    public MutableLiveData<String> mutableStringViewMoudle = new MutableLiveData<>();

    public TestViewMoudle(Application application) {
        super(application);
    }

    @Override
    public void printf() {
        mutableStringViewMoudle.postValue("我这个代码写成功");
    }
}
