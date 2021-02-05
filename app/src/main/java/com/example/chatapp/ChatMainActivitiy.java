package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
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

    private TextView name, email;
    private ImageView image_1;

    final static private String url_data = "http://kkang.dothome.co.kr/imformation.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_main_activitiy);

        String drawN = "@mipmap/ic_launcher";
        int image = getResources().getIdentifier(drawN,"mipmap", String.valueOf(R.mipmap.ic_launcher));;

        image_1 =findViewById(R.id.image);
        name = findViewById(R.id.et_name);
        email = findViewById(R.id.et_email);

        String StringI = String.valueOf(image_1);
        String StringN = String.valueOf(name);
        String StringE = String.valueOf(email);

        recyclerView = findViewById(R.id.RecyclerView);

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        arrayList = new ArrayList<>();

        recyclerAdapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(recyclerAdapter);

        //Toast.makeText(ChatMainActivitiy.this,"no1",Toast.LENGTH_LONG).show();

       JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, url_data, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                arrayList.clear();
                recyclerAdapter.notifyDataSetChanged();

                try{
               for(int i=0; i< response.length(); i++) {

                   //JSONObject jsonObject = new JSONObject();
                   JSONObject jsonObject = response.getJSONObject(i);

                   String drawN = "@mipmap/ic_launcher";
                   int image = getResources().getIdentifier(drawN,"mipmap", String.valueOf(R.mipmap.ic_launcher));
                   //int image = getResources().getDrawable(R.mipmap.ic_launcher).toInt();
                   String name = jsonObject.getString("userName");
                   String email = jsonObject.getString("userEmail");

                   arrayList.add(0, new UserData(image, name, email));
                   recyclerAdapter.notifyItemInserted(0);

               }
                } catch (JSONException e) {
                    e.printStackTrace();
                    System.out.println("일단 106");
                }
            }
        }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    //Toast.makeText(ChatMainActivitiy.this, "ERROR", Toast.LENGTH_SHORT).show();
                    System.out.println("다시 생각해보자");
                }
        });

        GetUserList getUserList = new GetUserList(image,StringN,StringE, (Response.Listener<String>) jsonArrayRequest,
                null);
        RequestQueue requestQueue= Volley.newRequestQueue(ChatMainActivitiy.this);
        requestQueue.add(getUserList);


        /*
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                arrayList.clear();
                recyclerAdapter.notifyDataSetChanged();

                try {
                    for(int i = 0; i< response.length(); i++) {
                        //JSONObject jsonObject = new JSONObject(response);
                        JSONObject jsonObject = new JSONObject(response);
                        //JSONArray jsonArray = jsonObject.getJSONArray(response);
                        String name = jsonObject.getString("userName");
                        String email = jsonObject.getString("userEmail");
                        //String name  = jsonArray.getString(Integer.parseInt("userName"));
                        //String email  = jsonArray.getString(Integer.parseInt("userEmail"));

                       // arrayList.add(0, new UserData(image, name, email));
                       // recyclerAdapter.notifyItemInserted(0);
                   // }

                    //for(int i = 0; i< response.length(); i++) {
                        arrayList.add(i, new UserData(image, name, email));
                        recyclerAdapter.notifyItemInserted(i);

                    }
                }catch (JSONException e){
                    e.printStackTrace();
                }
                System.out.println("no_129");
                System.out.println(response.length());
                //recyclerAdapter.notifyItemInserted(0);
                Toast.makeText(getApplicationContext(),"okay",Toast.LENGTH_SHORT).show();
                System.out.println("no_138");
            }
        };

        GetUserList getUserList = new GetUserList(image,StringN,StringE,responseListener,
                null);
        RequestQueue requestQueue= Volley.newRequestQueue(ChatMainActivitiy.this);
        requestQueue.add(getUserList);
        */
    }
}