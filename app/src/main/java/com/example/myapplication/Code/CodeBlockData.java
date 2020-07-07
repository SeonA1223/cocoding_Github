package com.example.myapplication.Code;

import com.example.myapplication.Recyclerview.RecyclerviewItem;
import com.example.myapplication.R;

import java.util.ArrayList;
//블럭 유형 별로 들어갈 이미지 데이터들
public class CodeBlockData {

    ArrayList<RecyclerviewItem> CodeBlocks = new ArrayList<>();

    RecyclerviewItem shape1 = new RecyclerviewItem(R.drawable.shape1);
    RecyclerviewItem shape2 = new RecyclerviewItem(R.drawable.shape2);
    RecyclerviewItem shape3 = new RecyclerviewItem(R.drawable.shape3);

    public ArrayList<RecyclerviewItem> getCodeBlocks(){
        return CodeBlocks;
    }

}
