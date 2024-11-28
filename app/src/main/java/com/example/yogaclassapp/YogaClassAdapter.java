package com.example.yogaclassapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class YogaClassAdapter extends RecyclerView.Adapter<YogaClassAdapter.YogaClassViewHolder> {
    private ArrayList<YogaClass> yogaClassList;

    public YogaClassAdapter(ArrayList<YogaClass> yogaClassList) {
        this.yogaClassList = yogaClassList;
    }

    @NonNull
    @Override
    public YogaClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_yoga_class, parent, false);
        return new YogaClassViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull YogaClassViewHolder holder, int position) {
        YogaClass yogaClass = yogaClassList.get(position);
        holder.dayTextView.setText(yogaClass.getDay());
        holder.timeTextView.setText(yogaClass.getTime());
        holder.capacityTextView.setText(String.valueOf(yogaClass.getCapacity()));
        holder.durationTextView.setText(String.valueOf(yogaClass.getDuration()));
        holder.priceTextView.setText(String.valueOf(yogaClass.getPrice()));
        holder.typeTextView.setText(yogaClass.getType());
        holder.descriptionTextView.setText(yogaClass.getDescription());
    }

    @Override
    public int getItemCount() {
        return yogaClassList.size();
    }

    public static class YogaClassViewHolder extends RecyclerView.ViewHolder {
        TextView dayTextView;
        TextView timeTextView;
        TextView capacityTextView;
        TextView durationTextView;
        TextView priceTextView;
        TextView typeTextView;
        TextView descriptionTextView;

        public YogaClassViewHolder(@NonNull View itemView) {
            super(itemView);
            dayTextView = itemView.findViewById(R.id.dayTextView);
            timeTextView = itemView.findViewById(R.id.timeTextView);
            capacityTextView = itemView.findViewById(R.id.capacityTextView);
            durationTextView = itemView.findViewById(R.id.durationTextView);
            priceTextView = itemView.findViewById(R.id.priceTextView);
            typeTextView = itemView.findViewById(R.id.typeTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
        }
    }
}