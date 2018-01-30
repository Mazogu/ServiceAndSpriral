package com.example.micha.services.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyNormalService extends Service {
    public static final String TAG = MyNormalService.class.getSimpleName();
    public MyNormalService() {
    }

    //Binds to a component that wishes to bind with the service.
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: "+intent.getStringExtra("data"));
        //do the task
        stopSelf();//After task is complete service ends itself. It would just continue going otherwise.
        return super.onStartCommand(intent, flags, startId);
    }

    //Is called when stopSelf or stopService is called.
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
