package com.example.tugasakhir.database;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugasakhir.R;

import java.util.ArrayList;

public class ReadActivity extends AppCompatActivity {

    private TimAdapter timAdapter;
    private RecyclerView recyclerView;
    private AppDatabase appDatabase;
    private ArrayList<TimModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        recyclerView.findViewById(R.id.rv_read);
        timAdapter = new TimAdapter(getApplicationContext());
        timAdapter.notifyDataSetChanged();

        if(appDatabase == null){
            appDatabase = AppDatabase.initDatabase(getApplicationContext());
        }

        list.addAll(appDatabase.timDAO().getTim());
        timAdapter.setData(list);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(timAdapter);

    }
}
