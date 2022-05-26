package com.example.sleepswell.ui.Alarme;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private static MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();


    }

    public static LiveData<String> getText() {
        return mText;
    }
}