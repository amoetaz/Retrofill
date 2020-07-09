package com.amoetaz.retrofilljavaexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.amoetaz.retrofill.Action;
import com.amoetaz.retrofill.LayoutType;
import com.amoetaz.retrofill.Retrofill;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.rv_list);

        new Retrofill(this).setupNormalList(recyclerView, R.layout.list_item, new Action() {
            @Override
            public void execute() {
                startActivity(new Intent(MainActivity.this, NestedListActivity.class));
            }
        })
            .setLayoutType(LayoutType.LINEAR)
            .setVertical(true)
            .setListSize(5)
            .setSpanCount(2)
            .showNormalRecylerView();



    }
}
