package com.example.helper;

public class Users {

    private String FName, Lname, city, email, password, type;
    private String PhoneNumber;
public Users(){

}
    public String getFName() {
        return FName;
    }



    public String getLname() {
        return Lname;
    }



    public String getPhoneNumber() {
        return PhoneNumber;
    }



    public String getCity() {
        return city;
    }



    public String getEmail() {
        return email;
    }



    public String getPassword() {
        return password;
    }



    public String getType() {
        return type;
    }



    public Users(String FName, String lname, String phoneNumber, String city, String email, String password, String type) {
        this.FName = FName;
        this.Lname = lname;
        this.PhoneNumber = phoneNumber;
        this.city = city;
        this.email = email;
        this.password = password;
        this.type = type;
    }
}