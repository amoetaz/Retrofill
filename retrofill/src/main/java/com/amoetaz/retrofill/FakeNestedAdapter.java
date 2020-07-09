package com.amoetaz.retrofill;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


class FakeNestedAdapter extends RecyclerView.Adapter<FakeNestedAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Object> list = new ArrayList<>();
    private int innerRecylerviewId;
    private int outerListItem;
    private int innerListItem;
    private int innerListSize;
    private LayoutType innerType;
    private int innerSpanCount;
    private boolean innerIsVertical;
    private Action command;

    public FakeNestedAdapter(Context context, ArrayList<Object> list, int outerListItem
            , int innerRecylerviewId, int innerListItem, int innerListSize,LayoutType innerType,int innerSpanCount
            ,boolean innerIsVertical, Action nestedListClick) {
        this.context = context;
        this.list = list;
        this.innerRecylerviewId = innerRecylerviewId;
        this.outerListItem = outerListItem;
        this.innerListItem = innerListItem;
        this.innerListSize = innerListSize;
        this.innerType = innerType;
        this.innerSpanCount = innerSpanCount;
        this.innerIsVertical = innerIsVertical;
        this.command = nestedListClick;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(outerListItem, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        new Retrofill(context).setupNormalList(holder.innerRecylerView, innerListItem , command)
                .setSpanCount(innerSpanCount)
                .setListSize(innerListSize)
                .setLayoutType(innerType)
                .setVertical(innerIsVertical)
                .showNormalRecylerView();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        RecyclerView innerRecylerView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            innerRecylerView = itemView.findViewById(innerRecylerviewId);
        }
    }
}
