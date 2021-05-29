package com.example.movies.Pages.Fragments;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyPagerAdaptor extends FragmentPagerAdapter {

    private static final String[] TAB_TITLES = new String[]{"All", "Search"
            , "Saved"};
    private Fragment []fragments;

    public MyPagerAdaptor(FragmentManager fragmentManager , Fragment []fragments) {
        super(fragmentManager);
        this.fragments =fragments;
    }

    //TODO: sych problem between tabs and fragments
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return fragments[0];
            case 1:
                return fragments[1];
            case 2:
                return fragments[2];
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
