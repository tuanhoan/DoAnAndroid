package com.example.doanandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.doanandroid.Adapters.CommentAdapter;
import com.example.lib.Models.CommentModel;
import com.example.lib.Models.NewsFeedModel;
import com.example.lib.Retrofit.RetrofitClient;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class NewsDetail extends AppCompatActivity {

    TextView txtNoiDung;
    TextView txtTitle;
    TextView txtNgayTao;
    TextView txtCmt;
    CommentAdapter commentAdapter = null;
    ListView lsvCmt;
    List<CommentModel> listComment;
    NewsFeedModel newsFeedModel;
    ImageView imgNews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        txtCmt = findViewById(R.id.txtCmt);
        txtTitle = findViewById(R.id.txtTieuDe);
        txtNgayTao = findViewById(R.id.txtNgayTao);

    }

    @Override
    protected void onStart() {
        super.onStart();

        lsvCmt = findViewById(R.id.lsvCmt);
        imgNews = findViewById(R.id.imgNews);
        newsFeedModel = (NewsFeedModel) getIntent().getSerializableExtra("newfeed");
        Picasso.get().load(newsFeedModel.getImg()).into(imgNews);
        listComment = new ArrayList<CommentModel>();
        commentAdapter = new CommentAdapter(NewsDetail.this, R.layout.comment_item);

        Call<List<CommentModel>> call = RetrofitClient.getInstance().getMyApi().GetCommentByPostId(newsFeedModel.getId());
        call.enqueue(new Callback<List<CommentModel>>() {
            @Override
            public void onResponse(Call<List<CommentModel>> call, Response<List<CommentModel>> response) {
                listComment = response.body();
                commentAdapter.addAll(listComment);

            }

            @Override
            public void onFailure(Call<List<CommentModel>> call, Throwable t) {
                Toast.makeText(NewsDetail.this, "failed", Toast.LENGTH_SHORT).show();

            }
        });

//
        //commentAdapter.addAll(listComment);
//
        lsvCmt.setAdapter(commentAdapter);
//
//
//
        txtNoiDung = findViewById(R.id.txtNoiDung);
        txtNoiDung.setText(newsFeedModel.getPostContent().toString());
        txtTitle.setText(newsFeedModel.getTitle().toString());
        txtNgayTao.setText(newsFeedModel.getCreatedAt().toString());
    }

    public void btnComment(View view) {
        CommentModel comment = new CommentModel(Login.Student.getId(),newsFeedModel.getId(),txtCmt.getText().toString());

        Call<CommentModel> call = RetrofitClient.getInstance().getMyApi().PostCmt(comment);
        call.enqueue(new Callback<CommentModel>() {
                         @Override
                         public void onResponse(Call<CommentModel> call, Response<CommentModel> response) {
//                            commentAdapter.add(response.body());
//                             commentAdapter.notifyDataSetChanged();

                             finish();
                             startActivity(getIntent()); 
                         }

                         @Override
                         public void onFailure(Call<CommentModel> call, Throwable t) {
                             Toast.makeText(NewsDetail.this, "Failed", Toast.LENGTH_SHORT).show();
                         }
                     });

                txtCmt.setText("");
    }
}