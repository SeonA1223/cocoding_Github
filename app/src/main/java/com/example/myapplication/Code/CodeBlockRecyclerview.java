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

//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    public CodeBlockRecyclerview() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment CodeBlockRecyclerview.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static CodeBlockRecyclerview newInstance(String param1, String param2) {
//        CodeBlockRecyclerview fragment = new CodeBlockRecyclerview();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_code_block_recyclerview, container, false);
//    }

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
        View view = inflater.inflate(R.layout.fragment_code_block_recyclerview, container, false);;
        recyclerView = (RecyclerView)view.findViewById(R.id.code_recyclerview);

        codeBlockData = new CodeBlockData();
        recyclerviewItemAdapter = new Recyclerview_ItemAdapter(getActivity(), codeBlockData.getCodeBlocks());

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        recyclerView.setAdapter(recyclerviewItemAdapter);

        Log.e("frag", "please success");
        return view;
    }
    //



}