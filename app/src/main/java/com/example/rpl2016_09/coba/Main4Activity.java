package com.example.rpl2016_09.coba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class Main4Activity extends AppCompatActivity {
    public ImageView image_info1;
    RecyclerView recyclerView;
    private  Adapter adapter;
    private ArrayList<Siswa> rvData = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        recyclerView = findViewById(R.id.recyclerview);
        adapter =  new Adapter(rvData);

        Log.e("","onCreate:"+ rvData.size());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        initDataset();
    }

    private void initDataset(){

            Siswa siswa1 = new Siswa();
            siswa1.setNama("Aldi");
            siswa1.setKelas("12");
            siswa1.setAlamat("Kudus");
            rvData.add(siswa1);


            Siswa siswa2 = new Siswa();
            siswa2.setNama("Anam");
            siswa2.setKelas("12");
            siswa2.setAlamat("Kudus");
            rvData.add(siswa2);

            Siswa siswa3 = new Siswa();
            siswa3.setNama("Diki");
            siswa3.setKelas("12");
            siswa3.setAlamat("Kudus");
            rvData.add(siswa3);


            Siswa siswa4 = new Siswa();
            siswa4.setNama("Fredi");
            siswa4.setKelas("12");
            siswa4.setAlamat("Jepara");
            rvData.add(siswa4);

            Siswa siswa5 = new Siswa();
            siswa5.setNama("Umar");
            siswa5.setKelas("12");
            siswa5.setAlamat("Kudus");
            rvData.add(siswa5);



    }
}
