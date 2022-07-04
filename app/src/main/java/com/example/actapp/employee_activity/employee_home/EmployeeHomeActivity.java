package com.example.actapp.employee_activity.employee_home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.actapp.MainActivity;
import com.example.actapp.R;
import com.example.actapp.employee_activity.employeed_health_declaration.EmployeeHealthDeclaration;
import com.example.actapp.reporting_person.Reports;

import io.paperdb.Paper;

public class EmployeeHomeActivity extends AppCompatActivity {
    Button e_home, e_reportBtn;
    TextView e_welcome_note;
    ImageButton e_imbtn_signout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_home);

        e_home = findViewById(R.id.e_home);
        e_reportBtn = findViewById(R.id.e_reportBtn);
        e_welcome_note = findViewById(R.id.welcome_note);
        e_imbtn_signout = findViewById(R.id.imbtn_signout);




        try {


            Intent intent = getIntent();
            String str = intent.getStringExtra("emplogin_username");
            e_welcome_note.setText("Hello! Have a great day, " + str.substring(0,1).toUpperCase()+str.substring(1));
        }catch (Exception eC)
        {
            Log.e("ERROR", null);
        }







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
        e_imbtn_signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Paper.book().destroy();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}