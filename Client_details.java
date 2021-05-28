package com.example.helper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Client_details  {
    private String fname;
    private String lname;
    private String phoneNumber;
    private String Type;
    private String city;
    private String email;
    private String password;

    public Client_details() {
        // This is default constructor.
    }

    public String getStudentFName() {

        return fname;
    }

    public void setStudentFName(String name) {

        this.fname = name;
    }
    public String getStudentLName() {

        return lname;
    }

    public void setStudentLName(String lname) {

        this.lname = lname;
    }

    public String getStudentPhoneNumber() {

        return phoneNumber;
    }

    public void setStudentPhoneNumber(String phonenumber) {

        this.phoneNumber = phonenumber;
    }
    public String getStudentType() {

        return Type;
    }

    public void setStudentType(String Type) {

        this.Type = Type;
    }
    public String getStudentCity() {

        return city;
    }

    public void setStudentCity(String city) {

        this.city = city;
    }
    public String getStudentEmail() {

        return email;
    }

    public void setStudentEmail(String email) {

        this.email = email;
    }
    public String getStudentPassword() {

        return password;
    }

    public void setStudentPassword(String password) {

        this.password = password;
    }



}



