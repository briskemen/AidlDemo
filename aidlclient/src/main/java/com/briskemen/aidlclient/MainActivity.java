package com.briskemen.aidlclient;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.briskemen.aidldemo.IMyAidlInterface;

public class MainActivity extends AppCompatActivity {

    private EditText mEtNum1;
    private EditText mEtNum2;
    private EditText mEtRes;

    private IMyAidlInterface mMyAidlInterface;
    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mMyAidlInterface = IMyAidlInterface.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mMyAidlInterface = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEtNum1 = (EditText) findViewById(R.id.et_num1);
        mEtNum2 = (EditText) findViewById(R.id.et_num2);
        mEtRes = (EditText) findViewById(R.id.et_res);

        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.briskemen.aidldemo",
                "com.briskemen.aidldemo.IMyAidlService"));
        bindService(intent, conn, Context.BIND_AUTO_CREATE);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int num1 = Integer.parseInt(mEtNum1.getText().toString());
               int num2 = Integer.parseInt(mEtNum2.getText().toString());
                try {
                    int res = mMyAidlInterface.add(num1, num2);
                    mEtRes.setText(res+"");
                } catch (RemoteException e) {
                    e.printStackTrace();
                    mEtRes.setText("出错了");
                }

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(conn);
    }
}
