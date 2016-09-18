package com.example.tmend.navdrawerfaad;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
//        listen for clicks in the actionbar
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);



    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

       switch (item.getItemId()) {

           case R.id.nav_menu_1:
               Toast.makeText(MainActivity.this, "View Foods", Toast.LENGTH_SHORT).show();
               break;
           case R.id.nav_menu_2:
               Toast.makeText(MainActivity.this, "View Food Alternatives", Toast.LENGTH_SHORT).show();
               break;
           case R.id.nav_menu_3:
               Toast.makeText(MainActivity.this, "Consult Food Adviser", Toast.LENGTH_SHORT).show();
               break;
           case R.id.nav_menu_4:
               Toast.makeText(MainActivity.this, "Edit Details", Toast.LENGTH_SHORT).show();
               break;

       }
        DrawerLayout dl = (DrawerLayout) findViewById(R.id.drawerLayout);
        if(dl.isDrawerOpen(GravityCompat.START))
            dl.closeDrawer(GravityCompat.START);


        return false;
    }
}
