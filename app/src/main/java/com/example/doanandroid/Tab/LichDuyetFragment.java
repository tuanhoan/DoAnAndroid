package com.example.doanandroid.Tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;


import com.example.doanandroid.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LichDuyetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LichDuyetFragment extends Fragment {



    public LichDuyetFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lich_duyet, container, false);
    }
}