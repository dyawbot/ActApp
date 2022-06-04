package com.example.actapp.employeed_health_declaration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.actapp.R;
import com.example.actapp.employee_success_declaration.EmployeeSuccessDeclaration;

public class EmployeeHealthDeclaration extends AppCompatActivity {

    Button e_healthDeclaration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_health_declaration);

        e_healthDeclaration = findViewById(R.id.e_healthDeclaration);


        e_healthDeclaration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EmployeeSuccessDeclaration.class);
                startActivity(intent);
            }
        });
    }
}