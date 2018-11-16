package com.example.edu.bindservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

public class MyBindService extends Service{

    MediaPlayer mPlayer;

    @Override
    public IBinder onBind(Intent arg0) {
        return new MyBinder();
    }

    public class MyBinder extends Binder{
        MyBindService getService(){
            return  MyBindService.this;
        }
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("service", "Service Created");
    }

    public void play(){
        mPlayer = MediaPlayer.create(this,R.raw.thunder_rain);
        mPlayer.setLooping(true);
        mPlayer.setVolume(100,100);
        mPlayer.start();
    }
    public void stop(){
        mPlayer.stop();
        mPlayer.release();
    }

}


