package com.example.myapplication.Flow;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class FlowItemAdapter extends RecyclerView.Adapter<FlowItemAdapter.ViewHolder> {
    private Context context;
    private ArrayList<FlowItem> flowItemArrayList;

    public OnItemClickListener mOnItemClickListener = null;

    public interface OnItemClickListener {
        void onItemClick(View view, FlowItem flowItem);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    public FlowItemAdapter(Context context, ArrayList<FlowItem> flowItemArrayList) {
        this.context = context;
        this.flowItemArrayList = flowItemArrayList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.flow_image);
        }
    }

    @NonNull
    @Override
    public FlowItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.flow_item, viewGroup, false);
        return new FlowItemAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FlowItemAdapter.ViewHolder viewHolder, int i) {
        FlowItem flowItem = flowItemArrayList.get(i);
        viewHolder.imageView.setImageResource(flowItem.getImage());

    }

    @Override
    public int getItemCount() {
        return flowItemArrayList.size();
    }


}
