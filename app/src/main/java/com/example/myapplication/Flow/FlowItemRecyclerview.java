package com.example.myapplication.Flow;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;

import java.util.ArrayList;

public class FlowItemRecyclerview extends Fragment {

    private FlowItemAdapter flowItemAdapter;
    private RecyclerView recyclerView;
    private FlowItemData flowItemData;

    public FlowItemRecyclerview() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_flow_item_recyclerview, container, false);;
        recyclerView = (RecyclerView)view.findViewById(R.id.flow_recyclerview);

       flowItemData = new FlowItemData();
       flowItemAdapter = new FlowItemAdapter(getActivity(), flowItemData.getFlowItems());

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        recyclerView.setAdapter(flowItemAdapter);

        Log.e("frag", "please success");
        return view;
    }
}