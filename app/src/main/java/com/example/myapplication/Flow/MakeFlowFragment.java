package com.example.myapplication.Flow;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.myapplication.R;

import java.util.ArrayList;


public class MakeFlowFragment extends Fragment {
    //흐름도 만들기 페이지
    Button flow_shape;
    LinearLayout linearLayout;
    Fragment flowItemRecyclerview;
    ArrayList arrayList;
    int image;


    int mNumber = 0;


    public MakeFlowFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_flow_make_flow, container, false);

        flow_shape = (Button) view.findViewById(R.id.flow_figure);
        linearLayout = (LinearLayout) view.findViewById(R.id.second_fragment_flow_make_flow);

        flowItemRecyclerview = new FlowItemRecyclerview();


        flow_shape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

                //transaction.add(R.id.fragment_flow_make_flow, flowItemRecyclerview, "recycle")

                if (mNumber % 2 == 0 || flowItemRecyclerview == null) {
                    Log.e("a", "come?");
                    transaction.add(R.id.fragment_flow_make_flow, flowItemRecyclerview).addToBackStack(null).commitAllowingStateLoss();
                } else {
                    Log.e("b", "come?");
                    transaction.remove(flowItemRecyclerview).commitAllowingStateLoss();
                }
                mNumber++;
            }

        });

        linearLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.e("problem", "please I want to know");
                FragmentManager fragmentManager = getChildFragmentManager();
                if (flowItemRecyclerview != null) {
                    fragmentManager.popBackStack();
                    mNumber++;
                }

            }
        });


        linearLayout.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });

        return view;

    }

    @Override
    public void onResume() {

        super.onResume();


        getChildFragmentManager().setFragmentResultListener("requestKey", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                image = result.getInt("itemPosition");
                Log.e("Fragment data send", "[" + image + "]");
            }
        });

        ImageView imageView = makeImageview(image, getActivity());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        linearLayout.addView(imageView);

    }

    private ImageView makeImageview(int image, Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(image);

        return imageView;
    }
}

