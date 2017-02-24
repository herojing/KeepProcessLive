package com.wangjing.processlive.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.wangjing.processlive.ScreenBroadcastListener;
import com.wangjing.processlive.manager.ScreenManager;

/**
 * Created by LooperJing on 2017/2/19.
 */

public class OnePixLiveService extends Service {

    public static final String TAG = OnePixLiveService.class.getSimpleName();

    public static void toLiveService(Context pContext) {
        Intent intent = new Intent(pContext, OnePixLiveService.class);
        pContext.startService(intent);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        //屏幕关闭的时候启动一个1像素的Activity，开屏的时候关闭Activity
        final ScreenManager screenManager = ScreenManager.getInstance(OnePixLiveService.this);
        ScreenBroadcastListener listener = new ScreenBroadcastListener(this);
        listener.registerListener(new ScreenBroadcastListener.ScreenStateListener() {
            @Override
            public void onScreenOn() {
                Log.e(TAG, "onScreenOn");
                screenManager.finishActivity();
            }

            @Override
            public void onScreenOff() {
                Log.e(TAG, "onScreenOff");
                screenManager.startActivity();
            }
        });
        return START_REDELIVER_INTENT;
    }
}
