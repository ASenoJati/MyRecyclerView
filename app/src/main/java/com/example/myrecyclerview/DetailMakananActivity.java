package com.example.myrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailMakananActivity extends AppCompatActivity {

    TextView tvNamaMakanan;
    TextView tvHargaMakanan;
    TextView tvDetailMakanan;
    ImageView imageView;
    Button btnBackToHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail_makanan);

        tvNamaMakanan = (TextView) findViewById(R.id.tvNamaMakanan);
        tvHargaMakanan = (TextView) findViewById(R.id.tvHargaMakanan);
        tvDetailMakanan = (TextView) findViewById(R.id.tvDetailMakanan);
        imageView = (ImageView) findViewById(R.id.imageView);
        btnBackToHome = (Button) findViewById(R.id.btnBackToHome);

        // Menerima data dari intent
        Intent intent = getIntent();
        String namaMakanan = intent.getStringExtra("namaMakanan");
        String hargaMakanan = intent.getStringExtra("hargaMakanan");
        String desc = intent.getStringExtra("desc");
        Integer img = intent.getIntExtra("img",0);

        tvNamaMakanan.setText(namaMakanan);
        tvHargaMakanan.setText(hargaMakanan);
        tvDetailMakanan.setText(desc);
        imageView.setImageResource(img);

        btnBackToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailMakananActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}