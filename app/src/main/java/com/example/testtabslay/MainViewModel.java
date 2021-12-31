package com.example.testtabslay;

import android.util.Log;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    String message = "Initial Message";

    public MainViewModel() {
        Log.i("MainViewModel", "ViewModel is created");
    }

    @Override
    protected void onCleared(){
        super.onCleared();
        Log.i("MainViewModel","ViewModel is destroyed");
    }

}
