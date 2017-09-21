package com.example.jamarco.httpcapitulo8;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

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
}
