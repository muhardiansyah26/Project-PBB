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

public class FormPesan extends AppCompatActivity {
    private EditText txtTeam , txtNama , txtTanggal , txtWaktu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_pesan);

        txtTeam =findViewById(R.id.teamname);
        txtNama =findViewById(R.id.user);
        txtTanggal =findViewById(R.id.tanggal);
        txtWaktu =findViewById(R.id.jam);
        TextView txtLapangan = findViewById(R.id.namaLapangan);
        Button btnPemesanan = findViewById(R.id.btnPemesanan);

        Bundle extra = getIntent().getExtras();
        String namaLapangan=extra.getString("namaLapangan");
        txtLapangan.setText(namaLapangan);

        btnPemesanan.setOnClickListener(v -> {
            String teamname,username,tanggal,jam,lapangan;

            teamname=String.valueOf(txtTeam.getText());
            username=String.valueOf(txtNama.getText());
            tanggal=String.valueOf(txtTanggal.getText());
            jam=String.valueOf(txtWaktu.getText());
            lapangan=String.valueOf(txtLapangan.getText());
            if (!teamname.equals("") && !username.equals("") && !tanggal.equals("") && !jam.equals("")) {
                Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        String[] field = new String[5];
                        field[0] = "teamname";
                        field[1] = "username";
                        field[2] = "lapangan";
                        field[3] = "tanggal";
                        field[4] = "jam";
                        //Creating array for data
                        String[] data = new String[5];
                        data[0] = teamname;
                        data[1] = username;
                        data[2] = lapangan;
                        data[3] = tanggal;
                        data[4] = jam;
                        PutData putData = new PutData("https://pemesananfutsal.domcloud.io/pesan.php", "POST", field, data);
                        if (putData.startPut()) {
                            if (putData.onComplete()) {
                                String result = putData.getResult();
                                if (result.equals("Pemesanan Berhasil")){
                                    Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), HalamanPemesanan.class);
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