package com.wsl.library.timeline.demo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.wsl.library.image.TimeLineView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        List<Bean> beans = new ArrayList<>(10);
        String text;
        boolean done,last;
        for(int i=0; i<10; i++) {
            done = (i % 2 == 0);
            last = (i == 9);
            text = "this is index : " + i;
            beans.add(new Bean(text, done, last));
        }
        View header = getLayoutInflater().inflate(R.layout.item_header, null);
        TimeLineListAdapter adapter = new TimeLineListAdapter(this);
        adapter.addAll(beans);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.addHeaderView(header);
        listView.setAdapter(adapter);
    }
}