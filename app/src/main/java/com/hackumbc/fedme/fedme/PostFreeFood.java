package com.hackumbc.fedme.fedme;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostFreeFood extends AppCompatActivity implements View.OnClickListener {

    EditText eventName,location,time;
    Button post;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_free_food);
        eventName =(EditText)findViewById(R.id.editText);
        location =(EditText)findViewById(R.id.editText2);
        time =(EditText)findViewById(R.id.editText3);
        post =(Button)findViewById(R.id.button4);
        post.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button4:

                new PostFreeFood.InvokeWeService().execute(eventName.getText().toString(),location.getText().toString(),time.getText().toString());
                Toast.makeText(getApplicationContext(), "Succesfully Posted",
                        Toast.LENGTH_LONG).show();
                Intent reverse = new Intent(this,MainActivity.class);
                startActivity(reverse);

        }
    }
    public class InvokeWeService extends AsyncTask<String,Integer,String>
    {
        @Override
        protected String doInBackground(String... strings) {
            URL url;
            String response = "";
            String requestUrl = "http://ec2-54-213-169-9.us-west-2.compute.amazonaws.com/postfreefood.php";
            StringBuilder str = new StringBuilder();
            StringBuilder result = new StringBuilder();
            //str.append("test=" + "parameter&");
            str.append("?eventname="+strings[0]+"&location=" + strings[1]+"&time="+strings[2]);
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



                }




        }

}
