package com.example.actapp.mysingletonclass;

public class MySaveData {
    public static MySaveData obj = new MySaveData();
    public  String string;
    String saveMe;

    public MySaveData(String savedDate)
    {
        saveMe = savedDate;
    }



    public MySaveData() {

        string = "Hello! Have a great day, " + saveMe.substring(0,1).toUpperCase()+saveMe.substring(1);



    }

    public static MySaveData getInstance()
    {
        return obj;
    }
}
