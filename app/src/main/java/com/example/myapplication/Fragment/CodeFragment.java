package com.example.myapplication.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.Code.CodeBlockPage;
import com.example.myapplication.Code.CodeRecyclerview;
import com.example.myapplication.R;


public class CodeFragment extends Fragment {
    //구현 첫번째 화면 페이지
    Button code_shape;
    Fragment codeBlockPage;
    int pNumber = 0;


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

        //버튼 클릭시 fragment replace
        code_shape = (Button) view.findViewById(R.id.code_block);

        codeBlockPage = new CodeBlockPage();


        code_shape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                if (pNumber % 2 == 0) {
                    transaction.replace(R.id.fragment_code, codeBlockPage).commitAllowingStateLoss();
                } else {
                    transaction.remove(codeBlockPage).commitAllowingStateLoss();
                }
                pNumber++;
            }
        });
        return view;

    }
}