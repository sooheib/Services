package com.vivianaranha.services;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startTheService(View v) {
        Intent intent = new Intent(this, SimpleService.class);
        intent.putExtra("message", "This is From MainActivity");
        startService(intent);
    }

    public void stopTheService(View v) {
        stopService(new Intent(this, SimpleService.class));

    }

    public void goToNext(View v) {
        Intent i = new Intent(this, SecondActivity.class);
        startActivity(i);
    }



}
