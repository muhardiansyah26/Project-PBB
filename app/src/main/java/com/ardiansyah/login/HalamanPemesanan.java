package com.ardiansyah.login;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class HalamanPemesanan extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_pemesanan);
        ambil_data();

    }
    void ambil_data()
    {
        String link="https://pemesananfutsal.domcloud.io/getData.php";
        StringRequest respon=new StringRequest(
                Request.Method.POST,
                link,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("hasil");
                            ArrayList<Get_Data> list_data;
                            list_data=new ArrayList<>();

                            for (int i=0; i<jsonArray.length(); i++ )
                            {
                                JSONObject hasil=jsonArray.getJSONObject(i);
                                String team = hasil.getString("teamname");
                                String name = hasil.getString("username");
                                String lapangan = hasil.getString("lapangan");
                                String tanggal = hasil.getString("tanggal");
                                String jam = hasil.getString("jam");

                                list_data.add(new Get_Data(
                                        team,
                                        name,
                                        lapangan,
                                        tanggal,
                                        jam
                                ));
                            }
                            ListView listView=findViewById(R.id.list);
                            Custom_adapter adapter=new Custom_adapter(HalamanPemesanan.this, list_data);
                            listView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(HalamanPemesanan.this, error.getMessage(),Toast.LENGTH_SHORT).show();

                    }
                }
        );
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(respon);
    }
}

class Get_Data{
    String team="", nama="", lapangan="", tanggal="",waktu="";
    Get_Data(String team, String nama, String lapangan, String tanggal , String waktu)
    {
        this.team=team;
        this.nama=nama;
        this.lapangan=lapangan;
        this.tanggal=tanggal;
        this.waktu=waktu;
    }

    public String getTeam() {
        return team;
    }

    public String getNama() {
        return nama;
    }

    public String getLapangan() {
        return lapangan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getWaktu() { return waktu; }
}

class Custom_adapter extends BaseAdapter
{
    Context context;
    LayoutInflater layoutInflater;
    ArrayList<Get_Data>model;
    Custom_adapter(Context context, ArrayList<Get_Data> model)
    {
        layoutInflater=LayoutInflater.from(context);
        this.context=context;
        this.model=model;
    }

    @Override
    public int getCount() {
        return model.size();
    }

    @Override
    public Object getItem(int position) {
        return model.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=layoutInflater.inflate(R.layout.list_item, null);
        TextView textTeamname, textUsername , textLapangan, textTanggal, textWaktu;
        textTeamname = view.findViewById(R.id.textTeamname);
        textUsername=view.findViewById(R.id.textUsername);
        textLapangan=view.findViewById(R.id.textLapangan);
        textTanggal=view.findViewById(R.id.textTanggal);
        textWaktu=view.findViewById(R.id.textWaktu);

        textTeamname.setText(model.get(position).getTeam());
        textUsername.setText(model.get(position).getNama());
        textLapangan.setText(model.get(position).getLapangan());
        textTanggal.setText(model.get(position).getTanggal());
        textWaktu.setText(model.get(position).getWaktu());
        return view;
    }
}