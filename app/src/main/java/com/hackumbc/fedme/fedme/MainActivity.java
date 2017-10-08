package com.hackumbc.fedme.fedme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView img1,img2,img3;
    Button find,post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1 = (ImageView)findViewById(R.id.imageView);
        img2 = (ImageView)findViewById(R.id.imageView2);
        img3 = (ImageView)findViewById(R.id.imageView3);
        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        find = (Button)findViewById(R.id.button7);
        post=(Button)findViewById(R.id.button6);
        find.setOnClickListener(this);
        post.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageView:
                Intent filterActivityIntent = new Intent(this,OptionsActivity.class);
                startActivity(filterActivityIntent);
                break;
            case R.id.imageView2:
                Intent rateActivityIntent = new Intent(this,UserRatingActivity.class);
                startActivity(rateActivityIntent);
                break;
            case R.id.imageView3:
                Intent freeActivityIntent = new Intent(this, FreeFoodActivity.class);
                startActivity(freeActivityIntent);
                break;
            case R.id.button6:
                Intent postIntent = new Intent(this,PostFreeFood.class);
                startActivity(postIntent);
                break;
            case R.id.button7:
                Intent findfoodIntent = new Intent(this,FreeFoodActivity.class);
                startActivity(findfoodIntent);
                break;

        }
    }
}
