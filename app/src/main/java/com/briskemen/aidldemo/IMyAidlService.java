package com.briskemen.aidldemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

/**
 * ============================================================
 * Copyright：${TODO}有限公司版权所有 (c) 2017
 * Author：   卢俊霖
 * Email：    briskemen@163.com
 * GitHub：   https://github.com/briskemen
 * Project_Name：AidlDemo
 * Package_Name：com.briskemen.aidldemo
 *
 * @des TODO
 * Version：1.0
 * time：2017/9/5 22:27
 * ============================================================
 **/
public class IMyAidlService extends Service{
    @Override
    public IBinder onBind(Intent intent) {
        return mIBinder;

    }

    private IBinder mIBinder = new IMyAidlInterface.Stub() {
        @Override
        public int add(int num1, int num2) throws RemoteException {
            Log.e("tag", "已经接收到的数据是"+num1+"和"+num2);
            return num1+num2;
        }
    };
}
