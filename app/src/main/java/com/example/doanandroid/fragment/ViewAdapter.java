package com.example.doanandroid.fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;


public class ViewAdapter extends FragmentStatePagerAdapter {
    public ViewAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new HocTapFragment();
            case 2:
                return new InformationFragment();
            default:
                return new HomeFragment();
        }

    }

    @Override
    public int getCount() {
        return 3;
    }
}
