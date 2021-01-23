package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.sql.SQLData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ChatMainActivitiy extends AppCompatActivity {

    private ArrayList<UserData> arrayList;
    private RecyclerAdapter recyclerAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    final static private String url_data = "http://kkang.dothome.co.kr/imformation.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_main_activitiy);

        recyclerView = findViewById(R.id.RecyclerView);
        arrayList = new ArrayList<>();

        /*try {
            JSONObject jsonObject = new JSONObject(url_data);
            JSONArray jsonArray = jsonObject.getJSONArray("userName");
            JSONArray jsonArray1 = jsonObject.getJSONArray("userEmail");

            System.out.println("userName"+jsonArray+"userEmail"+jsonArray1);
        } catch (JSONException e) {
            e.printStackTrace();
        }*/
        //arrayList.add(a);
       //arrayList.add(R.id.image, URL.setURLStreamHandlerFactory("userName"));

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerAdapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(recyclerAdapter);

       // getphp = new getPHP();
       // getphp.execute("http://kkang.dothome.co.kr/imformation.php");



        //System.out.println(arrayList);
        //arrayList.get(getphp);
        //Toast.makeText(getApplicationContext(),"확인: 왜 안됨? "+getphp,Toast.LENGTH_LONG).show();
      //  System.out.println(getphp);

        //Toast.makeText(getApplicationContext(),"여기까진 되는듯#1",Toast.LENGTH_SHORT).show();
      //  mA = (MainActivity)getApplicationContext();
        /*UserData userData = new UserData(R.id.image,mA.userID,mA.userPassword);
        arrayList.add(userData);
        recyclerAdapter.notifyDataSetChanged();*/
/*
        try {
            Toast.makeText(getApplicationContext(),"여기까진 되는듯#1-1",Toast.LENGTH_SHORT).show();
            JSONObject jsonObject = new JSONObject("response");
            Toast.makeText(getApplicationContext(),"여기까진 되는듯#1-2",Toast.LENGTH_SHORT).show();
            JSONArray jsonArray = jsonObject.getJSONArray(("response"));
            Toast.makeText(getApplicationContext(),"여기까진 되는듯#1-3",Toast.LENGTH_SHORT).show();
            int count =0;
            String userName, userEmail;
            while(count < jsonArray.length())
            {
                JSONObject object = jsonArray.getJSONObject(count);
                userName = object.getString("userName");
                userEmail = object.getString("userEmail");
                UserData user = new UserData(R.layout.user_image, userName,userEmail);
                arrayList.add(user);
                recyclerAdapter.notifyDataSetChanged();//(-)

                Toast.makeText(getApplicationContext(),"여기까진 되는듯#2",Toast.LENGTH_SHORT).show();
                count++;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
*/
    }
}