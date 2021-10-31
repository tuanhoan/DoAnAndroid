package com.example.doanandroid.Adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.doanandroid.MainActivity;
import com.example.doanandroid.R;
import com.example.lib.Models.ScoreModel;


public class DiemAdapter extends ArrayAdapter<ScoreModel> {
    Activity activity;
    int resource;
    TextView txtMonHoc;
    TextView txtMieng;
    TextView txt15P;
    TextView txt60P;
    TextView txtGiuaKy;
    TextView txtCuoiKy;
    TextView txtTB;
    public DiemAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.activity = (Activity) context;
        this.resource = resource;
    }
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        LayoutInflater layoutInflater = this.activity.getLayoutInflater();
//        View spView = layoutInflater.inflate(this.resource, null);
//        ScoreModel score = getItem(position);
//
//        float diemMieng = score.getMouthTest();
//        float diem15P = score.getTest15m();
//        float diem60P = score.getTest60m();
//        float diemGiuaKy = score.getOralTest();
//        float diemCuoiKy = score.getFinalTest();
//        txtMonHoc.setText(score.getSubjectNavigation().getName());
//        txtMieng.setText(diemMieng+"");
//        txt15P.setText(diem15P+"");
//        txt60P.setText(diem60P+"");
//        txtGiuaKy.setText(diemGiuaKy+"");
//        txtCuoiKy.setText(diemCuoiKy+"");
//        float TB = (diem15P + diemMieng + diem60P*2 + diemGiuaKy*2 + diemCuoiKy*3)/9;
//        txtTB.setText(TB+"");
//
//        return spView;
//    }
}
