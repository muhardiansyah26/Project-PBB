package com.ardiansyah.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class HasilPemesanan extends AppCompatActivity {
    private TextView team,nama,lapangan,tanggal,jam,harga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_pemesanan);

        team = findViewById(R.id.hslTeam);
        nama = findViewById(R.id.hslNama);
        lapangan = findViewById(R.id.hslLapangan);
        tanggal = findViewById(R.id.hslTanggal);
        jam = findViewById(R.id.hslJam);
        harga = findViewById(R.id.hslHarga);
        Button btnHasil = findViewById(R.id.btnHasil);

        Bundle extra = getIntent().getExtras();
        String Team = extra.getString("teamname");
        String Nama = extra.getString("username");
        String Lapangan = extra.getString("lapangan");
        String Tanggal = extra.getString("tanggal");
        String Jam = extra.getString("jam");
        String Harga = extra.getString("harga");

        team.setText(Team);
        nama.setText(Nama);
        lapangan.setText(Lapangan);
        tanggal.setText(Tanggal);
        jam.setText(Jam);
        harga.setText(Harga);

        btnHasil.setOnClickListener(v -> {
            startActivity(new Intent(HasilPemesanan.this,HalamanPemesanan.class));
        });


    }
}