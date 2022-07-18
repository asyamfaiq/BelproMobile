package com.example.belpro6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private BerandaFragment berandaFragment;
    private AkunFragment akunFragment;
    private YoutubeFragment youtubeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomnavigasi);
        berandaFragment = new BerandaFragment();
        akunFragment = new AkunFragment();
        youtubeFragment = new YoutubeFragment();

        setFragment(berandaFragment);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.beranda:
                        setFragment(berandaFragment);
                        return true;
                    case R.id.user:
                        setFragment(akunFragment);
                        return true;
                    case R.id.laporan:
                        setFragment(youtubeFragment);
                        return true;
                    default:
                        return false;
                }
            }
        });

    }
                public void setFragment (Fragment fragment){
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager() .beginTransaction();
                    fragmentTransaction.replace(R.id.konten, fragment);
                    fragmentTransaction.commit();
                }
}