package com.gcit.todo_16;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Adapter adapter;
    private final LinkedList<String> wordList = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i=0; i<20; i++){
            wordList.addLast("Word" + i);
        }

        recyclerView = findViewById(R.id.recyclerView);
        wordlistAdapter adapter = new wordlistAdapter(this, wordList);

        recyclerView.setAdapter(adapter);
        LinearLayoutManager obj = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(obj);

        FloatingActionButton fab = findViewById(R.id.floatBot);
        fab.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int wordListSize = wordList.size();

                //Adds a new word to the wordlist
                wordList.addLast("+ Word " + wordListSize);

                //Notifies the apdater, that the data is changed
                recyclerView.getAdapter().notifyItemInserted(wordListSize);

                //Scroll to the bottom
                recyclerView.smoothScrollToPosition(wordListSize);
            }
        });
    }
}