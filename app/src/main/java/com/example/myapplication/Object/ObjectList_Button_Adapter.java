package com.example.myapplication.Object;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class ObjectList_Button_Adapter extends RecyclerView.Adapter<ObjectList_Button_Adapter.ViewHolder> {

    private ArrayList<ListButtonData> mData = new ArrayList<>();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.object_cardview, parent, false);

        return new ViewHolder(v);
    }

    // 생성자에서 데이터 리스트 객체를 전달받음.
    public ObjectList_Button_Adapter(ArrayList<ListButtonData> list) {
        mData = list ;
    }

        public ObjectList_Button_Adapter(ArrayList<ListButtonData> data, Activity activity){
        mData=data;
    }


    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.onBind(mData.get(position));
        }


    // getItemCount() - 전체 데이터 갯수 리턴.
    @Override
    public int getItemCount() {
        return mData.size() ;
    }

    public void addItem(ListButtonData data){
        data.add();
    }


    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView listImage;
        private TextView listName;
        public ViewHolder(View view) {
            super(view);
            listImage = (ImageView) view.findViewById(R.id.listImage);
            listName = (TextView) view.findViewById(R.id.listName);
        }
        void onBind(ListButtonData data) {
            listImage.setImageResource(data.getlistImage());
            listName.setText(data.getlistName());
        }
    }

}