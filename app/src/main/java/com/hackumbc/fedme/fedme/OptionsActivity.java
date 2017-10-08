package com.hackumbc.fedme.fedme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class OptionsActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView alphabet,price,rating,location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        alphabet = (ImageView) findViewById(R.id.imageView4);
        location= (ImageView) findViewById(R.id.imageView5);
        price = (ImageView) findViewById(R.id.imageView6);
        rating= (ImageView) findViewById(R.id.imageView7);
        alphabet.setOnClickListener(this);
        price.setOnClickListener(this);
        rating.setOnClickListener(this);
        location.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageView4:
                Intent intent1 = new Intent(this,FilterListActivity.class);
                intent1.putExtra("tag","0");
                intent1.putExtra("option","1");
                startActivity(intent1);

                break;
            case R.id.imageView5:

                Intent intent2 = new Intent(this,PlacesActivity.class);
                startActivity(intent2);

                break;
            case R.id.imageView6:
                Intent intent3 = new Intent(this,FilterListActivity.class);
                intent3.putExtra("tag","0");
                intent3.putExtra("option", "2");
                startActivity(intent3);

                break;
            case R.id.imageView7:
                Intent intent4 = new Intent(this,FilterListActivity.class);
                intent4.putExtra("tag","0");
                intent4.putExtra("option", "3");
                startActivity(intent4);

                break;

        }
    }
}
