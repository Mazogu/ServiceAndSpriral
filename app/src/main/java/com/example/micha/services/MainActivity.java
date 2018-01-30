package com.example.micha.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.micha.services.services.MyBoundService;
import com.example.micha.services.services.MyIntentService;
import com.example.micha.services.services.MyNormalService;

public class MainActivity extends AppCompatActivity {

    private MyBoundService myBoundService;
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handlingServices(View view) {
        Intent intentNormal = new Intent(getApplicationContext(), MyNormalService.class);
        Intent intentIntent = new Intent(getApplicationContext(), MyIntentService.class);
        Intent intentBound = new Intent(getApplicationContext(), MyBoundService.class);
        switch (view.getId()){
            case R.id.startNormal:
                intentNormal.putExtra("data", "Taco");
                startService(intentNormal);
                break;
            case R.id.stopNormal:
                stopService(intentNormal);
                break;
            case R.id.startIntentService:
                intentIntent.putExtra("data", "Taco Intent");
                startService(intentIntent);
                break;
            case R.id.bindService:
                bindService(intentBound,connection, Context.BIND_AUTO_CREATE);
                break;
            case R.id.unBindService:
                break;
        }
    }

    //create a service connection object
    ServiceConnection connection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MyBoundService.MyBinder myBinder = (MyBoundService.MyBinder) iBinder;
            myBoundService = myBinder.getServiceObject();
            myBoundService.init();
            Log.d(TAG, "onServiceConnected: "+ myBoundService.getData());
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
}
