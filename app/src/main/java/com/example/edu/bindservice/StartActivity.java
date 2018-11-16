package com.example.edu.bindservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity implements View.OnClickListener{


    private  MyBindService mServiceBinder;
    private ServiceConnection myConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            mServiceBinder = ((MyBindService.MyBinder)binder).getService();

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mServiceBinder = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Intent intent = new Intent(this, MyBindService.class);
        bindService(intent, myConnection, Context.BIND_AUTO_CREATE);

        ((Button)findViewById(R.id.buttonAPlay)).setOnClickListener(this);
        ((Button)findViewById(R.id.buttonAStop)).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonAPlay:
                Log.d("service","service start");
                mServiceBinder.play();
            break;
            case R.id.buttonAStop:
                Log.d("service","service stop");
                mServiceBinder.stop();
                unbindService(myConnection);
            break;
        }

    }

}
