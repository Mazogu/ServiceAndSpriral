package com.example.micha.services.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyBoundService extends Service {

    private String data;

    public MyBoundService() {
    }

    IBinder iBinder = new MyBinder();

    public class MyBinder extends Binder{
        public MyBoundService getServiceObject(){
            return MyBoundService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return iBinder;
    }

    public void init(){
        data = "Some data";
    }

    public String getData() {
        return data;
    }
}
