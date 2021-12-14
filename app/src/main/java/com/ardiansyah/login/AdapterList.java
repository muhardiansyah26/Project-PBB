package com.ardiansyah.login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;

public class AdapterList extends RecyclerView.Adapter<AdapterList.ViewHolder>{

    Context context;
    ArrayList<HashMap<String, String>> list_data;

    public AdapterList(HalamanPemesanan mainActivity, ArrayList<HashMap<String, String>> list_data) {
        this.context = mainActivity;
        this.list_data = list_data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        /*Glide.with(context)
                .load("http://192.168.95.77/app_blogvolley/img/" + list_data.get(position).get("gambar"))
                .crossFade()
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.imghape);*/

        holder.txthape.setText(list_data.get(position).get("merk"));
    }

    @Override
    public int getItemCount() {
        return list_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txthape;
        ImageView imghape;

        public ViewHolder(View itemView) {
            super(itemView);

            //txthape = (TextView) itemView.findViewById(R.id.txthape);
            //imghape = (ImageView) itemView.findViewById(R.id.imghp);
        }
    }
}
