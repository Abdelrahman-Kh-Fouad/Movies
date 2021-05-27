package com.example.movies.Pages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.movies.Pages.Fragments.PagerAdaptor;
import com.example.movies.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class BasicActivity extends AppCompatActivity {


    private TabLayout tablayout;
    private TabItem allItem;
    private TabItem searchItem;
    private TabItem savedItem;
    private ViewPager viewPager;
    private ArrayList<TabItem> tabItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

        tablayout= (TabLayout) findViewById(R.id.tab_layout_for_pages);
        allItem= (TabItem) findViewById(R.id.all_tab);
        searchItem= (TabItem) findViewById(R.id.search_tab);
        savedItem= (TabItem) findViewById(R.id.saved_tab);
        viewPager= (ViewPager) findViewById(R.id.view_pager);

        tabItems= new ArrayList<TabItem>();
        tabItems.add(allItem);
        tabItems.add(searchItem);
        tabItems.add(savedItem);


        PagerAdaptor pagerAdaptor = new PagerAdaptor(getSupportFragmentManager() , tablayout.getTabCount() ,tabItems);
        viewPager.setAdapter(pagerAdaptor);
        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}
            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });

    }
}