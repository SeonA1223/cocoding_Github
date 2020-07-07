package com.example.myapplication.Flow;

import com.example.myapplication.R;
import com.example.myapplication.Recyclerview.RecyclerviewItem;

import java.util.ArrayList;

public class FlowItemData {

    RecyclerviewItem shape1 = new RecyclerviewItem(R.drawable.shape1);
    RecyclerviewItem shape2 = new RecyclerviewItem(R.drawable.shape2);
    RecyclerviewItem shape3 = new RecyclerviewItem(R.drawable.shape3);

    ArrayList<RecyclerviewItem> flowItems = new ArrayList<>();

    public FlowItemData() {
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

    }

    public ArrayList<RecyclerviewItem> getFlowItems() {


        return flowItems;
    }

    public RecyclerviewItem getItem(int position) {
        return flowItems.get(position);
    }
}
