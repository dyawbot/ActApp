package com.example.actapp.guest_visit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Button;
import com.example.actapp.R;
import com.example.actapp.employee_success_declaration.EmployeeSuccessDeclaration;

public class GuestAboutVisit extends AppCompatActivity {
    Spinner s_offices;
    Button b_guest_about_visit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_about_visit);


        s_offices = findViewById(R.id.s_offices);
        b_guest_about_visit = findViewById(R.id.b_guest_about_visit);

        ArrayAdapter<String> aA_Offices = new ArrayAdapter<String>(GuestAboutVisit.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.offices));
        aA_Offices.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s_offices.setAdapter(aA_Offices);

        b_guest_about_visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EmployeeSuccessDeclaration.class);
                startActivity(intent);
            }
        });closeContextMenu();
    }
}