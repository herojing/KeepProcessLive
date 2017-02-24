package com.wangjing.processlive.manager;

import android.app.Activity;
import android.content.Context;

import com.wangjing.processlive.LiveActivity;

import java.lang.ref.WeakReference;

/**
 * Created by LooperJing on 2017/2/19.
 */

public class ScreenManager {

    private Context mContext;

    private WeakReference<Activity> mActivityWref;

    public static ScreenManager gDefualt;

    public static ScreenManager getInstance(Context pContext) {
        if (gDefualt == null) {
            gDefualt = new ScreenManager(pContext.getApplicationContext());
        }
        return gDefualt;
    }
    private ScreenManager(Context pContext) {
        this.mContext = pContext;
    }

    public void setActivity(Activity pActivity) {
        mActivityWref = new WeakReference<Activity>(pActivity);
    }

    public void startActivity() {
            LiveActivity.actionToLiveActivity(mContext);
    }

    public void finishActivity() {
        //结束掉LiveActivity
        if (mActivityWref != null) {
            Activity activity = mActivityWref.get();
            if (activity != null) {
                activity.finish();
            }
        }
    }
}
