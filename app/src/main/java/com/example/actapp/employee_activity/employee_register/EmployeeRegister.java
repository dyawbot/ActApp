package com.example.actapp.employee_activity.employee_register;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.actapp.R;

public class EmployeeRegister extends AppCompatActivity {

    ImageButton imbtn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_register);

        imbtn_back = findViewById(R.id.imbtn_back);

        imbtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EmployeeRegister.super.onBackPressed();

            }
        });
    }
}