package com.example.digitaldokan;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView shpName, cusName, phnNum, date, itemName, serialNum, warranty, price;
    View mView;


    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        mView = itemView;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mClickListener.onItemClick(view, getBindingAdapterPosition());
            }
        });

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mClickListener.onItemLongClick(view, getBindingAdapterPosition());
                return true;
            }
        });

        shpName = itemView.findViewById(R.id.shpName);
        cusName = itemView.findViewById(R.id.cusName);
        phnNum = itemView.findViewById(R.id.phnNum);
        date = itemView.findViewById(R.id.date);
        serialNum = itemView.findViewById(R.id.serialNum);
        warranty = itemView.findViewById(R.id.warranty);
        itemName = itemView.findViewById(R.id.itemName);
        price = itemView.findViewById(R.id.price);

    }

    private ViewHolder.ClickListener mClickListener;
    public interface ClickListener{
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }
    public void setOnClickListener(ViewHolder.ClickListener clickListener)
    {
        mClickListener = clickListener;
    }
}
