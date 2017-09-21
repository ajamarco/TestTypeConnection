package com.example.jamarco.httpcapitulo8;

import android.os.AsyncTask;

import java.util.List;

/**
 * Created by Jamarco on 9/20/2017.
 */

public class MyTask extends AsyncTask<String,Void,List<String>> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<String> doInBackground(String... params) {
        return null;
    }

    @Override
    protected void onPostExecute(List<String> strings) {
        super.onPostExecute(strings);
    }
}
