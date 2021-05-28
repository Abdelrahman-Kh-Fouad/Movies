package com.example.movies.Pages;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.movies.Pages.Fragments.PagerAdaptor;
import com.example.movies.R;
import com.google.android.material.tabs.TabLayout;

public class BasicActivity extends AppCompatActivity {


    private TabLayout tablayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

        tablayout = findViewById(R.id.tab_layout_for_pages);
        viewPager = findViewById(R.id.view_pager);


        PagerAdaptor pagerAdaptor = new PagerAdaptor(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdaptor);
        tablayout.setupWithViewPager(viewPager);
    }
}
