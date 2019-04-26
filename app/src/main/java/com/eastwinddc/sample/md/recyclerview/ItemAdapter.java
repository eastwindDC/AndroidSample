package com.eastwinddc.sample.md.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eastwinddc.sample.R;

import java.util.List;

/**
 * Created by eastwinddc on 2017/7/19.
 */

class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>{
    private static final String TAG = "ItemAdapter";
    private int size;
    class ViewHolder extends RecyclerView.ViewHolder{
        private View cardView;
        private TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            cardView = itemView;
            textView = (TextView) cardView.findViewById(R.id.textView);
        }
    }
    public void setData(int size){
        this.size = size;
    }
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: "+viewType);
        View root =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_search_list,parent,false);

        ViewHolder vh = new ViewHolder(root);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: "+position);
        holder.textView.setText(String.valueOf(position));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull List<Object> payloads) {
        if(payloads == null|| payloads.isEmpty()){
            onBindViewHolder(holder,position);
            return;
        }

        Log.d(TAG, "onBindViewHolder payload: "+payloads.size());
    }

    public int getInsertPosition(){
        return 0;
    }
    public void localAdd(){
        size++;
        notifyItemInserted(1);
    }
    public void localRemove(){
        size--;
        notifyItemRemoved(3);
    }
    @Override
    public int getItemCount() {
        return size;
    }
}
