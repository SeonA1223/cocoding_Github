package com.example.myapplication.Code;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.Recyclerview.Recyclerview_ItemAdapter;

public class CodeBlockRecyclerview4 extends Fragment {

    private Recyclerview_ItemAdapter recyclerviewItemAdapter;
    private RecyclerView recyclerView;
    private CodeBlockData4 codeBlockData4;


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

        codeBlockData4 = new CodeBlockData4();
        recyclerviewItemAdapter = new Recyclerview_ItemAdapter(getActivity(), codeBlockData4.getCodeBlocks4());

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));

        recyclerView.setAdapter(recyclerviewItemAdapter);

        Log.e("frag", "please success");
        return view;
    }
}