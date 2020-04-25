package com.example.t_ability;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btOk=(Button)findViewById(R.id.btIdOk);
        btOk.setOnClickListener(btListenter);

    }
    private Button.OnClickListener btListenter =
            new Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent();
                    intent.setClass(MainActivity.this, SecondActivity.class);
                    startActivity(intent);

                }


            };
}
