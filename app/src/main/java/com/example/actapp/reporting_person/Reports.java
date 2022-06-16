package com.example.actapp.reporting_person;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.actapp.R;
import com.example.actapp.employee_home.EmployeeHomeActivity;

public class Reports extends AppCompatActivity {
    Spinner e_employee_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);


        e_employee_name = findViewById(R.id.s_employee_name);

        ArrayAdapter<String> aA_employee_name = new ArrayAdapter<String>(Reports.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.employee));
        aA_employee_name.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        e_employee_name.setAdapter(aA_employee_name);
    }
}