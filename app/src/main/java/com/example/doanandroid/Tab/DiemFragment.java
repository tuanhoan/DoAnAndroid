package com.example.doanandroid.Tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.doanandroid.Login;
import com.example.doanandroid.MainActivity;
import com.example.doanandroid.R;
import com.example.lib.Models.ScoreModel;
import com.example.lib.Retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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
    int i = 1;
    float finalDTB = 0;

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





        Call<List<ScoreModel>> call = RetrofitClient.getInstance().getMyApi().GetScoreByStudentId(Login.Student.getId());
        call.enqueue(new Callback<List<ScoreModel>>() {
                         @Override
                         public void onResponse(Call<List<ScoreModel>> call, Response<List<ScoreModel>> response) {
                             try {
                                 for (ScoreModel item: response.body()
                                      ) {
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


                                     txtMonHoc.setText(item.subjectNavigation.getName().toString());
                                     txtMieng.setText(item.getMouthTest()+"");
                                     txt15P.setText(item.getTest15m() + "");
                                     txt60P.setText(item.getTest60m()+"");
                                     txtGiuaKy.setText(item.getOralTest()+"");
                                     txtCuoiKy.setText(item.getFinalTest() + "");
                                     float dtb = (item.getMouthTest() +item.getTest15m()+item.getTest60m()*2+item.getOralTest()*2+item.getFinalTest()*3)/9;
                                     txtTB.setText(String.format("%.2f",dtb));

                                     finalDTB += dtb;

                                     row.addView(txtMonHoc);
                                     row.addView(txtMieng);
                                     row.addView(txt15P);
                                     row.addView(txt60P);
                                     row.addView(txtGiuaKy);
                                     row.addView(txtCuoiKy);
                                     row.addView(txtTB);
                                     tableLayout.addView(row, i);
                                     i++;
                                 }

                                 String dts =  String.format("%.2f",finalDTB/13);
                                 txtDiemTrungBinh.setText( dts);
                                 if(finalDTB/13>=8){
                                     txtXepLoai.setText("Giỏi");
                                 }else if(finalDTB/13>=6.5 &&finalDTB<8){
                                     txtXepLoai.setText("Khá");
                                 }
                                 else  if(finalDTB/13>=5&&finalDTB<6.5){
                                     txtXepLoai.setText("Trung bình");
                                 }else {
                                     txtXepLoai.setText("Yếu");
                                 }
                                 }
                             catch (Exception ex){
                             }
                         }

                         @Override
                         public void onFailure(Call<List<ScoreModel>> call, Throwable t) {

                         }
                     });



        return mview;
    }
}