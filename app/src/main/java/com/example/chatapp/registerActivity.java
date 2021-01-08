package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class registerActivity extends AppCompatActivity {

    private EditText et_id1,et_password1,et_name,et_email2;
   // public String userName, userEmail;
    private Button bt_register1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_id1 = findViewById(R.id.et_id1);
        et_password1 = findViewById(R.id.et_password1);
        et_name = findViewById(R.id.et_name);
        //et_age = findViewById(R.id.et_age);
        et_email2 = findViewById(R.id.et_email2);

        bt_register1 = findViewById(R.id.bt_register1);
        bt_register1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userID = et_id1.getText().toString();
                String userPassword = et_password1.getText().toString();
                String userName = et_name.getText().toString();
                //int userAge = Integer.parseInt(et_age.getText().toString());
                String userEmail = et_email2.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if(success){
                                Toast.makeText(getApplicationContext(),"정상적으로 회원등록에 성공했습니다.",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(registerActivity.this, MainActivity.class);
                                startActivity(intent);

                            }else{
                                Toast.makeText(getApplicationContext(),"회원등록에 실패했습니다",Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                RegisterRequest registerRequest = new RegisterRequest(userID,userPassword,userName,userEmail,responseListener);
                RequestQueue queue = Volley.newRequestQueue(registerActivity.this);
                queue.add(registerRequest);
            }
        });
    }
}