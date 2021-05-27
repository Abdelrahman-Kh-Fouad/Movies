package com.example.movies.Pages.Fragments;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdaptor extends FragmentPagerAdapter {

    private int numberOfTabs;
    public PagerAdaptor(FragmentManager fragmentManager , int numberOfTabs){
        super(fragmentManager);
        this.numberOfTabs = numberOfTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 :
                return new AllFragment();
            case 1 :
                return new SearchFragment();
            case 2 :
                return new SavedFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
