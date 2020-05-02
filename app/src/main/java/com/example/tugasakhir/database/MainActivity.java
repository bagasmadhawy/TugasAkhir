package com.example.tugasakhir.database;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tugasakhir.R;

public class MainActivity extends AppCompatActivity {
    private AppDatabase appDatabase;
    private Button btn_lihat, btn_Simpan;
    private EditText nama, tahun, tim, posisi, namaNeg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_best);

        btn_lihat = findViewById(R.id.btn_lihat);
        btn_Simpan = findViewById(R.id.btn_simpan);

        nama = findViewById(R.id.et_namaPemain);
        tahun = findViewById(R.id.et_tahun);
        tim = findViewById(R.id.et_namaTim);
        posisi = findViewById(R.id.et_namaPosisi);
        namaNeg = findViewById(R.id.et_asalnegara);

        appDatabase = AppDatabase.initDatabase(getApplicationContext());

        btn_Simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    TimModel timModel = new TimModel();
                    timModel.setNama(nama.getText().toString());
                    timModel.setTahun(tahun.getText().toString());
                    timModel.setTim(tim.getText().toString());
                    timModel.setPosisi(posisi.getText().toString());
                    timModel.setAsalNeg(namaNeg.getText().toString());

                    appDatabase.timDAO().insertTim(timModel);

                    Log.d("MainActivity", "Sukses!");
                    Toast.makeText(getApplicationContext(), "Berhasil Menyimpan", Toast.LENGTH_SHORT).show();
                } catch (Exception ex) {
                    Log.e("MainActivity", "Gagal Menyimpan, Msg = " + ex.getMessage());
                    Toast.makeText(getApplicationContext(), "Gagal Menyimpan", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_lihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ReadActivity.class);

                startActivity(intent);

            }
        });
    }

}
