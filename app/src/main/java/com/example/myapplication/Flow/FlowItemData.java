package com.example.myapplication.Flow;

import com.example.myapplication.R;

import java.util.ArrayList;

public class FlowItemData {

    ArrayList<FlowItem> flowItems = new ArrayList<>();

    public ArrayList<FlowItem> getFlowItems(){

        FlowItem shape1 = new FlowItem(R.drawable.shape1);
        FlowItem shape2 = new FlowItem(R.drawable.shape2);
        FlowItem shape3 = new FlowItem(R.drawable.shape3);
        FlowItem shape4 = new FlowItem(R.drawable.shape4);
        FlowItem shape5 = new FlowItem(R.drawable.shape5);
        FlowItem shape6 = new FlowItem(R.drawable.shape6);

        flowItems.add(shape1);
        flowItems.add(shape2);
        flowItems.add(shape3);

        flowItems.add(shape4);
        flowItems.add(shape5);
        flowItems.add(shape6);



        return flowItems;
    }
}
