package com.example.myapplication.Code;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.Recyclerview.Recyclerview_ItemAdapter;
import com.example.myapplication.R;


public class CodeBlockRecyclerview extends Fragment {

    private Recyclerview_ItemAdapter recyclerviewItemAdapter;
    private RecyclerView recyclerView;
    private CodeBlockData codeBlockData;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_code_block_recyclerview, container, false);
        ;
        recyclerView = (RecyclerView) view.findViewById(R.id.code_recyclerview);


        codeBlockData = new CodeBlockData();
        recyclerviewItemAdapter = new Recyclerview_ItemAdapter(getActivity(), codeBlockData.getCodeBlocks());


        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        recyclerView.setAdapter(recyclerviewItemAdapter);


        Log.e("frag", "please success");
        return view;
    }

}