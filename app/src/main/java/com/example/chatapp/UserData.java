package com.example.chatapp;

import java.util.ArrayList;

public class UserData {

    private int image;
    private ArrayList<UserData> arrayList;
    //private String et_name, et_email;

    public UserData(int image, ArrayList<UserData> arrayList) {
        this.image = image;
        this.arrayList = arrayList;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public ArrayList<UserData> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<UserData> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "image=" + image +
                ", arrayList=" + arrayList +
                '}';
    }
}
