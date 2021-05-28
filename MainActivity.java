package com.example.helper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {
    NavigationView navigationView;
 private DrawerLayout mDrawerlayout;
 private ActionBarDrawerToggle mToggle;
TextView search,rate,helpecnters,map;
TextView one,two;
MenuItem three;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        // assigning the listener to the NavigationView
        one =  (TextView) findViewById(R.id.one);
        two =  (TextView) findViewById(R.id.two);
        three =  (MenuItem) findViewById(R.id.nav_item_our);
        search = (TextView)findViewById(R.id.search);
        helpecnters = (TextView)findViewById(R.id.helpcenters);
        map = (TextView)findViewById(R.id.map);
        rate = (TextView)findViewById(R.id.rate);
        mDrawerlayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this,mDrawerlayout, R.string.open , R.string.close);
        mDrawerlayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);


        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SignupActivity.class));
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, search.class));
            }
        });

        helpecnters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, helpcenters.class));
            }
        });
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, searchonmap.class));
            }
        });
        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,rate.class));
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem Item) {

        int id =Item.getItemId();

        if(id == R.id.nav_item_three){
            startActivity(new Intent(MainActivity.this, Email.class));
        }
        if(id == R.id.nav_item_two){
            startActivity(new Intent(MainActivity.this, call.class));
        }
        if(id == R.id.nav_item_our){
            action();
        }


        return true;

}
public void action(){
    Intent shareIntent = new Intent(Intent.ACTION_SEND);
    shareIntent.setType("text/plain");
    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "insert Subject here");
    String app_url = "https://play.google.com/store/apps/details?id=com.example.administrator";
    shareIntent.putExtra(Intent.EXTRA_TEXT, app_url);
    startActivity(Intent.createChooser(shareIntent, "share via"));
}}
