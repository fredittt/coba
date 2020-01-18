package com.example.rpl2016_09.coba;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by RPL2016-09 on 1/14/2020.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<Siswa> rvData;

    public Adapter(ArrayList<Siswa> rvData){
        this.rvData = rvData;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.e("","onBindViewHolder:" + rvData.get(position).getNama());
        holder.menetapkanSiswa(rvData.get(position));

    }


    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvnama;
        public TextView tvkelas;
        public TextView tvalamat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvnama = (TextView) itemView.findViewById(R.id.nama);
            tvkelas = (TextView) itemView.findViewById(R.id.kelas);
            tvalamat = (TextView) itemView.findViewById(R.id.alamat);
        }

        public void menetapkanSiswa(Siswa siswa) {
            Log.e("","menetapkansiswa:" + siswa.getNama());
            tvnama.setText(siswa.nama);
            tvkelas.setText(siswa.kelas);
            tvalamat.setText(siswa.alamat);
        }
    }
}
