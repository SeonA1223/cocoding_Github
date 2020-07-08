package com.example.myapplication.Object;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class ObjectAdapter extends RecyclerView.Adapter<ObjectAdapter.ViewHolder>  {

    private ArrayList<ObjectData> objectData = new ArrayList<>();

    @Override
    public ObjectAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.object_list_set, parent, false);

        return new ObjectAdapter.ViewHolder(v);
    }

    // 생성자에서 데이터 리스트 객체를 전달받음.
    public ObjectAdapter(){

    }
    public ObjectAdapter(ObjectData input) {
//        listButtonData.add(input);

    }

    public void addData(ObjectData input){
        objectData.add(input);
    }


    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(ObjectAdapter.ViewHolder holder, int position) {
        holder.onBind(objectData.get(position));
    }


    // getItemCount() - 전체 데이터 갯수 리턴.
    @Override
    public int getItemCount() {
        return objectData.size() ;
    }



    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView objectImage;
        private TextView objectName;
        public ViewHolder(View view) {
            super(view);
            objectImage = (ImageView) view.findViewById(R.id.objectImage);
            objectName = (TextView) view.findViewById(R.id.objectName);
        }
        void onBind(ObjectData data) {
            objectImage.setImageResource(data.getobjectImage());
            objectName.setText(data.getobjectName());
        }
    }
}