package com.example.myapplication.Code;

import com.example.myapplication.R;
import com.example.myapplication.Recyclerview.RecyclerviewItem;

import java.util.ArrayList;

public class CodeBlockData4 {
    ArrayList<RecyclerviewItem> CodeBlocks4 = new ArrayList<>();

    public ArrayList<RecyclerviewItem> getCodeBlocks4(){

        RecyclerviewItem shape1 = new RecyclerviewItem(R.drawable.shape1);
        RecyclerviewItem shape2 = new RecyclerviewItem(R.drawable.shape2);
        RecyclerviewItem shape3 = new RecyclerviewItem(R.drawable.shape3);

        CodeBlocks4.add(shape3);
        CodeBlocks4.add(shape2);
        CodeBlocks4.add(shape1);

        CodeBlocks4.add(shape3);
        CodeBlocks4.add(shape2);
        CodeBlocks4.add(shape3);

        CodeBlocks4.add(shape3);
        CodeBlocks4.add(shape3);


        return CodeBlocks4;
    }
}
