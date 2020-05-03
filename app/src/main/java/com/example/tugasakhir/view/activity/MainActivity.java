package com.example.tugasakhir.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.tugasakhir.R;
import com.example.tugasakhir.database.DatabaseFragment;
import com.example.tugasakhir.view.fragment.ClubFragment;
import com.example.tugasakhir.view.fragment.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private Fragment selectedFragment = new HomeFragment();
    private BottomNavigationView bottomNavigationView;

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
    public void pindah (View view){
        Intent intent = new Intent(MainActivity.this, DatabaseFragment.class);
        startActivity(intent);

    }
}
