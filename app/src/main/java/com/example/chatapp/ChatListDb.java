package com.example.chatapp;

import android.os.AsyncTask;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class ChatListDb extends StringRequest {

    final static private String URL = "http://kkang.dothome.co.kr/imformation.php";
    private Map<String, String> map2;

    public ChatListDb(String userName, String userEmail, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        map2 = new HashMap<>();
        map2.put("userName",userName);
        map2.put("userEmail",userEmail);

    }
    protected Map<String, String> getParams() throws AuthFailureError {
        return map2;
    }
}
