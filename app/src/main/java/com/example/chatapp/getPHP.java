package com.example.chatapp;

import android.os.AsyncTask;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class getPHP extends AsyncTask<String,Void,String> {

    final static private String url_data = "http://kkang.dothome.co.kr/imformation.php";
    String jsonString, i, url_get, jsonData;
    String returnText = "";

    private static final String TAG_Name = "userName";
    private static final String TAG_Email = "userEmail";

    private ArrayList<HashMap<String, String>> arrayList;


    @Override
    protected String doInBackground(String... strings) {
        try {
            URL url = new URL(url_get);
            HttpURLConnection conn =  (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Name", "name");
            conn.setRequestProperty("Email","email");
            conn.setRequestProperty("Accept","applicatin/json");
            conn.setRequestMethod("GET");
            conn.connect();

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuffer sb = new StringBuffer();

            while ((jsonData = br.readLine())!= null) {
                sb.append(jsonData);
            }
            returnText =sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //return null;
        return returnText;
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

                String name =  jO.getString(TAG_Name);
                String email = jO.getString(TAG_Email);

                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put(TAG_Name,name);
                hashMap.put(TAG_Email,email);

                arrayList.add(hashMap);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
