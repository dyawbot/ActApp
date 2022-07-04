package com.example.actapp.guest_activity.guest_personal_info;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.actapp.R;
import com.example.actapp.employee_activity.employeed_health_declaration.EmployeeHealthDeclaration;

public class GuestPersonalInformation extends AppCompatActivity {
    
    
    Button b_guest_personal_information;
    ImageButton imbtn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_personal_information);


        b_guest_personal_information = findViewById(R.id.b_guest_personal_information);
        imbtn_back = findViewById(R.id.imbtn_back);


        b_guest_personal_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EmployeeHealthDeclaration.class);
                intent.putExtra("fromGuest", "guest");
                startActivity(intent);
                finish();
            }
        });

        imbtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GuestPersonalInformation.super.onBackPressed();
            }
        });
    }
}