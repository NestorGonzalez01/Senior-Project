package com.example.mycloset;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NonNls;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.mytoolbar);

        //Toolbar
        setSupportActionBar(toolbar);

        //Navigation drawer menu
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_home);
    }

    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                break;
            case R.id.nav_closet:
                Intent intent = new Intent(HomeActivity.this, ViewCloset.class);
                startActivity(intent);
                break;
            case R.id.nav_outfit:
                Intent intent2 = new Intent(HomeActivity.this, ViewOutfits.class);
                startActivity(intent2);
                break;
            case R.id.nav_create:
                Intent intent3 = new Intent(HomeActivity.this, CreateOutfit.class);
                startActivity(intent3);
                break;
            case R.id.nav_add:
                break;
            case R.id.nav_style:
                Intent intent5 = new Intent(HomeActivity.this, StyleMe.class);
                startActivity(intent5);
                break;
        }

        drawerLayout.closeDrawer((GravityCompat.START));
        return true;
    }
}