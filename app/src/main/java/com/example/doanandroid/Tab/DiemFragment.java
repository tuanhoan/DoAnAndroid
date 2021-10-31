package com.example.doanandroid.Tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.doanandroid.Adapters.DiemAdapter;
import com.example.doanandroid.Adapters.StudentAdapter;
import com.example.doanandroid.MainActivity;
import com.example.doanandroid.R;
import com.example.lib.Models.NewsFeedModel;
import com.example.lib.Models.ScoreModel;
import com.example.lib.Models.StudentModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the } factory method to
 * create an instance of this fragment.
 */
public class DiemFragment extends Fragment {

    View mview;

    MainActivity mainActivity;
    TableLayout tableLayout;
    TextView txtMonHoc;
    TextView txtMieng;
    TextView txt15P;
    TextView txt60P;
    TextView txtGiuaKy;
    TextView txtCuoiKy;
    TextView txtTB;
    TextView txtDiemTrungBinh;
    TextView txtXepLoai;

    public DiemFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainActivity = (MainActivity) getActivity();
        mview= inflater.inflate(R.layout.fragment_diem, container, false);
        tableLayout = (TableLayout) mview.findViewById(R.id.tbDiem);


        TableRow row = new TableRow(mainActivity);
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        row.setLayoutParams(lp);
        txtMonHoc = new TextView(mainActivity);
        txtMieng = new TextView(mainActivity);
        txt15P = new TextView(mainActivity);
        txt60P = new TextView(mainActivity);
        txtGiuaKy = new TextView(mainActivity);
        txtCuoiKy = new TextView(mainActivity);
        txtTB = new TextView(mainActivity);
        txtDiemTrungBinh = mview.findViewById(R.id.txtDiemTrungBinh);
        txtXepLoai = mview.findViewById(R.id.txtXepLoai);

        txtMonHoc.setText("Công Nghệ");
        txtMieng.setText("10");
        txt15P.setText("10");
        txt60P.setText("10");
        txtGiuaKy.setText("10");
        txtCuoiKy.setText("10");
        txtTB.setText("10");
        txtDiemTrungBinh.setText("10");
        txtXepLoai.setText("Xức sắt");
        row.addView(txtMonHoc);
        row.addView(txtMieng);
        row.addView(txt15P);
        row.addView(txt60P);
        row.addView(txtGiuaKy);
        row.addView(txtCuoiKy);
        row.addView(txtTB);
        tableLayout.addView(row, 1);
        return mview;
    }
}