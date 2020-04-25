package com.example.tugasakhir.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tugasakhir.R;

public class DetailClub extends AppCompatActivity {

    ImageView ivLogo;
    TextView tvNama, tvTahun, tvStadium, tvLiga, tvWebsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_club);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ivLogo = findViewById(R.id.iv_detail_logo_club);
        tvNama = findViewById(R.id.tv_detail_nama_club);
        tvTahun = findViewById(R.id.tv_detail_tahun_club);
        tvStadium = findViewById(R.id.tv_detail_stadium_club);
        tvLiga = findViewById(R.id.tv_detail_liga_club);
        tvWebsite = findViewById(R.id.tv_detail_website_club);

        getIncomingIntent();
    }

    private void getIncomingIntent() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int getLogo = bundle.getInt("logo");
            String getNama = bundle.getString("name");
            String getTahun = bundle.getString("tahun");
            String getStadium = bundle.getString("stadium");
            String getLiga = bundle.getString("liga");
            String getWebsite = bundle.getString("website");

            ivLogo.setImageResource(getLogo);
            tvNama.setText(getNama);
            tvTahun.setText(getTahun);
            tvStadium.setText(getStadium);
            tvLiga.setText(getLiga);
            tvWebsite.setText(getWebsite);
        } else {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }
}
