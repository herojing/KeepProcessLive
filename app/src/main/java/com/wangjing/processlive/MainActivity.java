package com.wangjing.processlive;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wangjing.processlive.service.OnePixLiveService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OnePixLiveService.toLiveService(this);


       // Intent intent=new Intent(this,ForegroundLiveService.class);
        //startService(intent);

        // Intent intent=new Intent(this,NotificationLiveService.class);
        //startService(intent);

        // Intent intent=new Intent(this,MyJobService.class);
        //startService(intent);
    }
}
