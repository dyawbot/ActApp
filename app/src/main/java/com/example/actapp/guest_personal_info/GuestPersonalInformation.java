package com.example.actapp.guest_personal_info;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.actapp.R;
import com.example.actapp.employeed_health_declaration.EmployeeHealthDeclaration;

import android.view.View;
import android.widget.Button;

public class GuestPersonalInformation extends AppCompatActivity {
    
    
    Button b_guest_personal_information;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_personal_information);


        b_guest_personal_information = findViewById(R.id.b_guest_personal_information);


        b_guest_personal_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EmployeeHealthDeclaration.class);
                intent.putExtra("fromGuest", "guest");
                startActivity(intent);
            }
        });
    }
}