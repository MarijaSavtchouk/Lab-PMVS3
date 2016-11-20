package com.bsu.mariacco.makeupapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                startActivity( new Intent(this, FirstActivity.class));
                break;
            case R.id.button2:
                startActivity(new Intent(this, SecondActivity.class));
                break;
            case R.id.button3:
                startActivity(new Intent(this, ThirdActivity.class));
                break;
            case R.id.button4:
                finish();
                break;
            default:
                break;
        }
    }
}
