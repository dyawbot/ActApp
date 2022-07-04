package com.example.actapp.guest_activity.guest_visit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.actapp.R;
import com.example.actapp.employee_activity.employee_success_declaration.EmployeeSuccessDeclaration;

public class GuestAboutVisit extends AppCompatActivity {
    Spinner s_offices;
    Button b_guest_about_visit;
    ImageButton imbtn_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_about_visit);


        s_offices = findViewById(R.id.s_offices);
        b_guest_about_visit = findViewById(R.id.b_guest_about_visit);
        imbtn_back = findViewById(R.id.imbtn_back);


        ArrayAdapter<String> aA_Offices = new ArrayAdapter<String>(GuestAboutVisit.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.offices));
        aA_Offices.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s_offices.setAdapter(aA_Offices);

        b_guest_about_visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EmployeeSuccessDeclaration.class);
                startActivity(intent);
                finish();
            }
        });closeContextMenu();

        imbtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GuestAboutVisit.super.onBackPressed();
            }
        });
    }
}