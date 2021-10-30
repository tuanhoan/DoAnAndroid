package com.example.doanandroid.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.doanandroid.Login;
import com.example.doanandroid.MainActivity;
import com.example.doanandroid.R;
import com.example.lib.Models.StudentModel;
import com.example.lib.Retrofit.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class InformationFragment extends Fragment {
    View mview;
    Button btnCapNhat;
    MainActivity mainActivity;
    Intent intent;
    TextView txtHoTen;
    TextView txtMgaySinh;
    TextView txtSoDienThoai;
    TextView txtEmail;
    TextView txtDiaChi;
    public InformationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainActivity = (MainActivity) getActivity();
        mview = inflater.inflate(R.layout.fragment_information, container, false);
        btnCapNhat = mview.findViewById(R.id.btnUpdate);
        txtHoTen = mview.findViewById(R.id.txtHoTen);
        txtMgaySinh = mview.findViewById(R.id.txtMgaySinh);
        txtSoDienThoai = mview.findViewById(R.id.txtSoDienThoai);
        txtEmail = mview.findViewById(R.id.txtEmail);
        txtDiaChi = mview.findViewById(R.id.txtDiaChi);


        return mview;
    }
    @Override
    public void onStart() {
        super.onStart();
        txtHoTen.setText(Login.Student.getName());
        txtMgaySinh.setText(Login.Student.getBirthDay().toString());
        txtSoDienThoai.setText(Login.Student.getNumberPhone());
        txtEmail.setText(Login.Student.getEmail());
        txtDiaChi.setText(Login.Student.getAddress());
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnCapNhat();
            }
        });
    }

    public void btnCapNhat() {
        Login.Student.setName(txtHoTen.getText().toString());
        Login.Student.setEmail(txtEmail.getText().toString());
        Login.Student.setBirthDay(txtMgaySinh.getText().toString());
        Login.Student.setAddress(txtDiaChi.getText().toString());
        Login.Student.setNumberPhone(txtSoDienThoai.getText().toString());

        // StudentModel studentModel = new StudentModel(Login.Student.getId(),txtHoTen.getText().toString(),txtMgaySinh.getText().toString(),txtEmail.getText().toString(),txtSoDienThoai.getText().toString(),txtDiaChi.getText().toString());
        Call<StudentModel> call = RetrofitClient.getInstance().getMyApi().PutStudent(Login.Student.getId(),Login.Student);
        call.enqueue(new Callback<StudentModel>() {
            @Override
            public void onResponse(Call<StudentModel> call, Response<StudentModel> response) {
                //Login.Student = response.body();
//                finish();
//                startActivity(getIntent());
                Toast.makeText(mainActivity, "cập nhật thành công", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<StudentModel> call, Throwable t) {
                Toast.makeText(mainActivity, "cập nhật thất bại", Toast.LENGTH_SHORT).show();
            }
        });
    }
}