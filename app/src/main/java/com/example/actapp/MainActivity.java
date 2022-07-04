package com.example.actapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.actapp.employee_activity.employee_login.EmployeeLoginActivity;
import com.example.actapp.guest_activity.guest_personal_info.GuestPersonalInformation;

public class MainActivity extends AppCompatActivity {
    Button e_signInBtn, g_signInBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        e_signInBtn = findViewById(R.id.e_signInBtn);
        g_signInBtn = findViewById(R.id.g_signinBtn);

        e_signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent =new Intent(getApplicationContext(), EmployeeLoginActivity.class);
                startActivity(intent);
            }
        });

        g_signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(), GuestPersonalInformation.class);
                startActivity(intent);
            }
        });


    }
}