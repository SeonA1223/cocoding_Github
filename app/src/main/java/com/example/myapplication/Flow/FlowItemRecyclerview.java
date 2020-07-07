package com.example.myapplication.Flow;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.myapplication.R;
import com.example.myapplication.Recyclerview.RecyclerviewItem;
import com.example.myapplication.Recyclerview.Recyclerview_ItemAdapter;

import java.util.ArrayList;

public class FlowItemRecyclerview extends Fragment {

    Context context;
    public FlowItemRecyclerview() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_flow_item_recyclerview, container, false);
        context = container.getContext();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.flow_recyclerview);

        final FlowItemData flowItemData = new FlowItemData();
        final Recyclerview_ItemAdapter recyclerview_itemAdapter = new Recyclerview_ItemAdapter(getActivity(), flowItemData.getFlowItems());

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3) {
                                          @Override
                                          public boolean canScrollVertically() {
                                              return false;
                                          }
                                      }
        );

        recyclerView.setAdapter(recyclerview_itemAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            int position;
            View child;

            GestureDetector.OnGestureListener listener;
            final GestureDetector gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }
            });

            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

                int action = e.getAction();

                if (action == MotionEvent.ACTION_DOWN ) {
                    child = rv.findChildViewUnder(e.getX(), e.getY());
                    position = rv.getChildAdapterPosition(child);
                    Toast.makeText(context, "check" + position, Toast.LENGTH_SHORT).show();

                    if (position == 0) {

                        Log.e("test0", "click?");
                        RecyclerviewItem recyclerviewItem = flowItemData.getItem(position);
                        ImageView imageView = new ImageView(context);
                        Log.e("test0", "click?" + recyclerviewItem.getImage());
                        imageView.setImageResource(recyclerviewItem.getImage());


                    }
                }

                return true;
            }


            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

//                int action = e.getAction();
//                float x = e.getX();
//                float y = e.getY();
//                imageView.setX(x - imageView.getWidth() / 2);
//                imageView.setY(y - imageView.getHeight() / 2);

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });


        Log.e("frag", "please success");
        return view;
    }
}
