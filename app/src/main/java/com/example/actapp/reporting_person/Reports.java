package com.example.actapp.reporting_person;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.actapp.R;

public class Reports extends AppCompatActivity {
    Spinner e_employee_name;
    ImageButton r_im_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);


        e_employee_name = findViewById(R.id.s_employee_name);
        r_im_back = findViewById(R.id.imbtn_back);

        ArrayAdapter<String> aA_employee_name = new ArrayAdapter<String>(Reports.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.employee));
        aA_employee_name.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        e_employee_name.setAdapter(aA_employee_name);


        r_im_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Reports.super.onBackPressed();
            }
        });
    }
}