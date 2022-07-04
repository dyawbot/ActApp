package com.example.actapp.employee_activity.employeed_health_declaration;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.actapp.R;
import com.example.actapp.employee_activity.employee_success_declaration.EmployeeSuccessDeclaration;
import com.example.actapp.guest_activity.guest_visit.GuestAboutVisit;

public class EmployeeHealthDeclaration extends AppCompatActivity {

    Button e_healthDeclaration;
    ImageButton e_im_back;
    boolean fromGuest = false;
    Intent intents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_health_declaration);


        e_healthDeclaration = findViewById(R.id.e_healthDeclaration);
        e_im_back = findViewById(R.id.imbtn_back);
        //e_healthDeclaration.setOnClickListener((View.OnClickListener) this);



        Bundle extras = getIntent().getExtras();
        String userName;

        if (extras != null) {
            userName = extras.getString("fromGuest");
            // and get whatever type user account id is
            Log.i("HELLO", String.valueOf(userName));

            if(userName.equals("guest"))
            {


                fromGuest = true;



            }
            else
            {
                fromGuest = false;
            }

        }

        Log.i("HELLO", String.valueOf(fromGuest));




        e_healthDeclaration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(fromGuest == true)
                {
                    Intent intent = new Intent(getApplicationContext(), GuestAboutVisit.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Intent intent = new Intent(getApplicationContext(), EmployeeSuccessDeclaration.class);
                    startActivity(intent);
                    finish();
                }

            }
        });
        e_im_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EmployeeHealthDeclaration.super.onBackPressed();
            }
        });










    }
}