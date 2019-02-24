package com.example.a26024.activitytest;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.concurrent.Delayed;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent_1 = getIntent();
        String data = ((Intent) intent_1).getStringExtra("extra_data");
        data += "2";
        Toast.makeText(SecondActivity.this,data,Toast.LENGTH_SHORT).show();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent_2 = new Intent();
                intent_2.putExtra("data_return","12");
                setResult(RESULT_OK,intent_2);
                finish();
            }
        }, 3000);//3秒后执行Runnable中的run方法


    }
}
