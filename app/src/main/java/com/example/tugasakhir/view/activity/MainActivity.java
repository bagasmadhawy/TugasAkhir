package com.example.tugasakhir.view.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.tugasakhir.R;
import com.example.tugasakhir.database.AppDatabase;
import com.example.tugasakhir.view.fragment.BestFragment;
import com.example.tugasakhir.view.fragment.ClubFragment;
import com.example.tugasakhir.view.fragment.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private Fragment selectedFragment = new HomeFragment();
    private BottomNavigationView bottomNavigationView;
    private AppDatabase appDatabase;
    private Button btn_lihat, btn_Simpan;
    private EditText nama, tahun, tim, posisi, namaNeg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.activitymain_bottomnav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        loadFragment(selectedFragment);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.menu_bottomnav_home:
                selectedFragment = new HomeFragment();
                loadFragment(selectedFragment);
                break;
            case R.id.menu_bottomnav_club:
                selectedFragment = new ClubFragment();
                loadFragment(selectedFragment);
                break;
            case R.id.menu_bottomnav_top:
                selectedFragment = new BestFragment();
                loadFragment(selectedFragment);
                break;
        }

        return loadFragment(selectedFragment);
    }

    private boolean loadFragment(Fragment selectedFragment) {
        if (selectedFragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.activitymain_fragmentcontainer,selectedFragment)
                    .commit();

            return true;
        }
        return false;
    }
}
