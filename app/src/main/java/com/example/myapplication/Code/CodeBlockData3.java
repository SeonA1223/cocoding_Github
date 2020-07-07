package com.example.myapplication.Code;

import com.example.myapplication.R;
import com.example.myapplication.Recyclerview.RecyclerviewItem;

import java.util.ArrayList;

public class CodeBlockData3 {
    ArrayList<RecyclerviewItem> CodeBlocks3 = new ArrayList<>();

    public ArrayList<RecyclerviewItem> getCodeBlocks3(){

        RecyclerviewItem shape1 = new RecyclerviewItem(R.drawable.shape1);
        RecyclerviewItem shape2 = new RecyclerviewItem(R.drawable.shape2);
        RecyclerviewItem shape3 = new RecyclerviewItem(R.drawable.shape3);

        CodeBlocks3.add(shape3);
        CodeBlocks3.add(shape2);
        CodeBlocks3.add(shape1);

        CodeBlocks3.add(shape3);
        CodeBlocks3.add(shape2);


        return CodeBlocks3;
    }
}
