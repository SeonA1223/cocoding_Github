package com.example.myapplication.Code;

import com.example.myapplication.R;
import com.example.myapplication.Recyclerview.RecyclerviewItem;

import java.util.ArrayList;

public class CodeBlockData6 {
    ArrayList<RecyclerviewItem> CodeBlocks6 = new ArrayList<>();

    public ArrayList<RecyclerviewItem> getCodeBlocks6(){

        RecyclerviewItem shape1 = new RecyclerviewItem(R.drawable.shape1);
        RecyclerviewItem shape2 = new RecyclerviewItem(R.drawable.shape2);
        RecyclerviewItem shape3 = new RecyclerviewItem(R.drawable.shape3);

        CodeBlocks6.add(shape3);
        CodeBlocks6.add(shape2);
        CodeBlocks6.add(shape1);

        CodeBlocks6.add(shape1);
        CodeBlocks6.add(shape1);
        CodeBlocks6.add(shape1);

        return CodeBlocks6;
    }
}

