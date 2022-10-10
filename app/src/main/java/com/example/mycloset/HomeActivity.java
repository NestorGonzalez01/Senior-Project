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
        setTheme(androidx.appcompat.R.style.Theme_AppCompat_NoActionBar);
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
                Intent intent_closet = new Intent(HomeActivity.this, ViewCloset.class);
                startActivity(intent_closet);
                break;
            case R.id.nav_outfit:
                Intent intent_outfit = new Intent(HomeActivity.this, ViewOutfits.class);
                startActivity(intent_outfit);
                break;
            case R.id.nav_create:
                Intent intent_create = new Intent(HomeActivity.this, CreateOutfit.class);
                startActivity(intent_create);
                break;
            case R.id.nav_add:
                Intent intent_add = new Intent(HomeActivity.this, Camera.class);
                startActivity(intent_add);
                break;
            case R.id.nav_style:
                Intent intent_style = new Intent(HomeActivity.this, StyleMe.class);
                startActivity(intent_style);
                break;
        }

        drawerLayout.closeDrawer((GravityCompat.START));
        return true;
    }
}