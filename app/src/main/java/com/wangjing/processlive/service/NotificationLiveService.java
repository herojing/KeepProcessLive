package com.wangjing.processlive.service;

import android.annotation.TargetApi;
import android.os.Build;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;


@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
public class NotificationLiveService extends NotificationListenerService {

    public NotificationLiveService() {

    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
    }
}
