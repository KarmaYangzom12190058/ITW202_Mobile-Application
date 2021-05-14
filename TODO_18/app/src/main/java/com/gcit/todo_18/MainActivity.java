package com.gcit.todo_18;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<sports> mSportsData;
    private sportsAdapter mAdpater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mSportsData = new ArrayList<>();

        mAdpater = new sportsAdapter(this, mSportsData);
        mRecyclerView.setAdapter(mAdpater);

        initializeData();
    }

    private void initializeData(){
        TypedArray sportsImageResources = getResources().obtainTypedArray(R.array.sports_images);
        String[] sportsList = getResources().getStringArray(R.array.sports_title);
        String[] sportsInfo = getResources().getStringArray(R.array.sports_info);

        mSportsData.clear();

        for (int i = 0; i < sportsList.length; i++){
            mSportsData.add(new sports(sportsList[i], sportsInfo[i], sportsImageResources.getResourceId(i, 1)));
        }

        mAdpater.notifyDataSetChanged();
        sportsImageResources.recycle();
    }
}