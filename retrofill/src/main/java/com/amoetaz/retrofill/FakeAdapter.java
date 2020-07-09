package com.amoetaz.retrofill;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


class FakeAdapter extends RecyclerView.Adapter<FakeAdapter.MyViewHolder> {

    ArrayList<Object> list = new ArrayList<>();
    int listItem;
    Action command;

    public FakeAdapter(ArrayList<Object> list, int listItem, Action normalListClick) {
        this.list = list;
        this.listItem = listItem;
        this.command = normalListClick;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(listItem, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        addListernerToClick(holder.itemView);
    }

    private void addListernerToClick(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View innerChild = viewGroup.getChildAt(i);
                addListernerToClick(innerChild);
            }
        } else {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (command != null) {
                        command.execute();
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
