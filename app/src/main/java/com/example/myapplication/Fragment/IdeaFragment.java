package com.example.myapplication.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.myapplication.Idea.Idea_Algorithm;
import com.example.myapplication.Idea.Idea_Topic;
import com.example.myapplication.Idea.Idea_Topic_Contents;
import com.example.myapplication.R;


public class IdeaFragment extends Fragment {


    public IdeaFragment() {
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

        View view = inflater.inflate(R.layout.fragment_idea, container, false);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.idea_topic);
        LinearLayout linearLayout1 = (LinearLayout) view.findViewById(R.id.idea_topic_contents);
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.idea_algorithm);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Idea_Topic.class);
                startActivity(intent);
            }
        });
//        return view;

        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Idea_Topic_Contents.class);
                startActivity(intent);
            }
        });
//        return view;

        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Idea_Algorithm.class);
                startActivity(intent);
            }
        });
        return view;

    }




}