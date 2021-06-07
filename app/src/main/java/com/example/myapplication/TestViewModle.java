package com.example.myapplication;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TestViewModle extends BaseViewMoudle {
    private MutableLiveData<Integer> liveData;

    public TestViewModle(Application application) {
        super(application);
    }

    public MutableLiveData<Integer> getLiveData() {
        if (liveData == null) {
            liveData = new MutableLiveData<>();
            liveData.setValue(0);
        }
        return liveData;
    }

    public void setLiveData(int n) {
        liveData.setValue(liveData.getValue() + n);
    }
}
