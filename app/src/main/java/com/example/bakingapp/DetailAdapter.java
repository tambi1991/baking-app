package com.example.bakingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bakingapp.adapter.RecipeAdapter;
import com.example.bakingapp.model.Step;

import java.util.ArrayList;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.DetailViewHolder> {
    // source
    ArrayList<Step> mStep;
    // context
    Context conext;

    public DetailAdapter(Context context, ArrayList<Step> mStep) {
        this.conext = context;
        this.mStep = mStep;
    }
    @NonNull
    @Override
    public DetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.detail_item_view;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;
        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);
        DetailAdapter.DetailViewHolder viewHolder = new DetailAdapter.DetailViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DetailViewHolder holder, int position) {
   Step type = mStep.get(position);
   holder.description.setText(type.getShortDescription());
    }

    @Override
    public int getItemCount() {
        if(mStep==null) return 0;
        return mStep.size();
    }

    class DetailViewHolder extends RecyclerView.ViewHolder {
        TextView description;
        public DetailViewHolder(@NonNull View itemView) {
            super(itemView);
            description = (TextView) itemView.findViewById(R.id.description);
        }
    }
}
