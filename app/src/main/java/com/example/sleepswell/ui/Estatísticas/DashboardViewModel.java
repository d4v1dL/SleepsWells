package com.example.sleepswell.ui.Estatísticas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DashboardViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DashboardViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Fragment de estatísticas");
    }

    public LiveData<String> getText() {
        return mText;
    }
}