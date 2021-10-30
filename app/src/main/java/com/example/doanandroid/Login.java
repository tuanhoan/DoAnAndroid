package com.example.doanandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lib.Models.StudentModel;
import com.example.lib.Retrofit.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    TextView txtTenDangNhap;
    TextView txtMatKhau;
    public  static  StudentModel Student ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtTenDangNhap = findViewById(R.id.txtTenDangNhap);
        txtMatKhau = findViewById(R.id.txtMatKhau);
    }

    public void btnLogin(View view) {
        Call<StudentModel> call = RetrofitClient.getInstance().getMyApi().Login(txtTenDangNhap.getText().toString(),txtMatKhau.getText().toString());
        call.enqueue(new Callback<StudentModel>() {
             @Override
             public void onResponse(Call<StudentModel> call, Response<StudentModel> response) {
                 if (response.body()!=null) {
                     Intent intent = new Intent(Login.this, MainActivity.class);
                     startActivity(intent);
                     Student = response.body();
                     Toast.makeText(Login.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                 } else {
                     Toast.makeText(Login.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                 }
             }

             @Override
             public void onFailure(Call<StudentModel> call, Throwable t) {

             }
         });
    }
}