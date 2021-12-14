package com.ardiansyah.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class MainActivity extends AppCompatActivity {
    EditText txtUsername,txtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsername = findViewById(R.id.username1);
        txtPassword=findViewById(R.id.password1);
        Button btnLogin = findViewById(R.id.btnLogin);
        TextView btnRegister = findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(v -> {
            String username,password;
            username = String.valueOf(txtUsername.getText());
            password = String.valueOf(txtPassword.getText());
            //Start ProgressBar first (Set visibility VISIBLE)

            if (!username.equals("") && !password.equals("")) {
                Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        String[] field = new String[2];
                        field[0] = "username";
                        field[1] = "password";
                        //Creating array for data
                        String[] data = new String[2];
                        data[0] = username;
                        data[1] = password;
                        PutData putData = new PutData("https://pemesananfutsal.domcloud.io/login.php", "POST", field, data);
                        if (putData.startPut()) {
                            if (putData.onComplete()) {
                                String result = putData.getResult();
                                if (result.equals("Login Success")){
                                    Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), HalamanUtama.class);
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

        btnRegister.setOnClickListener(v -> {
            Intent register = new Intent(MainActivity.this, Register.class);
            startActivity(register);
            Toast.makeText(MainActivity.this,"Form Pendaftaran", Toast.LENGTH_SHORT).show();
        });
    }
}