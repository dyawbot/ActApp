package com.example.actapp.employee_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.actapp.R;
import com.example.actapp.db_connections.DbCon;
import com.example.actapp.employee_home.EmployeeHomeActivity;

public class EmployeeLoginActivity extends AppCompatActivity {
    Button e_login;
    EditText e_username, e_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_login);

        DbCon toConnect = new DbCon();

        e_login = findViewById(R.id.e_login);
        e_username = findViewById(R.id.e_username);
        e_password = findViewById(R.id.e_password);


        e_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s_username= e_username.getText().toString();
                String s_password = String.valueOf(e_password.getText().toString());
                boolean isCon = toConnect.adminLogin(s_username, s_password);

                if(isCon)
                {
                    Intent intent = new Intent(getApplicationContext(), EmployeeHomeActivity.class);
                    startActivity(intent);
                }

            }
        });
    }
}