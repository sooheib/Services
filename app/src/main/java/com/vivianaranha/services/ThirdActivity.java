package com.vivianaranha.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    EditText et,et2;
    BindedService bindedService;
    boolean status;

    private ServiceConnection sc = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            BindedService.LocalBinder binder = (BindedService.LocalBinder) service;
            bindedService = binder.getService();
            status = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        et = (EditText) findViewById(R.id.editText);
        et2 = (EditText) findViewById(R.id.editText2);

    }

    public void addNumbers(View v) {
        if(status) {
            int num = Integer.parseInt(et.getText().toString());
            int num2 = Integer.parseInt(et2.getText().toString());
            int result = bindedService.addNumbers(num, num2);
            Toast.makeText(this, "RESULT: "+result, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Bind the Service First", Toast.LENGTH_LONG).show();
        }
    }

    public void bindService(View v) {
        Intent intent = new Intent(this, BindedService.class);
        bindService(intent, sc, Context.BIND_AUTO_CREATE);
        status = true;
        Toast.makeText(this, "Service Binded Successfully", Toast.LENGTH_LONG).show();


    }

    public void unBindService(View v) {
        if(status) {
            unbindService(sc);
            Toast.makeText(this, "Service unbinded successfully", Toast.LENGTH_LONG).show();
            status = false;

        } else {
            Toast.makeText(this, "Service already unbinded", Toast.LENGTH_LONG).show();
        }

    }

}
