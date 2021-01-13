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
import android.widget.Toast;
import android.widget.Toolbar;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

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
        //Intent intent = getIntent();

        arrayList = new ArrayList<>();
        recyclerAdapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(recyclerAdapter);
        //Toast.makeText(getApplicationContext(),"여기까진 되는듯#1",Toast.LENGTH_SHORT).show();
      //  mA = (MainActivity)getApplicationContext();
        /*UserData userData = new UserData(R.id.image,mA.userID,mA.userPassword);
        arrayList.add(userData);
        recyclerAdapter.notifyDataSetChanged();*/

        try {
            //Toast.makeText(getApplicationContext(),"여기까진 되는듯#1-1",Toast.LENGTH_SHORT).show();
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

    }
}