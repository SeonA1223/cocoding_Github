package com.example.myapplication.Code;

import com.example.myapplication.R;
import com.example.myapplication.Recyclerview.RecyclerviewItem;

import java.util.ArrayList;

public class CodeBlockData5 {
    ArrayList<RecyclerviewItem> CodeBlocks5 = new ArrayList<>();

    public ArrayList<RecyclerviewItem> getCodeBlocks5(){

        RecyclerviewItem shape1 = new RecyclerviewItem(R.drawable.shape1);
        RecyclerviewItem shape2 = new RecyclerviewItem(R.drawable.shape2);
        RecyclerviewItem shape3 = new RecyclerviewItem(R.drawable.shape3);

        CodeBlocks5.add(shape3);
        CodeBlocks5.add(shape2);
        CodeBlocks5.add(shape1);

        CodeBlocks5.add(shape1);
        CodeBlocks5.add(shape3);
        CodeBlocks5.add(shape2);

        CodeBlocks5.add(shape3);
        CodeBlocks5.add(shape1);
        CodeBlocks5.add(shape2);

        return CodeBlocks5;
    }
}
