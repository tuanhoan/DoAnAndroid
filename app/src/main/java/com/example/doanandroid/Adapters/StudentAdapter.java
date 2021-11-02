package com.example.doanandroid.Adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.InspectableProperty;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lib.Models.NewsFeedModel;
import com.example.doanandroid.R;
import com.squareup.picasso.Picasso;

import java.net.URL;

public class StudentAdapter extends ArrayAdapter<NewsFeedModel> {
    Activity activity;
    int resource;
    TextView txtTitle;
    TextView txtContent;
    ImageView img;
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
         img = spView.findViewById(R.id.imgSp);

         txtTitle = spView.findViewById(R.id.txtTitle);
         txtTitle.setTypeface(null, Typeface.BOLD);
         txtTitle.setTextSize(20);
         txtContent = spView.findViewById(R.id.txtContent);


        NewsFeedModel newfeeds = getItem(position);

        Picasso.get().load(newfeeds.getImg()).into(img);
        //img.setImageURI(student.getImagePath());

        String title = newfeeds.getTitle().toString();
        try{
            title =  title.substring(0,20).toString() + "...";
        }
        catch (Exception ex){

        }
        txtTitle.setText(title);
//        txtMSSV.setText(student.ge());
        String content = newfeeds.getPostContent().toString();
        try{
           content =  content.substring(0,100).toString() + "...";
        }
        catch (Exception ex){

        }
        txtContent.setText(content);


        return spView;
    }
}