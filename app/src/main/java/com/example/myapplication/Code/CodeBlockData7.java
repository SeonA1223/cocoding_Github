package com.example.myapplication.Code;

import com.example.myapplication.R;
import com.example.myapplication.Recyclerview.RecyclerviewItem;

import java.util.ArrayList;

public class CodeBlockData7 {
    ArrayList<RecyclerviewItem> CodeBlocks7 = new ArrayList<>();

    public ArrayList<RecyclerviewItem> getCodeBlocks7(){

        RecyclerviewItem shape1 = new RecyclerviewItem(R.drawable.shape1);
        RecyclerviewItem shape2 = new RecyclerviewItem(R.drawable.shape2);
        RecyclerviewItem shape3 = new RecyclerviewItem(R.drawable.shape3);

        CodeBlocks7.add(shape3);
        CodeBlocks7.add(shape2);
        CodeBlocks7.add(shape1);

        CodeBlocks7.add(shape1);
        CodeBlocks7.add(shape2);
        CodeBlocks7.add(shape1);


        return CodeBlocks7;
    }
}

