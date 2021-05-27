package com.example.movies.Pages.Fragments;

import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PagerAdaptor extends FragmentPagerAdapter {

    private int numberOfTabs;
    private ArrayList<TabItem> tabItems;
    public PagerAdaptor(FragmentManager fragmentManager , int numberOfTabs , ArrayList<TabItem> tabItems){
        super(fragmentManager);
        this.numberOfTabs = numberOfTabs;
        this.tabItems =tabItems;
    }

    //TODO: sych problem between tabs and fragments
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 :
                //tabItems.get(0).setSelected(true);
                return AllFragment.newInstance();
            case 1 :
                //tabItems.get(1).setSelected(true);
                return SearchFragment.newInstance();
            case 2 :
                //tabItems.get(2).setSelected(true);
                return SavedFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
