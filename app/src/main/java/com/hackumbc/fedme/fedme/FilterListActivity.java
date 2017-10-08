package com.hackumbc.fedme.fedme;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class FilterListActivity extends AppCompatActivity {

    ListView list;
    ArrayList<String> dishIDArray = new ArrayList<String>();
    ArrayList<String> dishNameArray= new ArrayList<String>();;
    ArrayList<String> dishPlaceArray= new ArrayList<String>();;
    ArrayList<String> dishCostArray= new ArrayList<String>();;
    ArrayList<String> dishRatingsArray= new ArrayList<String>();;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_list);
        Intent fromOptionsIntent= (Intent)getIntent();
        String tag = fromOptionsIntent.getStringExtra("tag");
        String ID = fromOptionsIntent.getStringExtra("option");
        //Log.v("m",ID);
        new FilterListActivity.InvokeWeService().execute(tag,ID);
    }

    void callAdaptor()
    {
        CustomAdaptor adapter=new CustomAdaptor(this, dishIDArray,dishNameArray,dishPlaceArray,dishCostArray);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);


    }

    public class InvokeWeService extends AsyncTask<String,Integer,String>
    {
        @Override
        protected String doInBackground(String... strings) {
            URL url;
            String response = "";
            String requestUrl = "http://ec2-54-213-169-9.us-west-2.compute.amazonaws.com/get_by_option.php";
            StringBuilder str = new StringBuilder();
            StringBuilder result = new StringBuilder();
            //str.append("test=" + "parameter&");
            str.append("?tag="+strings[0]+"&option=" + strings[1]);
            String mystring = str.toString();
            requestUrl = requestUrl +mystring;
            try {
                url = new URL(requestUrl);
                HttpURLConnection myconnection = (HttpURLConnection) url.openConnection();
                myconnection.setReadTimeout(15000);
                myconnection.setConnectTimeout(15000);
                myconnection.setRequestMethod("GET");
                myconnection.setDoInput(true);
                myconnection.setDoOutput(true);

                if (200 == HttpURLConnection.HTTP_OK) ;
                {


                    InputStream in = url.openStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                    String line;
                    while((line = reader.readLine()) != null) {
                        result.append(line);
                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return result.toString();


        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);


            JSONArray jsonArray = null;
            try {
                jsonArray = new JSONArray(s);

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject innerJsonObject = jsonArray.getJSONObject(i);
                    String dishID = innerJsonObject.getString("item_id");
                    String dishName = innerJsonObject.getString("item_name");
                    String place = innerJsonObject.getString("place");
                    String cost = innerJsonObject.getString("cost");
                    String rating = innerJsonObject.getString("rating");
                    dishIDArray.add(dishID);
                    dishNameArray.add(dishName);
                    dishCostArray.add(cost);
                    dishPlaceArray.add(place);
                    dishRatingsArray.add(rating);

//                    switch (i) {
//                        case 0:
//                            addingElementsToArray(dishIDArray, innerJsonArray);
//                            break;
//                        case 1:
//                            addingElementsToArray(dishNameArray, innerJsonArray);
//                            break;
//                        case 2:
//                            addingElementsToArray(dishPlaceArray, innerJsonArray);
//                            break;
//                        case 3:
//                            addingElementsToArray(dishCostArray, innerJsonArray);
//                            break;
//                        case 4:
//                            addingElementsToArray(dishRatingsArray, innerJsonArray);
//
//                    }
                    // String
                    // urls.add(image_comment);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            callAdaptor();

        }
    }

    void addingElementsToArray(ArrayList<String> al,JSONArray jsonArray){
        for(int i=0;i<jsonArray.length();i++){
            try {
                al.add(jsonArray.getString(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }


}
