package com.amoetaz.retrofill;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

import static com.amoetaz.retrofill.Helper.getArrayList;
import static com.amoetaz.retrofill.Helper.getLayoutType;

public class Retrofill {

    //this variable associated with normal list -not nested-
    private Context context;
    private RecyclerView recyclerView;
    private int listItem;
    private LayoutType type = LayoutType.LINEAR; // layout manager type
    private int listSize = 5;
    private int spanCount = 2;
    private boolean isVertical = true;
    private Action normalListClick;

    //this variable associated with nested list
    //outer list
    private RecyclerView outerRecylerview;
    private int outerListItem;
    private LayoutType outerListType = LayoutType.LINEAR; // layout manager type
    private int outerListSize = 6;
    private int outerListSpanCount = 2;
    private boolean outerListIsVertical = true;
    //inner list
    private int innerRecylerviewId;
    private int innerListItem;
    private LayoutType innerListType = LayoutType.LINEAR; // layout manager type
    private int innerListSize = 5;
    private int innerListSpanCount = 2;
    private boolean innerListIsVertical = true;

    private Action nestedListClick;

    public Retrofill(Context context) {
        this.context = context;
    }

    public Retrofill setupNormalList(RecyclerView recyclerView, int listItem, Action normalListClick) {
        this.recyclerView = recyclerView;
        this.listItem = listItem;
        this.normalListClick = normalListClick;
        return this;
    }

    public void showNormalRecylerView() {
        FakeAdapter adapter = new FakeAdapter(getArrayList(listSize), listItem, normalListClick);

        recyclerView.setLayoutManager(getLayoutType(context , type,isVertical , spanCount));
        recyclerView.setAdapter(adapter);
    }

    public Retrofill setListSize(int listSize) {
        this.listSize = listSize;
        return this;
    }

    public Retrofill setSpanCount(int spanCount) {
        this.spanCount = spanCount;
        return this;
    }

    public Retrofill setLayoutType(LayoutType type) {
        this.type = type;
        return this;
    }

    public Retrofill setVertical(boolean isVertical) {
        this.isVertical = isVertical;
        return this;
    }

    //nested list
    public Retrofill setupNestedList(RecyclerView outerRecyclerView, int outerlistItem,
                                     int innerRecyclerViewId, int innerListItem,@Nullable Action normalListClick) {
        this.outerRecylerview = outerRecyclerView;
        this.outerListItem = outerlistItem;
        this.innerRecylerviewId = innerRecyclerViewId;
        this.innerListItem = innerListItem;
        this.nestedListClick = normalListClick;
        return this;

    }

    public void showNestedRecylerView() {
        FakeNestedAdapter adapter = new FakeNestedAdapter(context, getArrayList(outerListSize),
                outerListItem, innerRecylerviewId
                , innerListItem, innerListSize,innerListType , innerListSpanCount , innerListIsVertical, nestedListClick);

        outerRecylerview.setLayoutManager(getLayoutType(context , outerListType,outerListIsVertical , outerListSpanCount));
        outerRecylerview.setAdapter(adapter);
    }


    public Retrofill setOuterListSize(int outerListSize) {
        this.outerListSize = outerListSize;
        return this;
    }

    public Retrofill setOuterSpanCount(int outerListSpanCount) {
        this.outerListSpanCount = outerListSpanCount;
        return this;
    }

    public Retrofill setOuterLayoutType(LayoutType outerLayoutType) {
        this.outerListType = outerLayoutType;
        return this;
    }

    public Retrofill setOuterIsVertical(boolean outerListIsVertical) {
        this.outerListIsVertical = outerListIsVertical;
        return this;
    }

    public Retrofill setInnerListSize(int innerListSize) {
        this.innerListSize = innerListSize;
        return this;
    }

    public Retrofill setInnerSpanCount(int innerSpanCount) {
        this.innerListSpanCount = innerSpanCount;
        return this;
    }

    public Retrofill setInnerLayoutType(LayoutType innerLayoutType) {
        this.innerListType = innerLayoutType;
        return this;
    }

    public Retrofill setInnerVertical(boolean innerListIsVertical) {
        this.innerListIsVertical = innerListIsVertical;
        return this;
    }

}
