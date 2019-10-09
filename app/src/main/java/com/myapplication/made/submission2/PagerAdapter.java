package com.myapplication.made.submission2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    private int number_tabs;

    public PagerAdapter(FragmentManager fm, int number_tabs) {
        super(fm);
        this.number_tabs = number_tabs;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new FilmFragment();
            case 1:
                return new TvFragment();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return number_tabs;
    }
}
