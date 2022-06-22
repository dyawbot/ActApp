package com.example.actapp.db_connections;


import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import  java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbCon {
    static final String DB_URL = "jdbc:mysql://192.168.0.54:80/actappdb_admin";
    static final String USER = "root";
    static final String PASS = "";
    private static Connection con = null;
    private static String connUrl =null;


    ResultSet rs;
    PreparedStatement ps;
   // Connection conns = null;



    public static Connection getConnection()
    {

        try
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(DB_URL,USER,PASS);
            con = DriverManager.getConnection(connUrl);

        }catch (Exception io)
        {
            //CAN"T CONNECT ARGUMENT HERE;

            Log.e("DB_URL", io.getMessage());

        }
        return con;
    }

    //EMPLOYEE LOG IN HERE::::
    public Boolean adminLogin(String username, String password)
    {
        String query = "SELECT * FROM tbl_admin WHERE username=? AND password=?";
        Boolean isCon = false;

        Log.i("PASS", "THIS IS PASS");

        try
        {
            //con = DriverManager.getConnection(DB_URL,USER,PASS);

            ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();

            isCon = rs.next();

            Log.i("PASS", String.valueOf(isCon));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            isCon = false;
        }
        catch (Exception eX)
        {
            Log.e("SQL_ERROR", eX.getMessage());
            isCon = false;
        }


        String all = username + " " + password;
        Log.i("PASS", String.valueOf(isCon));
        return isCon;
    }


}
