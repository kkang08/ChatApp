package com.example.chatapp;

import java.util.ArrayList;

public class UserData {

    private int image;
    //private ArrayList<UserData> arrayList;
    private String et_name, et_email;

    public UserData(int image, String et_name, String et_email) {
        this.image = image;
        this.et_name = et_name;
        this.et_email = et_email;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getEt_name() {
        return et_name;
    }

    public void setEt_name(String et_name) {
        this.et_name = et_name;
    }

    public String getEt_email() {
        return et_email;
    }

    public void setEt_email(String et_email) {
        this.et_email = et_email;
    }

}
