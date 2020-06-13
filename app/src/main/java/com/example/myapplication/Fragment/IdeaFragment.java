package com.example.myapplication.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.myapplication.Example;
import com.example.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IdeaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IdeaFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

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

        LinearLayout linearLayout = (LinearLayout) getView().findViewById(R.id.abcd);
        return inflater.inflate(R.layout.fragment_idea, container, false);
    }

    @Override
    public void onClick(View v) {
        switch (getView().getId()){
            case R.id.abcd:
                Intent intent = new Intent(getActivity(), Example.class);
                startActivity(intent);
        }
    }
}