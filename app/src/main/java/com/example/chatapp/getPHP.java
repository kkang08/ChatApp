package com.example.chatapp;

import android.content.Intent;
import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class getPHP extends AsyncTask<Void,Void,String> {

    final static private String url_data = "http://kkang.dothome.co.kr/imformation.php";

    String temp;

    @Override
    protected String doInBackground(Void... voids) {
        try{
            URL url = new URL(url_data);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            InputStream inputStream = httpURLConnection.getInputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer stringBuffer = new StringBuffer();

            while((temp = bufferedReader.readLine()) != null){
                stringBuffer.append(temp+"\n");
            }

            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();

            return stringBuffer.toString().trim();

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
