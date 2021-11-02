package com.example.doanandroid.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;


import com.example.doanandroid.R;
import com.example.doanandroid.Tab.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;


public class HocTapFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    View mview;

    public HocTapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         //Inflate the layout for this fragment
        mview = inflater.inflate(R.layout.fragment_hoc_tap, container, false);

        tabLayout=mview.findViewById(R.id.Tablayout);
        viewPager=mview.findViewById(R.id.listtab);

        ViewPagerAdapter adapter =new ViewPagerAdapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
        return mview;
    }
}
