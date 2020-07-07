package com.example.myapplication.Flow;

import com.example.myapplication.R;
import com.example.myapplication.Recyclerview.RecyclerviewItem;

import java.util.ArrayList;

public class FlowItemData {

    ArrayList<RecyclerviewItem> flowItems = new ArrayList<>();

    public ArrayList<RecyclerviewItem> getFlowItems(){

        RecyclerviewItem shape1 = new RecyclerviewItem(R.drawable.shape1);
        RecyclerviewItem shape2 = new RecyclerviewItem(R.drawable.shape2);
        RecyclerviewItem shape3 = new RecyclerviewItem(R.drawable.shape3);

        flowItems.add(shape1);
        flowItems.add(shape2);
        flowItems.add(shape3);

        flowItems.add(shape1);
        flowItems.add(shape2);
        flowItems.add(shape3);

        flowItems.add(shape1);
        flowItems.add(shape2);
        flowItems.add(shape3);

        flowItems.add(shape1);
        flowItems.add(shape2);
        flowItems.add(shape3);

        return flowItems;
    }
    public RecyclerviewItem getItem(int position) { return flowItems.get(position);}
}
