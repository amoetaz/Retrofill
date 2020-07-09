package com.amoetaz.retrofilljavaexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.amoetaz.retrofill.Action;
import com.amoetaz.retrofill.LayoutType;
import com.amoetaz.retrofill.Retrofill;

public class NestedListActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nested_list);
        recyclerView = findViewById(R.id.rv_outer_list);
        new Retrofill(this)
                .setupNestedList(recyclerView, R.layout.outer_list_item, R.id.rv_inner_list, R.layout.inner_list_item, new Action() {
                    @Override
                    public void execute() {
                        Toast.makeText(NestedListActivity.this, "Fantastic", Toast.LENGTH_SHORT).show();
                    }
                })
                .setOuterIsVertical(true)
                .setOuterLayoutType(LayoutType.LINEAR)
                .setOuterListSize(6)
                .setOuterSpanCount(2)
                .setInnerLayoutType(LayoutType.LINEAR)
                .setInnerListSize(5)
                .setInnerSpanCount(2)
                .setInnerVertical(true)
                .showNestedRecylerView();
    }
}
