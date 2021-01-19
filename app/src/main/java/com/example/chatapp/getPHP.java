package com.example.chatapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class getPHP extends AsyncTask<String,Void,String> {

    final static private String url_data = "http://kkang.dothome.co.kr/imformation.php";
    String jsonString, i;
    private ArrayList<UserData> arrayList;


    @Override
    protected String doInBackground(String... strings) {
        //String server = params[0];

        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        jsonString = s;
        showS();
    }

    private void showS() {

        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray jsonArray = jsonObject.getJSONArray("userName");
            JSONArray jsonArray1 = jsonObject.getJSONArray("userEmail");

            while (i != null) {
                JSONObject jO = jsonObject.getJSONObject(i);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
