package com.hackumbc.fedme.fedme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OptionsActivity extends AppCompatActivity implements View.OnClickListener {

    Button alphabet,cost,rating,places;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        alphabet = (Button) findViewById(R.id.button4);
        cost = (Button) findViewById(R.id.button5);
        rating = (Button) findViewById(R.id.button6);
        places = (Button) findViewById(R.id.button7);
        alphabet.setOnClickListener(this);
        cost.setOnClickListener(this);
        rating.setOnClickListener(this);
        places.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button4:
                Intent intent1 = new Intent(this,FilterListActivity.class);
                intent1.putExtra("option","1");
                startActivity(intent1);

                break;
            case R.id.button5:
                Intent intent2 = new Intent(this,FilterListActivity.class);
                intent2.putExtra("option", "2");
                startActivity(intent2);

                break;
            case R.id.button6:
                Intent intent3 = new Intent(this,FilterListActivity.class);
                intent3.putExtra("option", "3");
                startActivity(intent3);

                break;
            case R.id.button7:
                Intent intent4 = new Intent(this,PlacesActivity.class);
                //intent4.putExtra("option", 1);
                startActivity(intent4);

                break;

        }
    }
}
