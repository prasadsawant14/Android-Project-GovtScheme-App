package com.example.prasadsawant.govtscheme;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


import static com.example.prasadsawant.govtscheme.R.id.recyclerView;
import static com.example.prasadsawant.govtscheme.R.id.viewPager;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ViewPager viewPager;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private  RecyclerView.Adapter mAdapter;
    //private ArrayList<String> mDataset;
    private List<TrendingData> entry;
    Button button ;

//    List<ListDataItem> lstData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        //********womens page
//        lstData = new ArrayList<>();
//        lstData.add(new ListDataItem("womens1",R.drawable.dalailama));
//        lstData.add(new ListDataItem("womens2",R.drawable.news1));
//        lstData.add(new ListDataItem("womens3",R.drawable.news2));
//
//
//        ListView listView = (ListView)findViewById(R.id.listView_womens);
//        CustomListAdapter wAdapter = new CustomListAdapter(this,R.layout.item_row,lstData);
//        listView.setAdapter(wAdapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intentList =new Intent();
//                intentList.setClass(MainActivity.this,WomenListener.class);
//                startActivity(intentList);
//            }
//        });


        //********womens page ends
        button =(Button)findViewById(R.id.button101);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TrendingList.class);
                startActivity(intent);

            }
        });

        //==========
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);

        viewPager.setAdapter(viewPagerAdapter);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 2000, 4000);
        //===========

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //RecyclerView==================

        mRecyclerView = (RecyclerView) findViewById(recyclerView);
            mRecyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            mRecyclerView.setLayoutManager(mLayoutManager);
            initializeData();
        mAdapter = new MainAdapter(entry);
        mRecyclerView.setAdapter(mAdapter);
            //RecyclerViewEnds=====================


        }
    void initializeData() {
        entry = new ArrayList<>();
        entry.add(new TrendingData("The Digital India programme is a flagship programme of the Government of India with a vision to transform India .....y.", R.drawable.rc1));
        entry.add(new TrendingData("Pradhan Mantri Jan-Dhan Yojana (PMJDY) is National Mission for Financial Inclusion to ensure access to financial services.....", R.drawable.rc2));
        entry.add(new TrendingData("The Swachh Bharat Abhiyan was launched formally on October 2, 2014, the birth a......", R.drawable.rc3));
        entry.add(new TrendingData("This was basically a slogan, coined by Narendra Modi on September 25, .....", R.drawable.rc4));
        entry.add(new TrendingData("On October 11, 2014, Prime Minister Narendra Modi launched the Saansad Adarsh Gram Yojana...", R.drawable.rc5));
    }


    //===================
    public  class  MyTimerTask extends TimerTask {

        @Override
        public void run() {

            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if (viewPager.getCurrentItem() == 0) {
                        viewPager.setCurrentItem(1);
                    } else if (viewPager.getCurrentItem() == 1) {
                        viewPager.setCurrentItem(2);
                    } else if (viewPager.getCurrentItem() == 2) {
                        viewPager.setCurrentItem(3);
                    } else if (viewPager.getCurrentItem() == 3) {
                        viewPager.setCurrentItem(4);
                    } else if (viewPager.getCurrentItem() == 4) {
                        viewPager.setCurrentItem(5);
                    } else {
                        viewPager.setCurrentItem(0);
                    }

                }
            });

        }

    }

//==================

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }







    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.navHome) {
            Intent intent = new Intent(MainActivity.this,MainActivity.class);
            startActivity(intent);


        } else if (id == R.id.navSchemes) {

            Intent intent = new Intent(this,Main3Activity.class);
            startActivity(intent);
        } else if (id == R.id.navAboutUs) {
            Intent intent = new Intent(this,AboutUs.class);
            startActivity(intent);
        } else if (id == R.id.navVersion) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
