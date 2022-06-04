package com.example.actapp.employee_home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.actapp.R;
import com.example.actapp.employeed_health_declaration.EmployeeHealthDeclaration;

public class EmployeeHomeActivity extends AppCompatActivity {
    Button e_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_home);

        e_home = findViewById(R.id.e_home);

        e_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EmployeeHealthDeclaration.class);
                startActivity(intent);
            }
        });
    }
}