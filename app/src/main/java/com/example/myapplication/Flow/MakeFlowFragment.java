package com.example.myapplication.Flow;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myapplication.R;


public class MakeFlowFragment extends Fragment {
    //흐름도 만들기 페이지
    Button flow_shape;
    Fragment flowItemRecyclerview;
    int mNumber = 0;


    public MakeFlowFragment() {
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
        View view = inflater.inflate(R.layout.fragment_flow_make_flow, container, false);

        flow_shape = (Button) view.findViewById(R.id.flow_figure);

        flowItemRecyclerview = new FlowItemRecyclerview();


        flow_shape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                if(mNumber % 2 == 0) {
                    transaction.replace(R.id.fragment_flow_make_flow, flowItemRecyclerview).commit();
                }else{
                    transaction.remove(flowItemRecyclerview).commit();
                }
                mNumber++;
            }
        });
        return view;

    }
}