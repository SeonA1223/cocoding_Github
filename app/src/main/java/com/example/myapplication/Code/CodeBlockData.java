package com.example.myapplication.Code;

import com.example.myapplication.Recyclerview.RecyclerviewItem;
import com.example.myapplication.R;

import java.util.ArrayList;

public class CodeBlockData {
    ArrayList<RecyclerviewItem> CodeBlocks = new ArrayList<>();

    public ArrayList<RecyclerviewItem> getCodeBlocks(){

        RecyclerviewItem shape1 = new RecyclerviewItem(R.drawable.shape1);
        RecyclerviewItem shape2 = new RecyclerviewItem(R.drawable.shape2);
        RecyclerviewItem shape3 = new RecyclerviewItem(R.drawable.shape3);

        CodeBlocks.add(shape1);
        CodeBlocks.add(shape2);
        CodeBlocks.add(shape3);

        CodeBlocks.add(shape1);
        CodeBlocks.add(shape2);
        CodeBlocks.add(shape3);

        CodeBlocks.add(shape1);
        CodeBlocks.add(shape2);
        CodeBlocks.add(shape3);

        CodeBlocks.add(shape1);
        CodeBlocks.add(shape2);
        CodeBlocks.add(shape3);

        return CodeBlocks;
    }
}
