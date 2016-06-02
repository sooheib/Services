package com.vivianaranha.services;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void startTheService(View v) {
        Intent i = new Intent(this, MyIntentService.class);
        startService(i);

    }

    public void goToNext(View v) {
        Intent i = new Intent(this, ThirdActivity.class);
        startActivity(i);
    }
}
