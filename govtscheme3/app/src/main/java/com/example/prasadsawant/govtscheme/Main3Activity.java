package com.example.prasadsawant.govtscheme;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ListView;
import android.widget.TextView;


import com.google.firebase.FirebaseApp;

import mFragments.Farmer;
import mFragments.MyPageAdapter;
import mFragments.Students;
import mFragments.Women;

public class Main3Activity extends AppCompatActivity implements  TabLayout.OnTabSelectedListener{




    private ViewPager mViewPager;
    private TabLayout mtabLayout;
    private ListView lv;

    final static String urlAddress = "http://127.0.0.1/webapp/farmerData.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);





        mViewPager= (ViewPager) findViewById(R.id.Listcontainer);
        this.addPages();

        ///////////
        mtabLayout = (TabLayout) findViewById((R.id.tabLayout));
        mtabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        mtabLayout.setupWithViewPager(mViewPager);
        mtabLayout.setOnTabSelectedListener(this);

    }

    private  void addPages(){

        MyPageAdapter pageAdapter = new MyPageAdapter(this.getSupportFragmentManager());
        pageAdapter.addFragment(new Farmer());
        pageAdapter.addFragment(new Women());
        pageAdapter.addFragment(new Students());

        ///////////
        mViewPager.setAdapter(pageAdapter);
    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        mViewPager.setCurrentItem(tab.getPosition());

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
