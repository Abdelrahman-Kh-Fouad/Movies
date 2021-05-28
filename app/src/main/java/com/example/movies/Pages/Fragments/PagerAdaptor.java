package com.example.movies.Pages.Fragments;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdaptor extends FragmentPagerAdapter {

    private static final String[] TAB_TITLES = new String[]{"All", "Search"
            , "Saved"};


    public PagerAdaptor(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    //TODO: sych problem between tabs and fragments
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return AllFragment.newInstance();
            case 1:
                return SearchFragment.newInstance();
            case 2:
                return SavedFragment.newInstance();
            default:
                throw new IndexOutOfBoundsException("Not a valid index for tabs");
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return TAB_TITLES[position];
    }

    @Override
    public int getCount() {
        return TAB_TITLES.length;
    }
}
