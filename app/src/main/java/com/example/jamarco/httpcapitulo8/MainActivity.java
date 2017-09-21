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

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI){
            a.setText("wifi connection");
        }
        else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE){
            a.setText("mobile connection");
        }
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
