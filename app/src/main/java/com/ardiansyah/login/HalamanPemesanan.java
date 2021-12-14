package com.ardiansyah.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
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
import java.util.HashMap;

public class HalamanPemesanan extends AppCompatActivity {
    private RecyclerView lvlapangan;

    private RequestQueue requestQueue;
    private StringRequest stringRequest;

    ArrayList<HashMap<String, String>> list_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_pemesanan);

        String url = "http://192.168.1.33/futsal/getData.php";

        lvlapangan = (RecyclerView) findViewById(R.id.lvlapangan);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        lvlapangan.setLayoutManager(llm);

        requestQueue = Volley.newRequestQueue(HalamanPemesanan.this);

        list_data = new ArrayList<HashMap<String, String>>();

        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("response ", response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("lapangan");
                    for (int a = 0; a < jsonArray.length(); a++) {
                        JSONObject json = jsonArray.getJSONObject(a);
                        HashMap<String, String> map = new HashMap<String, String>();
                        map.put("id", json.getString("id"));
                        map.put("teamname", json.getString("teamname"));
                        map.put("username", json.getString("username"));
                        map.put("lapangan", json.getString("lapangan"));
                        map.put("tanggal", json.getString("tanggal"));
                        list_data.add(map);
                        AdapterList adapter = new AdapterList(HalamanPemesanan.this, list_data);
                        lvlapangan.setAdapter(adapter);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(HalamanPemesanan.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(stringRequest);


    }
}