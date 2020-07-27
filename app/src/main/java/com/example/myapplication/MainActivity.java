package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.myapplication.Fragment.DashBoardFragment;
import com.example.myapplication.Fragment.ProfileFragment;
import com.example.myapplication.Fragment.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView BN_navigation = findViewById(R.id.BN_navigation);

        BN_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.framLayout, new SettingFragment());
        fragmentTransaction.commit();


    }

    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            switch (menuItem.getItemId()) {
                case R.id.menu_home:
                    fragmentTransaction.replace(R.id.framLayout, new DashBoardFragment());

                    break;

                case R.id.menu_matches:
                    fragmentTransaction.replace(R.id.framLayout, new SettingFragment());
                    break;

                case R.id.menu_more:
                    fragmentTransaction.replace(R.id.framLayout, new ProfileFragment());
                    break;
            }
            fragmentTransaction.commit();
            return true;
        }
    };


}