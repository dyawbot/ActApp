package com.example.actapp.employee_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.actapp.R;
import com.example.actapp.employee_home.EmployeeHomeActivity;

public class EmployeeLoginActivity extends AppCompatActivity {
    Button e_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_login);

        e_login = findViewById(R.id.e_login);



        e_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EmployeeHomeActivity.class);
                startActivity(intent);
            }
        });
    }
}