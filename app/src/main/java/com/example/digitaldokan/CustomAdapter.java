package com.example.digitaldokan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.api.Context;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<ViewHolder> {
    ListActivity listActivity;
    List<Model> modelList;


    public CustomAdapter(ListActivity listActivity, List<Model> modelList) {
        this.listActivity = listActivity;
        this.modelList = modelList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_layout, parent, false);

        ViewHolder viewHolder = new ViewHolder(itemView);

        viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.shpName.setText(modelList.get(position).getShopname());
        holder.cusName.setText(modelList.get(position).getCusname());
        holder.phnNum.setText(modelList.get(position).getPhnnum());
        holder.date.setText(modelList.get(position).getDatetime());
        holder.itemName.setText(modelList.get(position).getItemname());
        holder.serialNum.setText(modelList.get(position).getSerialnum());
        holder.warranty.setText(modelList.get(position).getWarranty());
        holder.price.setText(modelList.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }
}
