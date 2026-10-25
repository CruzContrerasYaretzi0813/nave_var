package com.example.manifest;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {

    private static final int NAV_HOME = R.id.nav_home;
    private static final int NAV_SETTINGS = R.id.nav_settings;
    private static final int NAV_SHARE = R.id.nav_share;
    private static final int NAV_ABOUT = R.id.nav_about;
    private static final int NAV_LOGOUT = R.id.nav_logout;
    private DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new Homefragment()).commit();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        drawerLayout.closeDrawer(GravityCompat.START);
        if (itemId == NAV_HOME) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new Homefragment()).commit();
        } else if (itemId == NAV_SETTINGS) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new Settingsfragment()).commit();
        } else if (itemId == NAV_SHARE) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new Sharefragment()).commit();
        } else if (itemId == NAV_ABOUT) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new Aboutfragment()).commit();
        }
        return true;
    }
}

