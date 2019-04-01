package com.eastwinddc.sample.md.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eastwinddc.sample.R;

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
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    size++;
                    notifyItemInserted(0);
                }
            });
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
//        holder.textView.setText(dataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return size;
    }
}
