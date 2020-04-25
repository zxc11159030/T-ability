package com.example.t_ability;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Dictionary;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btA = (Button) findViewById(R.id.btIdA);
        Button btB = (Button) findViewById(R.id.btIdB);
        Button btC = (Button) findViewById(R.id.btIdC);
        Button btP = (Button) findViewById(R.id.btIdPractice);
        btA.setOnClickListener(btAListener);
        btB.setOnClickListener(btBListener);
        btC.setOnClickListener(btCListener);
        btP.setOnClickListener(btPListener);

    }

    private Button.OnClickListener btAListener =
            new Button.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setClass(SecondActivity.this, ALevel.class);
                    startActivity(intent);

                }
            };
    private Button.OnClickListener btBListener =
            new Button.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setClass(SecondActivity.this, BLevel.class);
                    startActivity(intent);
                }
            };
    private Button.OnClickListener btCListener =
            new Button.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setClass(SecondActivity.this, CLevel.class);
                    startActivity(intent);
                }
            };
    private Button.OnClickListener btPListener =
            new Button.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setClass(SecondActivity.this, Practice.class);
                    startActivity(intent);
                }
            };

    public void Taiwan(View view) {
        Uri uri = Uri.parse("https://twblg.dict.edu.tw/holodict_new/default.jsp");//要跳轉的網址
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }


}
