package com.example.myapplication.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.Code.CodeBlockPage;
import com.example.myapplication.Code.CodeBlockRecyclerview2;
import com.example.myapplication.R;


public class CodeFragment extends Fragment {
    //흐름도 만들기 페이지
    Button code_shape;
    Fragment codeBlockRecyclerview2;
    Fragment codeBlockPage;
    int mNumber = 0;


    public CodeFragment() {
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
        View view = inflater.inflate(R.layout.fragment_code, container, false);

        code_shape = (Button) view.findViewById(R.id.code_block);

        codeBlockRecyclerview2 = new CodeBlockRecyclerview2();
        codeBlockPage = new CodeBlockPage();


        code_shape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                if (mNumber % 2 == 0) {
                    transaction.replace(R.id.fragment_code, codeBlockPage).commit();
                } else {
                    transaction.remove(codeBlockPage).commit();
                }
                mNumber++;
            }
        });
        return view;

    }
}