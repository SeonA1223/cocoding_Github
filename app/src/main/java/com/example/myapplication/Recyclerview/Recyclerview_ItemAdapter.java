package com.example.myapplication.Recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class Recyclerview_ItemAdapter extends RecyclerView.Adapter<Recyclerview_ItemAdapter.ViewHolder> {
    private Context context;
    private ArrayList<RecyclerviewItem> ArrayList;

    public OnItemClickListener mOnItemClickListener = null;

    public interface OnItemClickListener {
        void onItemClick(View view, RecyclerviewItem flowItem);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    public Recyclerview_ItemAdapter(Context context, ArrayList<RecyclerviewItem> flowItemArrayList) {
        this.context = context;
        this.ArrayList = flowItemArrayList;
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
    public Recyclerview_ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.flow_item, viewGroup, false);
        return new Recyclerview_ItemAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Recyclerview_ItemAdapter.ViewHolder viewHolder, int i) {
        RecyclerviewItem flowItem = ArrayList.get(i);
        viewHolder.imageView.setImageResource(flowItem.getImage());

        /*서버 or internet에서 값 가져올 경우
        Glide.with(ViewHolder.view.getContext()).load(item.getUrl()).into(viewHolder.(URL id);
        * */

    }

    @Override
    public int getItemCount() {
        return ArrayList.size();
    }

    public void setItems(ArrayList<RecyclerviewItem> ArrayList){
        this.ArrayList = ArrayList;
    }


}
