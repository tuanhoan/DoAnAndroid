package com.example.doanandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.doanandroid.fragment.ViewAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    BottomNavigationView bottomNavigationView;
    View mview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            anhxa();

            ViewAdapter viewAdapter =new ViewAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
            viewPager.setAdapter(viewAdapter);
            viewPager.setOffscreenPageLimit(2);
            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    switch (position){
                        case 0:
//                        EditText name = findViewById(R.id.edtname);
//                        EditText birth = findViewById(R.id.edtbirth);
//                        EditText phone = findViewById(R.id.edtphone);
//                        EditText gmail = findViewById(R.id.edtgmail);
//                        EditText address = findViewById(R.id.edtadress);
//                        ImageView img = findViewById(R.id.canhanbacsi);
//                        Bundle bundle = getIntent().getExtras();
//                        if(bundle !=null){
//                            userbacsi= (BacSiModel.listbacsi) bundle.get("userbacsi");
//                            if(userbacsi != null){
//                                name.setText(userbacsi.getFullname());
//                                birth.setText(userbacsi.getBirth());
//                                phone.setText(userbacsi.getPhone());
//                                gmail.setText(userbacsi.getEmail());
//                                address.setText(userbacsi.getAdress());
//                                Picasso.get().load(userbacsi.getPhoto()).into(img);
//                            }
//                        }
//
//                        Button btncapnhat=findViewById(R.id.capnhat);
//                        btncapnhat.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//
//                                BacSiModel.listbacsi user = new BacSiModel.listbacsi(userbacsi.getGender(),userbacsi.getPhoto(),userbacsi.getDescription(),birth.getText().toString(),address.getText().toString(),userbacsi.getIdChuyenkhoa(),userbacsi.getPassword(),phone.getText().toString(),name.getText().toString(),gmail.getText().toString(),userbacsi.getStatus(),userbacsi.getUsername());
//                                //soService=  RetrofitClient.getClient(BASE_URL).create(Methods.class);
//                                soService.putbacsi(userbacsi.getIdBacsi()+"",user).enqueue(new Callback<BacSiModel.listbacsi>() {
//                                    @Override
//                                    public void onResponse(Call<BacSiModel.listbacsi> call, Response<BacSiModel.listbacsi> response) {
//                                        Toast.makeText(MainBacSiActivity.this, "Cập Nhật Thành Công!!!", Toast.LENGTH_SHORT).show();
//                                    }
//
//                                    @Override
//                                    public void onFailure(Call<BacSiModel.listbacsi> call, Throwable t) {
//                                        Toast.makeText(MainBacSiActivity.this, "Thất bại!", Toast.LENGTH_SHORT).show();
//                                    }
//                                });
//
//                            }
//                        });
                            bottomNavigationView.getMenu().findItem(R.id.home).setChecked(true);
                            break;
                        case 1:
                            bottomNavigationView.getMenu().findItem(R.id.list).setChecked(true);
                            break;
                        case 2:
                            bottomNavigationView.getMenu().findItem(R.id.canhan).setChecked(true);

                            break;
                    }
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){
                        case R.id.home:
//                        TextView textView = findViewById(R.id.namebacsi);
//                        Bundle bundleReceive = getIntent().getExtras();
//                        if(bundleReceive !=null){
//                            BacSiModel.listbacsi userbacsi= (BacSiModel.listbacsi) bundleReceive.get("userbacsi");
//                            if(userbacsi != null){
//                                textView.setText(userbacsi.getFullname());
//                            }
//                        }
                            viewPager.setCurrentItem(0);

                            break;
                        case R.id.list:
                            viewPager.setCurrentItem(1);
                            break;
                        case R.id.canhan:

                            viewPager.setCurrentItem(2);

                            break;
                    }
                    return true;
                }
            });

//        Bundle bundle = getIntent().getExtras();
//                        if(bundle !=null){
//                            userbacsi= (BacSiModel.listbacsi) bundle.get("userbacsi");
//                            if(userbacsi != null){
//                                InformationFragment caNhanBacSiFragment =new InformationFragment();
//                                Bundle bun=new Bundle();
//                                bun.putSerializable("bacsi",userbacsi);
//                                caNhanBacSiFragment.setArguments(bundle);
//                            }
//                        }

        }

        @Override
        protected void onRestart() {
            super.onRestart();


        }

        private void anhxa() {
            viewPager =findViewById(R.id.view_pager);
            bottomNavigationView=findViewById(R.id.bottom_navi);
        }

    }
