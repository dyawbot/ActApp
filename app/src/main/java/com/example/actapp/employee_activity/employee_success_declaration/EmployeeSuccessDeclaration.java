package com.example.actapp.employee_activity.employee_success_declaration;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.actapp.R;

public class EmployeeSuccessDeclaration extends AppCompatActivity {
    Button b_s_okay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_success_declaration);


        b_s_okay = findViewById(R.id.b_s_okay);


        b_s_okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EmployeeSuccessDeclaration.super.onBackPressed();
            }
        });
    }
}