package com.example.chatapp;

public class UserData {
    private int image;
    private String et_num, et_email;

    public UserData(int image, String et_num, String et_email) {
        this.image = image;
        this.et_num = et_num;
        this.et_email = et_email;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getEt_num() {
        return et_num;
    }

    public void setEt_num(String et_num) {
        this.et_num = et_num;
    }

    public String getEt_email() {
        return et_email;
    }

    public void setEt_email(String et_email) {
        this.et_email = et_email;
    }
}
