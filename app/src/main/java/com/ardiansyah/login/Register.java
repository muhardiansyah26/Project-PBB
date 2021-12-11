package com.ardiansyah.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class Register extends AppCompatActivity {
    EditText txtUsername,txtFullname,txtEmail,txtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtFullname = findViewById(R.id.fullname);
        txtUsername = findViewById(R.id.username);
        txtEmail = findViewById(R.id.email);
        txtPassword=findViewById(R.id.password);

        Button daftar = findViewById(R.id.daftar);

        daftar.setOnClickListener(v -> {
            String fullname,username,email,password;
            fullname = String.valueOf(txtFullname.getText());
            username = String.valueOf(txtUsername.getText());
            email = String.valueOf(txtEmail.getText());
            password = String.valueOf(txtPassword.getText());
            //Start ProgressBar first (Set visibility VISIBLE)

            if (!fullname.equals("") && !username.equals("") && !email.equals("") && !password.equals("")) {
                Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        String[] field = new String[4];
                        field[0] = "fullname";
                        field[1] = "username";
                        field[2] = "password";
                        field[3] = "email";
                        //Creating array for data
                        String[] data = new String[4];
                        data[0] = fullname;
                        data[1] = username;
                        data[2] = password;
                        data[3] = email;
                        PutData putData = new PutData("http://192.168.43.133/futsal/signup.php", "POST", field, data);
                        if (putData.startPut()) {
                            if (putData.onComplete()) {
                                String result = putData.getResult();
                                if (result.equals("Sign Up Success")){
                                    Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                                else {
                                    Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                }
                                //End ProgressBar (Set visibility to GONE)
                            }
                        }
                    }
                });
                //startActivity(new Intent(Register.this, MainActivity.class));
            }
            else {
                Toast.makeText(getApplicationContext(),"All Field Required!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}