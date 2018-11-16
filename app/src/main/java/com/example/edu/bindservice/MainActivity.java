package com.example.edu.bindservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button)findViewById(R.id.buttonMainPlay)).setOnClickListener(this);
        ((Button)findViewById(R.id.buttonMainStop)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonMainPlay:
                Log.d("service","activity first");
                Intent intent = new Intent(this,StartActivity.class);
                startActivity(intent);
            break;
            case R.id.buttonMainStop:
                Log.d("service","service stop");
 //               unbindService(myConnection);

                break;
        }

    }
}
