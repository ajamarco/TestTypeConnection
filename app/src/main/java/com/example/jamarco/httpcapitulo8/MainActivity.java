package com.example.jamarco.httpcapitulo8;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView a = (TextView) findViewById(R.id.textview);

        //create a new ConnectivityManager which gives info about the device's connections
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        //get the active network
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        //if the type of network is WIFI
        if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI){
            a.setText("wifi connection");
        }
        //if the type of network is mobile
        else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE){
            a.setText("mobile connection");
        }
        //if the type of network is another type of connection
        else {
            a.setText("unknow connection");
        }

    }

    //check if there is some connection regardless if it's wifi, mobile, etc
    public boolean hasConnection(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        if (activeNetwork != null && activeNetwork.isConnected()){
            return true;
        }
        else{
            return false;
        }
    }

    //establishing a connection
    private List<String> downloadString(String webAddress){
        final int SECONDS = 1000;
        try{
            URL url = new URL(webAddress);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(10 * SECONDS);
            connection.setConnectTimeout(15 * SECONDS);
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.setDoOutput(false);
            connection.connect();

            int answer = connection.getResponseCode();
            if (answer == HttpURLConnection.HTTP_OK){
                InputStream is = connection.getInputStream();

                List<String> strings = new ArrayList<>();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                String s = null;
                while ((s = reader.readLine()) != null){
                    strings.add(s);
                }

                return  strings;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
