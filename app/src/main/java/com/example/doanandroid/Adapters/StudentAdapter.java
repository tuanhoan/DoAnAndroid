package com.example.doanandroid.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lib.Models.NewsFeedModel;
import com.example.doanandroid.R;

public class StudentAdapter extends ArrayAdapter<NewsFeedModel> {
    Activity activity;
    int resource;
    TextView txtTitle;
    TextView txtContent;
    TextView txtCreatedAt;
    public StudentAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.activity = (Activity) context;
        this.resource = resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.activity.getLayoutInflater();
        View spView = layoutInflater.inflate(this.resource, null);
        //ImageView img = spView.findViewById(R.id.imgSp);
         txtTitle = spView.findViewById(R.id.txtTitle);
         txtContent = spView.findViewById(R.id.txtContent);

        NewsFeedModel newfeeds = getItem(position);
        //img.setImageURI(student.getImagePath());
        txtTitle.setText(newfeeds.getTitle().toString());
//        txtMSSV.setText(student.ge());
        txtContent.setText(newfeeds.getPostContent().toString());

        return spView;
    }
}