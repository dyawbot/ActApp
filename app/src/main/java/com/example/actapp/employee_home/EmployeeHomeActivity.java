package com.example.actapp.employee_home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.actapp.R;
import com.example.actapp.employeed_health_declaration.EmployeeHealthDeclaration;
import com.example.actapp.reporting_person.Reports;

public class EmployeeHomeActivity extends AppCompatActivity {
    Button e_home, e_reportBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_home);

        e_home = findViewById(R.id.e_home);
        e_reportBtn = findViewById(R.id.e_reportBtn);





        e_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EmployeeHealthDeclaration.class);
                startActivity(intent);
            }
        });

        e_reportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Reports.class);
                startActivity(intent);
            }
        });
    }
}