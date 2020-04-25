package com.example.t_ability;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.ImageView;

public class Btansu extends AppCompatActivity {

    Toolbar mToolbar;
    ImageView tansu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btansu);

        mToolbar = (Toolbar) findViewById(R.id.IdToolbar1);
        tansu = (ImageView) findViewById(R.id.IdImageView);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            mToolbar.setTitle(bundle.getString("Btansu"));
            if (mToolbar.getTitle().toString().equalsIgnoreCase("一旦")){
                tansu.setImageDrawable(ContextCompat.getDrawable(Btansu.this,
                        R.drawable.tansu_7));
            }else if (mToolbar.getTitle().toString().equalsIgnoreCase("一目𥍉仔")){
                tansu.setImageDrawable(ContextCompat.getDrawable(Btansu.this,
                        R.drawable.tansu_7));

            }
        }

    }
}
