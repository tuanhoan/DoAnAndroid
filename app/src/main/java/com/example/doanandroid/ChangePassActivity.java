package com.example.doanandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lib.Models.StudentModel;
import com.example.lib.Retrofit.RetrofitClient;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChangePassActivity extends AppCompatActivity {

    TextView txtMatKhauCu;
    TextView txtMatKhauMoi;
    TextView txtNhapLai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass);
        txtMatKhauCu = findViewById(R.id.txtMatKhauCu);
        txtMatKhauMoi = findViewById(R.id.txtMatKhauMoi);
        txtNhapLai = findViewById(R.id.txtNhapLai);
    }
    private void setupFloatingLabelError() {
        final TextInputLayout floatingOldPassLabel = (TextInputLayout) findViewById(R.id.oldpass_text_input_layout);
        floatingOldPassLabel.getEditText().addTextChangedListener(new TextWatcher() {
            // ...
            @Override
            public void onTextChanged(CharSequence text, int start, int count, int after) {
                if (text.length() <= 4) {
//                    floatingOldPassLabel.setError(getString(R.string.username_required));
                    floatingOldPassLabel.setErrorEnabled(true);
                } else {
                    floatingOldPassLabel.setErrorEnabled(false);
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void btnChange(View view) {
        if(!txtMatKhauCu.getText().toString().equals(Login.Student.getPassword().toString())){
            Toast.makeText(ChangePassActivity.this, "Mật khẩu không chính xác", Toast.LENGTH_SHORT).show();
        }else if(txtMatKhauMoi.getText().toString().equals(txtMatKhauCu.getText().toString())){
            Toast.makeText(ChangePassActivity.this, "Mật khẩu không được trùng mật khẩu cũ", Toast.LENGTH_SHORT).show();
        }else {
            if(!txtMatKhauMoi.getText().toString().equals(txtNhapLai.getText().toString())){
                Toast.makeText(ChangePassActivity.this, "Mật khẩu không khớp với nhau", Toast.LENGTH_SHORT).show();
            }else {
                Call<StudentModel> call = RetrofitClient.getInstance().getMyApi().ChangePasswWord(Login.Student.getId(),txtMatKhauMoi.getText().toString());
                call.enqueue(new Callback<StudentModel>() {
                     @Override
                     public void onResponse(Call<StudentModel> call, Response<StudentModel> response) {
//                         Intent i = new Intent(Intent.ACTION_SEND);
//                         i.setType("message/rfc822");
//                         i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"ntanh.hutech@gmail.com"});
//                         i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
//                         i.putExtra(Intent.EXTRA_TEXT   , "body of email");
//                         i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                         startActivity(i);
//                         try {
//                             startActivity(Intent.createChooser(i, "Send mail..."));
//                         } catch (android.content.ActivityNotFoundException ex) {
//                             Toast.makeText(ChangePassActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
//                         }
                         Toast.makeText(ChangePassActivity.this, "Đổi mật khẩu thành công", Toast.LENGTH_SHORT).show();
                         Intent intent = new Intent(ChangePassActivity.this, Login.class);
                         startActivity(intent);
                     }

                     @Override
                     public void onFailure(Call<StudentModel> call, Throwable t) {
                         Toast.makeText(ChangePassActivity.this, "Có lỗi xảy ra khi đổi mật khẩu", Toast.LENGTH_SHORT).show();
                     }
                 } );
            }
        }
    }
}