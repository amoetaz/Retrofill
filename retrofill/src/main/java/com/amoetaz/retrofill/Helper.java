package com.amoetaz.retrofill;

import android.content.Context;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class Helper {
    public static ArrayList<Object> getArrayList(int listSize) {
        Object object = new Object();
        ArrayList<Object> list = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            list.add(object);
        }
        return list;
    }

    public static RecyclerView.LayoutManager getLayoutType(Context context, LayoutType type, boolean isVertical , int spanCount){
        RecyclerView.LayoutManager layoutManager;
        if (type == LayoutType.LINEAR)
            if (isVertical)
                layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
            else
                layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        else if (type == LayoutType.GRID)
            if (isVertical)
                layoutManager = new GridLayoutManager(context,spanCount ,GridLayoutManager.VERTICAL , false);
            else
                layoutManager = new GridLayoutManager(context,spanCount ,GridLayoutManager.HORIZONTAL , false);
        else
        if (isVertical)
            layoutManager = new StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.VERTICAL);
        else
            layoutManager = new StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.HORIZONTAL);

        return layoutManager;
    }
}
