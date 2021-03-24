package com.info.uygulama;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private Fragment tempFragment;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Veritabani veritabani;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //idler
        drawer = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        tempFragment = new FragmentBirinci();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_tutucu, tempFragment).commit();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this, drawer, toolbar, 0, 0);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.inflateHeaderView(R.layout.menu_baslik);
        navigationView.setNavigationItemSelectedListener(this);

        veritabani = new Veritabani(getApplicationContext());

        if (getIntent().hasExtra("username")) {
            View viewYazi = navigationView.getHeaderView(0);
            TextView newUser = viewYazi.findViewById(R.id.textViewMainKullaniciAdi);
            newUser.setText("Merhaba : " + getIntent().getStringExtra("username").toUpperCase());

            SQLiteDatabase database = veritabani.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("kullaniciAdi", getIntent().getStringExtra("username").toUpperCase());
            database.update("kullanici", values, null,null);

        } else {
            View viewYazi = navigationView.getHeaderView(0);
            TextView newUser = (TextView) viewYazi.findViewById(R.id.textViewMainKullaniciAdi);

            SQLiteDatabase database = veritabani.getWritableDatabase();
            Cursor c = database.rawQuery("SELECT * FROM kullanici", null);

            while (c.moveToNext()) {
                newUser.setText("Merhaba : " + c.getString(c.getColumnIndex("kullaniciAdi")));
            }

            database.close();
        }


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.nav_birinci) {
            tempFragment = new FragmentBirinci();
        }
        if (item.getItemId() == R.id.nav_ikinci) {
            tempFragment = new FragmentIkinci();
        }
        if (item.getItemId() == R.id.nav_ucuncu) {
            tempFragment = new FragmentUcuncu();
        }
        if (item.getItemId() == R.id.nav_logout) {
            sharedPreferences = getSharedPreferences("GirisBilgileri", MODE_PRIVATE);
            editor = sharedPreferences.edit();
            editor.remove("login");
            editor.remove("username");
            editor.remove("password");
            editor.commit();

            startActivity(new Intent(MainActivity.this, GirisActivity.class));
            finish();
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_tutucu, tempFragment).commit();

        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }


}