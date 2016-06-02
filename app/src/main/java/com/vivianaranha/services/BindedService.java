package com.vivianaranha.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by vivianaranha on 1/23/16.
 */
public class BindedService extends Service {

    private final IBinder mBinder = new LocalBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public class LocalBinder extends Binder {

        public BindedService getService(){
            return BindedService.this;
        }

    }

    public int addNumbers(int x, int y){
        return x+y;
    }

}
