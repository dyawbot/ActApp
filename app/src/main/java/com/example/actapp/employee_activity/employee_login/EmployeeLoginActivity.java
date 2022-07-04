package com.example.actapp.employee_activity.employee_login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.actapp.Prevalent;
import com.example.actapp.R;
import com.example.actapp.employee_activity.employee_home.EmployeeHomeActivity;
import com.example.actapp.employee_activity.employee_register.EmployeeRegister;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import io.paperdb.Paper;

public class EmployeeLoginActivity extends AppCompatActivity {
    Button e_login;
    EditText e_username, e_password;
    TextView e_register_text;
    ImageButton imbtn_back;
    CheckBox e_forgetmeNot;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_login);

       // DbCon toConnect = new DbCon();

        e_login = findViewById(R.id.e_login);
        e_username = findViewById(R.id.e_username);
        e_password = findViewById(R.id.e_passwords);
        e_register_text =findViewById(R.id.t_register);
        e_forgetmeNot = findViewById(R.id.forgetMeNot);



        imbtn_back = findViewById(R.id.imbtn_back);

        Paper.init(this);

        rememberMyAccountToThisMobileApp();


        e_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final String s_username, s_password;

                 s_username= e_username.getText().toString();
                 s_password= String.valueOf(e_password.getText()).toString();
                 Log.i("PASS", s_password + " " + s_username);

                if(e_forgetmeNot.isChecked()) {
                    Paper.book().write(Prevalent.EMAIL_ADDRESS, s_username);
                    Paper.book().write(Prevalent.PASSWORD, s_password);
                }


                 if(!s_username.equals("") && !s_password.equals(""))
                 {
                    // Toast.makeText(EmployeeLoginActivity.this, "The service of this is app is offline", Toast.LENGTH_SHORT).show();
                     Handler handler = new Handler();
                     try {

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
                                             intent.putExtra("emplogin_username", s_username);


                                             startActivity(intent);
                                             finish();

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
                     catch (Exception io)
                     {

                         //handler.postDelayed(new Runnable());


                         handler.removeCallbacksAndMessages(null);
                         Toast.makeText(EmployeeLoginActivity.this, "The service of this is app is offline", Toast.LENGTH_SHORT).show();
                     }



                 }
                 else
                 {
                     Toast.makeText(EmployeeLoginActivity.this, "Please fill up your username or password", Toast.LENGTH_SHORT).show();
                 }



            }
        });

        e_register_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Open new Activity
                Intent intent = new Intent(getApplicationContext(), EmployeeRegister.class);
                startActivity(intent);
            }
        });

        imbtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EmployeeLoginActivity.super.onBackPressed();
            }
        });
    }

    private void rememberMyAccountToThisMobileApp() {
        String emailAddressKey = Paper.book().read(Prevalent.EMAIL_ADDRESS);
        String passwordKey = Paper.book().read(Prevalent.PASSWORD);

        if(emailAddressKey!="" && passwordKey!="")
        {
            if(!TextUtils.isEmpty(emailAddressKey) && !TextUtils.isEmpty(passwordKey))
            {
                Log.i("HELLO", emailAddressKey + " " +passwordKey);
                allowingUserToLogin(emailAddressKey, passwordKey);
            }

        }

    }

    private void allowingUserToLogin(String username, String password)
    {
        final String s_username = username, s_password = password;



        Log.i("PASS", s_password + " " + s_username);

        if(e_forgetmeNot.isChecked()) {
            Paper.book().write(Prevalent.EMAIL_ADDRESS, s_username);
            Paper.book().write(Prevalent.PASSWORD, s_password);
        }


        if(!s_username.equals("") && !s_password.equals(""))
        {
            // Toast.makeText(EmployeeLoginActivity.this, "The service of this is app is offline", Toast.LENGTH_SHORT).show();
            Handler handler = new Handler();
            try {

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
                                    intent.putExtra("emplogin_username", s_username);


                                    startActivity(intent);
                                    finish();

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
            catch (Exception io)
            {

                //handler.postDelayed(new Runnable());


                handler.removeCallbacksAndMessages(null);
                Toast.makeText(EmployeeLoginActivity.this, "The service of this is app is offline", Toast.LENGTH_SHORT).show();
            }



        }
        else
        {
            Toast.makeText(EmployeeLoginActivity.this, "Please fill up your username or password", Toast.LENGTH_SHORT).show();
        }

    }
}