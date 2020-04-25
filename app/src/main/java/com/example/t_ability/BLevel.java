package com.example.t_ability;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BLevel extends AppCompatActivity {

    androidx.appcompat.widget.Toolbar toolbarB;
    ListView listViewB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_level);

        toolbarB =(Toolbar) findViewById(R.id.IdToolbar);
        toolbarB.setTitle(getResources().getString(R.string.app_name));
        listViewB =(ListView)findViewById(R.id.LVIdB);

        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(BLevel.this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.tansuB));

        listViewB.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(BLevel.this, Btansu.class);
                intent.putExtra("Btansu", listViewB.getItemAtPosition(position).toString());
                startActivity(intent);

            }

        });
        listViewB.setAdapter(mAdapter);
    }
}