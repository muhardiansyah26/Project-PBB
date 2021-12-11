package com.ardiansyah.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailLapangan extends AppCompatActivity {
    private String KEY_NAMA ="LAPANGAN 1";
    private String KEY_LANTAI="SINTETIS";
    private String KEY_LUAS ="LUAS";
    private String KEY_HARGA="60000";
    private String KEY_GAMBAR="lapangan1";
    private String KEY_VIDEO="link";
    String KEY_LINK="android.resource://com.ardiansyah.login/raw/video1";
    TextView txtNama,txtLantai,txtLuas,txtHarga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_lapangan);

        txtNama=findViewById(R.id.getNama);
        txtLantai=findViewById(R.id.getLantai);
        txtLuas=findViewById(R.id.getLuas);
        txtHarga=findViewById(R.id.getHarga);
        ImageView txtGambar=findViewById(R.id.getGambar);
        Button btnVideo = findViewById(R.id.btnVideo);

        Bundle extra = getIntent().getExtras();
        String namaLapangan=extra.getString(KEY_NAMA);
        String namaLantai=extra.getString(KEY_LANTAI);
        String namaLuas=extra.getString(KEY_LUAS);
        String namaHarga=extra.getString(KEY_HARGA);
        //String namaVideo=extra.getString(KEY_VIDEO);

        String namaGambar=extra.getString(KEY_GAMBAR);
        int id = getResources().getIdentifier(namaGambar, "drawable",getPackageName());
        txtGambar.setImageResource(id);

        txtNama.setText(namaLapangan);
        txtLantai.setText(namaLantai);
        txtLuas.setText(namaLuas);
        txtHarga.setText(namaHarga);
        btnVideo.setOnClickListener(v -> {
            FragmentVideo obj = new FragmentVideo();
            Bundle bundle= new Bundle();
            //String namaVideo=extra.getString(KEY_VIDEO);

            FragmentManager fm = getSupportFragmentManager();

            bundle.putString(KEY_LINK,extra.getString("video"));
            obj.setArguments(bundle);


            FragmentTransaction ft =fm.beginTransaction();


            ft.replace(R.id.container1, obj);
            ft.commit();
        });

    }
}