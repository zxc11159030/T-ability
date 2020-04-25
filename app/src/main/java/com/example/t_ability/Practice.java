package com.example.t_ability;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Practice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        Button btPraA =(Button)findViewById(R.id.btIdPraA);
        Button btPraB =(Button)findViewById(R.id.btIdPraB);
        Button btPraC =(Button)findViewById(R.id.btIdPraC);
        btPraA.setOnClickListener(btPraAListener);
        btPraB.setOnClickListener(btPraBListener);
        btPraC.setOnClickListener(btPraCListener);

    }

    private Button.OnClickListener btPraAListener =
            new Button.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setClass(Practice.this, Apra.class);
                    startActivity(intent);

                }
            };
    private Button.OnClickListener btPraBListener =
            new Button.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setClass(Practice.this, ALevel.class);
                    startActivity(intent);

                }
            };
    private Button.OnClickListener btPraCListener =
            new Button.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setClass(Practice.this, ALevel.class);
                    startActivity(intent);

                }
            };
}
