package com.example.myapplication.Code;

import com.example.myapplication.R;
import com.example.myapplication.Recyclerview.RecyclerviewItem;

import java.util.ArrayList;

public class CodeBlockData1 {
    ArrayList<RecyclerviewItem> CodeBlocks1 = new ArrayList<>();

    public ArrayList<RecyclerviewItem> getCodeBlocks1(){

        RecyclerviewItem shape1 = new RecyclerviewItem(R.drawable.shape1);
        RecyclerviewItem shape2 = new RecyclerviewItem(R.drawable.shape2);
        RecyclerviewItem shape3 = new RecyclerviewItem(R.drawable.shape3);

        CodeBlocks1.add(shape3);
        CodeBlocks1.add(shape2);
        CodeBlocks1.add(shape1);

        CodeBlocks1.add(shape2);
        CodeBlocks1.add(shape1);
        CodeBlocks1.add(shape1);


        return CodeBlocks1;
    }
}
