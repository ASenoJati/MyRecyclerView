package com.example.myrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemAdapter.OnItemClickListener {

    RecyclerView rvListMakanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        rvListMakanan = (RecyclerView) findViewById(R.id.rvListMakanan);
        rvListMakanan.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<ItemModel> dataMakanan = new ArrayList<>();
        dataMakanan.add(new ItemModel("Soto Ayam",R.drawable.soto, "Rp. 10.000", "Soto Ayam Khas Kudus"));
        dataMakanan.add(new ItemModel("Nasi Goreng", R.drawable.nasgor,"Rp. 15.000", "Nasgor + Telur"));
        dataMakanan.add(new ItemModel("Mie Ayam", R.drawable.mieayam,"Rp. 17.000", "Mie Ayam + Nasi"));
        dataMakanan.add(new ItemModel("Bebek Goreng", R.drawable.bebek,"Rp. 25.000", "Bebek Goreng Sambal Trasi"));
        dataMakanan.add(new ItemModel("Ayam Goreng", R.drawable.ayamgoreng,"Rp. 15.000", "Ayam Goreng Khas Kudus"));
        dataMakanan.add(new ItemModel("Ayam Geprek", R.drawable.ayamgeprek,"Rp. 17.000", "Ayam Geprek"));

        ItemAdapter ItemAdapter = new ItemAdapter(dataMakanan,this);
        rvListMakanan.setAdapter(ItemAdapter);
    }

    @Override
    public void onItemClick(ItemModel itemModel) {
        //Toast.makeText(this,itemModel.getNamaMakanan(),Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, DetailMakananActivity.class);
        intent.putExtra("namaMakanan",itemModel.getNamaMakanan());
        intent.putExtra("hargaMakanan", itemModel.getHargaMakanan());
        intent.putExtra("desc", itemModel.getDesc());
        intent.putExtra("img", itemModel.getImageResId());
        startActivity(intent);
    }
}