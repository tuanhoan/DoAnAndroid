package com.example.doanandroid.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.doanandroid.R;
import com.example.lib.Models.CommentModel;
import com.squareup.picasso.Picasso;

public class CommentAdapter extends ArrayAdapter<CommentModel> {
    Activity activity;
    int resource;
    ImageView imgIcon;
    public CommentAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.activity = (Activity) context;
        this.resource = resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.activity.getLayoutInflater();
        View commentView = layoutInflater.inflate(this.resource, null);
        imgIcon = commentView.findViewById(R.id.imgIcon);
        TextView txtHoTen = commentView.findViewById(R.id.txtHoTen);
        TextView txtNoiDungCmt = commentView.findViewById(R.id.txtNoiDungCmt);
        ImageView imgAvatar = commentView.findViewById(R.id.imgAvatar);
        CommentModel comment = getItem(position);
        //img.setImageURI(student.getImagePath());
        txtHoTen.setText(comment.getStudentNavigation().getName().toString());
        txtNoiDungCmt.setText(comment.getCommentContent());
        Picasso.get().load(comment.getStudentNavigation().getImg()).into(imgIcon);
//        imgAvatar.setImageURI();

        return commentView;
    }
}