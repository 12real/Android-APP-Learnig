package com.example.a26024.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstActivity.this,"Start!",Toast.LENGTH_SHORT).show();
                String data = "1";
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                //intent.addCategory("com.example.activitytest.MY_CATEGORY");
                //intent.setData(Uri.parse("http://www.baidu.com"));
                intent.putExtra("extra_data",data);
                startActivityForResult(intent,2);
            }
        });
    }
    String returneddata;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch(requestCode) {
            case 2:
                if(resultCode == RESULT_OK)
                    returneddata = data.getStringExtra("data_return");
                    Toast.makeText(FirstActivity.this,returneddata+"3",Toast.LENGTH_SHORT).show();
                default:
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.add_item:
                Toast.makeText(this,"you clicked Add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
               finish();
               break;
               default:
        }
        return true;
    }
}
