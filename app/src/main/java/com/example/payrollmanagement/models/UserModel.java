package com.example.payrollmanagement.models;

public class UserModel {
    String user_name,user_email,user_type,user_password;
    //int id;

    public UserModel() {
    }


    /*public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }*/


    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }
}
