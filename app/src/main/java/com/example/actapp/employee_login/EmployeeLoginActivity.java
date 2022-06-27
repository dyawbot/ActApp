package com.example.actapp.employee_login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.actapp.R;
import com.example.actapp.employee_home.EmployeeHomeActivity;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class EmployeeLoginActivity extends AppCompatActivity {
    Button e_login;
    EditText e_username, e_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_login);

       // DbCon toConnect = new DbCon();

        e_login = findViewById(R.id.e_login);
        e_username = findViewById(R.id.e_username);
        e_password = findViewById(R.id.e_passwords);


        e_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final String s_username, s_password;

                 s_username= e_username.getText().toString();
                 s_password= String.valueOf(e_password.getText()).toString();
                 //s_password = e_password.getText().toString();
                Log.i("PASS", s_password + " " + s_username);


                 if(!s_username.equals("") && !s_password.equals(""))
                 {
                     Handler handler = new Handler();
                     handler.post(new Runnable() {
                         @Override
                         public void run() {
                             String[] field = new String[2];
                             field[0] = "username";
                             field[1] = "password";
                             String[] data = new String[2];
                             data[0]= s_username;
                             data[1] = s_password;

                             PutData putData = new PutData("http://192.168.254.145/bsu/login.php", "POST", field, data);

                             if(putData.startPut())
                             {

                                 if(putData.onComplete())
                                 {
                                     String result = putData.getResult();

                                     if(result.equals("Login Success "))
                                     {
                                         Toast.makeText(EmployeeLoginActivity.this, result, Toast.LENGTH_SHORT).show();
                                         Intent intent = new Intent(getApplicationContext(), EmployeeHomeActivity.class);
                                         startActivity(intent);

                                     }
                                     else
                                     {
                                         Toast.makeText(EmployeeLoginActivity.this, "Please login the correct username or password", Toast.LENGTH_SHORT).show();
                                     }
                                 }
                             }
                             else
                             {
                                 Log.d("CANT", "CANNOT");
                             }




                         }
                     });

                 }
                 else
                 {
                     Toast.makeText(EmployeeLoginActivity.this, "Please fill up your username or password", Toast.LENGTH_SHORT).show();
                 }



            }
        });
    }
}