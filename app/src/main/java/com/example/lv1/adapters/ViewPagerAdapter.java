package com.example.lv1.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.lv1.fragments.PersonalInfoFragment;
import com.example.lv1.fragments.StudentInfoFragment;
import com.example.lv1.fragments.SummaryInfoFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 3;

    public ViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new PersonalInfoFragment();
            case 1:
                return new StudentInfoFragment();
            case 2:
                return new SummaryInfoFragment();
            default:
                return null;
        }
    }
}
