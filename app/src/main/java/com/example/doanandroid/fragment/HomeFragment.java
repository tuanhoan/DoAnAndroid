package com.example.doanandroid.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.doanandroid.Adapters.StudentAdapter;
import com.example.doanandroid.MainActivity;
import com.example.doanandroid.NewsDetail;
import com.example.doanandroid.R;
import com.example.lib.Models.NewsFeedModel;
import com.example.lib.Models.StudentModel;
import com.example.lib.Retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {


    View mview;

    ArrayAdapter<StudentModel> studentModelArrayAdapter;
    ListView lsvStudent;
    List<NewsFeedModel> newsFeedModelList = new ArrayList<NewsFeedModel>();
    MainActivity mainActivity;
    StudentAdapter studentAdapter = null;
    public HomeFragment() {
        // Required empty public constructor

    }
//    Button btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mainActivity = (MainActivity) getActivity();
        // Inflate the layout for this fragment
        mview= inflater.inflate(R.layout.fragment_home, container, false);


        lsvStudent = mview.findViewById(R.id.lsvStudent);


         //btn=mview.findViewById(R.id.id);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                btn.setText("dsđa");
//            }
//        });

        String pathImage = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pinterest.com%2Fpin%2F844495367623777895%2F&psig=AOvVaw0gNckvUgBO7Qms84ZChmYl&ust=1632640341966000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCLDgk7DJmfMCFQAAAAAdAAAAABAD";

        studentAdapter = new StudentAdapter(mainActivity, R.layout.spitem);

        Call<List<NewsFeedModel>> call =  RetrofitClient.getInstance().getMyApi().getAllNewFeed();
        StudentAdapter finalStudentAdapter = studentAdapter;
        call.enqueue(new Callback<List<NewsFeedModel>>() {
            @Override
            public void onResponse(Call<List<NewsFeedModel>> call, Response<List<NewsFeedModel>> response) {
                newsFeedModelList = response.body();
                finalStudentAdapter.addAll(newsFeedModelList);


                //Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<NewsFeedModel>> call, Throwable t) {
                //Toast.makeText(.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });


        studentAdapter.addAll(newsFeedModelList);
//        for(int i =0; i<newsFeedModelList.size(); i++){
//            studentAdapter.add(newsFeedModelList.get(i));
//        }
        //studentAdapter.add(new SinhVienModel("1811060032", "Nguyễn Quốc Huy", "0948502258",ConvertDateFromString("2021/08/08") ,ConvertDateFromString("2022/08/08"),"23","Đơn vị",pathImage,R.drawable.h1));
        lsvStudent.setAdapter(finalStudentAdapter);
        lsvStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(mainActivity, "vi tri "+i, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mainActivity, NewsDetail.class);
                intent.putExtra("newfeed",newsFeedModelList.get(i));

                startActivity(intent);
            }
        });

        return mview;


    }

    @Override
    public void onStart() {
        super.onStart();


    }
}