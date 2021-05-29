package com.example.movies.Pages;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.movies.Pages.Fragments.AllFragment;
import com.example.movies.Pages.Fragments.MyPagerAdaptor;
import com.example.movies.Pages.Fragments.SavedFragment;
import com.example.movies.Pages.Fragments.SearchFragment;
import com.example.movies.R;
import com.google.android.material.tabs.TabLayout;

public class BasicActivity extends AppCompatActivity {


    private TabLayout tablayout;
    private ViewPager viewPager;
    private Fragment []fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

        tablayout = findViewById(R.id.tab_layout_for_pages);
        viewPager = findViewById(R.id.view_pager);
        fragments = new Fragment[3];
        fragments[0] = AllFragment.newInstance();
        fragments[1] = SearchFragment.newInstance();
        fragments[2] = SavedFragment.newInstance();

        MyPagerAdaptor myPagerAdaptor= new MyPagerAdaptor(getSupportFragmentManager() , fragments);
        viewPager.setAdapter(myPagerAdaptor);
        viewPager.setOffscreenPageLimit(3);
        tablayout.setupWithViewPager(viewPager);
    }
}
