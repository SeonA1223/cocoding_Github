package com.example.myapplication.Code;

import com.example.myapplication.R;
import com.example.myapplication.Recyclerview.RecyclerviewItem;

import java.util.ArrayList;

public class CodeBlockData2 {
    ArrayList<RecyclerviewItem> CodeBlocks2 = new ArrayList<>();

    public ArrayList<RecyclerviewItem> getCodeBlocks2(){

        RecyclerviewItem shape1 = new RecyclerviewItem(R.drawable.shape1);
        RecyclerviewItem shape2 = new RecyclerviewItem(R.drawable.shape2);
        RecyclerviewItem shape3 = new RecyclerviewItem(R.drawable.shape3);

        CodeBlocks2.add(shape1);
        CodeBlocks2.add(shape2);
        CodeBlocks2.add(shape3);

        CodeBlocks2.add(shape1);
        CodeBlocks2.add(shape2);
        CodeBlocks2.add(shape3);

        CodeBlocks2.add(shape1);
        CodeBlocks2.add(shape2);
        CodeBlocks2.add(shape3);

        CodeBlocks2.add(shape1);
        CodeBlocks2.add(shape2);
        CodeBlocks2.add(shape3);

        return CodeBlocks2;
    }
}
