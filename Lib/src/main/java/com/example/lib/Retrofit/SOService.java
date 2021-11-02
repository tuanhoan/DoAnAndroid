package com.example.lib.Retrofit;

import com.example.lib.Models.CommentModel;
import com.example.lib.Models.NewsFeedModel;
import com.example.lib.Models.ScoreModel;
import com.example.lib.Models.StudentModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SOService {

    @GET("api/Students/login")
    Call<StudentModel> Login(@Query("username") String userName, @Query("password") String Password);

    @GET("/api/NewFeeds")
    Call<List<NewsFeedModel>> getAllNewFeed(@Query("searchKey") String searchKey);

    @GET("api/Comments/{id}")
    Call<List<CommentModel>> GetCommentByPostId(@Path("id") Integer  Id);

    @POST("api/Comments")
    Call<CommentModel> PostCmt(@Body CommentModel comment);

    @PUT("/api/Students/{id}")
    Call<StudentModel> PutStudent(@Path("id") Integer Id,@Body StudentModel studentModel);

    @GET("api/Scores/{id}")
    Call<List<ScoreModel>> GetScoreByStudentId(@Path("id") Integer Id);

    @PUT("api/Students/changePassword")
    Call<StudentModel> ChangePasswWord(@Query("id") Integer id, @Query("newPass") String newPassword);
}
