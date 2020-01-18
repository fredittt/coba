package com.example.rpl2016_09.coba;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

/**
 * Created by RPL2016-09 on 10/22/2019.
 */

public class App extends Application {
    public void onCreate(){
        super.onCreate();

        AndroidNetworking.initialize(this);
    }
}
