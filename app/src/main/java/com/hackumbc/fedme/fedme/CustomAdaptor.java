package com.hackumbc.fedme.fedme;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;

/**
 * Created by Nikhil Kumar Mengani on 10/7/2017.
 */

public class CustomAdaptor extends ArrayAdapter<String> {

    ArrayList<String> dishIDArray ;
    ArrayList<String> dishNameArray;
    ArrayList<String> dishPlaceArray;
    ArrayList<String> dishCostArray;
    ArrayList<String> dishRatingsArray;

    private final Activity context;
    // private final String[] itemname;
    //private final Integer[] imgid;

    public CustomAdaptor(Activity context,  ArrayList<String> dishIDArray,ArrayList<String> dishNameArray,  ArrayList<String> dishPlaceArray,
                         ArrayList<String> dishCostArray, ArrayList<String> dishRatingsArray) {
        super(context, R.layout.list_items_layout, dishIDArray);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.dishIDArray=dishIDArray;
        this.dishNameArray= dishNameArray;
        this.dishPlaceArray= dishPlaceArray;
        this.dishCostArray = dishCostArray;
        this.dishRatingsArray=dishRatingsArray;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.list_items_layout, null,true);
        /*

        TextView txtTitle1 = (TextView) rowView.findViewById(R.id.Itemname1);
        TextView txtTitle2= (TextView) rowView.findViewById(R.id.Itemname2);
        TextView txtTitle3 = (TextView) rowView.findViewById(R.id.Itemname3);
        TextView txtTitle4 = (TextView) rowView.findViewById(R.id.Itemname4);
        TextView txtTitle5 = (TextView) rowView.findViewById(R.id.Itemname5);
        TextView txtTitle6 = (TextView) rowView.findViewById(R.id.Itemname6);
        // TextView txtTitle7 = (TextView) rowView.findViewById(R.id.Itemname7);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);

//        txtTitle1.setText(prettyFormatting("Food Name")  +foodnameArray.get(position));
//        txtTitle2.setText(prettyFormatting("Review")     +reviewArray.get(position));
//        txtTitle3.setText(prettyFormatting("Quality")    +foodqualityArray.get(position));
//        txtTitle4.setText(prettyFormatting("Price")      +foodPriceArray.get(position));
//        txtTitle5.setText(prettyFormatting("Service(10)")+foodserviceArray.get(position));
//        txtTitle6.setText(prettyFormatting("Rating(10)") +foodratingArray.get(position));
        //txtTitle1.setText(resIdArray.get(position));
        txtTitle1.setText(foodnameArray.get(position));
        txtTitle2.setText(reviewArray.get(position));
        txtTitle3.setText(foodqualityArray.get(position));
        txtTitle4.setText(foodPriceArray.get(position));
        txtTitle5.setText(foodserviceArray.get(position));
        txtTitle6.setText(foodratingArray.get(position));
        */
        TextView itemname = (TextView) rowView.findViewById(R.id.itemName);
        TextView placename =(TextView) rowView.findViewById(R.id.placeName);
        RatingBar ratingBar =(RatingBar)rowView.findViewById(R.id.ratingBar);
        TextView cost = (TextView)rowView.findViewById(R.id.cost);

        itemname.setText(dishNameArray.get(position));
        placename.setText(dishPlaceArray.get(position));
        ratingBar.setNumStars(Integer.parseInt(dishRatingsArray.get(position)));
        cost.setText(dishCostArray.get(position));
        return rowView;

    }



}
