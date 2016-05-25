package com.zoukloans.abhishek.zoukbudy.creditapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.GridView;

import com.zoukloans.abhishek.zoukbudy.R;

public class LandingActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        GridView iconGridView = (GridView)findViewById(R.id.gridview);
        iconGridView.setAdapter(new IconsAdapter(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


}
