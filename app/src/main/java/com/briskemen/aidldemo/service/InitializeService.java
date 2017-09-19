package com.briskemen.aidldemo.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

/**
 * ============================================================
 * Copyright：${TODO}有限公司版权所有 (c) 2017
 * Author：   卢俊霖
 * Email：    briskemen@163.com
 * GitHub：   https://github.com/briskemen
 * Project_Name：AidlDemo
 * Package_Name：com.briskemen.aidldemo.service
 *
 * @des TODO
 * Version：1.0
 * time：2017/9/19 21:46
 * ============================================================
 **/
public class InitializeService extends IntentService{
    private static final String ACTION_INIT_WHEN_APP_CREATE = "com.briske";


    public static void start(Context context){
        Intent intent = new Intent(context,InitializeService.class);
        intent.setAction(ACTION_INIT_WHEN_APP_CREATE);
        context.startService(intent);
    }
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     */
    public InitializeService() {
        super("InitializeService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent!=null){
            String action = intent.getAction();
            if (ACTION_INIT_WHEN_APP_CREATE.equals(action)){
                performInit();
            }
        }
    }

    /**
     * 准备初始化
     */
    private void performInit() {

    }
}
