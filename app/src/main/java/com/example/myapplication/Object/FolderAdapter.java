package com.example.myapplication.Object;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;


public class FolderAdapter extends RecyclerView.Adapter<FolderAdapter.ViewHolder> {

    private ArrayList<FolderData> folderData = new ArrayList<>();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.object_folder_set, parent, false);

        return new ViewHolder(v);
    }

    // 생성자에서 데이터 리스트 객체를 전달받음.
    public FolderAdapter(){

    }
    public FolderAdapter(FolderData input) {
//        listButtonData.add(input);

    }

    public void addData(FolderData input){
        folderData.add(input);
    }


    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.onBind(folderData.get(position));
        }


    // getItemCount() - 전체 데이터 갯수 리턴.
    @Override
    public int getItemCount() {
        return folderData.size() ;
    }



    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView listImage;
        private TextView listName;

        public ViewHolder(View view) {
            super(view);
            listImage = (ImageView) view.findViewById(R.id.listImage);
            listName = (TextView) view.findViewById(R.id.listName);


            listImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition() ;
                    if (pos != RecyclerView.NO_POSITION) {
                        // TODO : use pos.
                        Context context = v.getContext();
                        Intent intent = new Intent(v.getContext(),Object_List.class);
                        context.startActivity(intent);
                    }
                }
            });
        }
        void onBind(FolderData data) {
            listImage.setImageResource(data.getlistImage());
            listName.setText(data.getlistName());
        }
    }

}