package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

public class ChatMainActivitiy extends AppCompatActivity {

    private ArrayList<UserData> arrayList;
    private RecyclerAdapter recyclerAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    //private MainActivity mA;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_main_activitiy);

        recyclerView = findViewById(R.id.RecyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        arrayList = new ArrayList<>();

        recyclerAdapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(recyclerAdapter);

      //  mA = (MainActivity)getApplicationContext();
        /*UserData userData = new UserData(R.id.image,mA.userID,mA.userPassword);
        arrayList.add(userData);
        recyclerAdapter.notifyDataSetChanged();*/
        try {
            JSONObject jsonObject = new JSONObject((Map) arrayList);
            JSONArray jsonArray = jsonObject.getJSONArray(("response"));
            int count =0;
            String userName, userEmail;
            while(count < jsonArray.length())
            {
                JSONObject object = jsonArray.getJSONObject(count);
                userName = object.getString("userName");
                userEmail = object.getString("userEmail");
                UserData user = new UserData(R.layout.user_image, arrayList);
                arrayList.add(user);
                count++;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}