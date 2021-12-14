package com.ardiansyah.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class HalamanUtama extends AppCompatActivity {

    private String KEY_NAMA ="LAPANGAN 1";
    private String KEY_LANTAI="SINTETIS";
    private String KEY_LUAS ="LUAS";
    private String KEY_HARGA="60000";
    private String KEY_GAMBAR="lapangan1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_utama);

        Button btnMenu1 = findViewById(R.id.btnMenu1);
        Button btnMenu2 = findViewById(R.id.btnMenu2);
        Button btnMenu3 = findViewById(R.id.btnMenu3);
        Button btnCek = findViewById(R.id.btncek);

        btnCek.setOnClickListener(v -> {
            startActivity(new Intent(HalamanUtama.this, HalamanPemesanan.class));
        });

        btnMenu1.setOnClickListener(v -> {
            Intent menu1 = new Intent(HalamanUtama.this, DetailLapangan.class);
            String namaLapangan= "Lapangan Futsal Socah";
            String namaLantai="Sintetis";
            String namaLuas="25x25 Meter";
            String namaHarga="60000";
            String namaGambar="lapangan1";
            String namaVideo="android.resource://com.ardiansyah.login/raw/video1";
            menu1.putExtra(KEY_NAMA,namaLapangan);
            menu1.putExtra(KEY_LANTAI,namaLantai);
            menu1.putExtra(KEY_LUAS,namaLuas);
            menu1.putExtra(KEY_HARGA,namaHarga);
            menu1.putExtra(KEY_GAMBAR,namaGambar);
            menu1.putExtra("video",namaVideo);
            startActivity(menu1);
        });
        btnMenu2.setOnClickListener(v -> {
            Intent menu2 = new Intent(HalamanUtama.this, DetailLapangan.class);
            String namaLapangan= "Lapangan Futsal Maduraksa";
            String namaLantai="Rumput Sintetis";
            String namaLuas="45x25 Meter";
            String namaHarga="70000";
            String namaGambar="lapangan2";
            String namaVideo="android.resource://com.ardiansyah.login/raw/video2";
            menu2.putExtra(KEY_NAMA,namaLapangan);
            menu2.putExtra(KEY_LANTAI,namaLantai);
            menu2.putExtra(KEY_LUAS,namaLuas);
            menu2.putExtra(KEY_HARGA,namaHarga);
            menu2.putExtra(KEY_GAMBAR,namaGambar);
            menu2.putExtra("video",namaVideo);
            startActivity(menu2);
        });
        btnMenu3.setOnClickListener(v -> {
            Intent menu3 = new Intent(HalamanUtama.this, DetailLapangan.class);
            String namaLapangan= "Lapangan Futsal Kamal";
            String namaLantai="Beton";
            String namaLuas="55x35 Meter";
            String namaHarga="55000";
            String namaGambar="lapangan3";
            String namaVideo="android.resource://com.ardiansyah.login/raw/video3";
            menu3.putExtra(KEY_NAMA,namaLapangan);
            menu3.putExtra(KEY_LANTAI,namaLantai);
            menu3.putExtra(KEY_LUAS,namaLuas);
            menu3.putExtra(KEY_HARGA,namaHarga);
            menu3.putExtra(KEY_GAMBAR,namaGambar);
            menu3.putExtra("video",namaVideo);
            startActivity(menu3);
        });
    }
}