package com.example.admin.empoderades.view;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import com.example.admin.empoderades.R;
import com.example.admin.empoderades.adapters.NewsListAdapter;
import com.example.admin.empoderades.model.News;
import com.example.admin.empoderades.presenter.retrofit.NewsDAO;
import com.example.admin.empoderades.presenter.retrofit.ResultListener;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.mainFragmentContainer, new NewsFragment(), "tag");
        fragmentTransaction.commit();

    }

}
