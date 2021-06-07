package com.example.myapplication;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BaseViewMoudle extends AndroidViewModel {
    public BaseViewMoudle(Application application) {
        super(application);
    }

    protected MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
}
