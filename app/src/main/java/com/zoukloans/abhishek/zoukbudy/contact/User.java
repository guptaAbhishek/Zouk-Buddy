package com.zoukloans.abhishek.zoukbudy.contact;

/**
 * Created by abhishek on 17/05/16.
 */
public class User {
    String userName = "";
    String userNumber = "";

    public String getUserName(){
        return userName;
    }

    public void setUserName(String name){
        this.userName = name;
    }

    public String getUserNumber(){
        return userNumber;
    }

    public void setUserNumber(String number){
        this.userNumber = number;
    }
}
