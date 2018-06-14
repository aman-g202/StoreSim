package com.hotwaxsystems.www.wscautomation.view;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.hotwaxsystems.www.wscautomation.R;
import com.hotwaxsystems.www.wscautomation.view.BalanceFragment;
import com.hotwaxsystems.www.wscautomation.view.DashboardFragment;
import com.hotwaxsystems.www.wscautomation.view.OrganizationFragment;
import com.hotwaxsystems.www.wscautomation.view.PaymentsFragment;
import com.hotwaxsystems.www.wscautomation.view.ProductsFragment;
import com.hotwaxsystems.www.wscautomation.view.PromotionsFragment;

public class DrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, new DashboardFragment())
                .commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void setAppBarTitle(String title) {
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null)
        actionBar.setTitle(title);
    }

    //@SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        //ActionBar actionBar = getSupportActionBar();

        if (id == R.id.nav_dashboard) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new DashboardFragment())
                    .commit();
        } else if (id == R.id.nav_products) {
            //actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00C4CD")));
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new ProductsFragment())
                    .commit();
        } else if (id == R.id.nav_balance) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new BalanceFragment())
                    .commit();
        } else if (id == R.id.nav_organization) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new OrganizationFragment())
                    .commit();
        } else if (id == R.id.nav_payments) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new PaymentsFragment())
                    .commit();
        } else if (id == R.id.nav_promotions) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new PromotionsFragment())
                    .commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
