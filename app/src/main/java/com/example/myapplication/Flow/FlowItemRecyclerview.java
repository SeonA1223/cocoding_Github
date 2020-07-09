package com.example.myapplication.Flow;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.myapplication.R;

public class FlowItemRecyclerview extends Fragment {

    Context context;
    FlowItemData flowItemData;

    public FlowItemRecyclerview() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(flowItemData ==null){
            flowItemData = new FlowItemData();
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_flow_item_recyclerview, container, false);
        context = container.getContext();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.flow_recyclerview);

        Recyclerview_Flow_ItemAdapter flowItemAdapter= new Recyclerview_Flow_ItemAdapter(getActivity(), flowItemData.getFlowItems());

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3) {
                                          @Override
                                          public boolean canScrollVertically() {
                                              return false;
                                          }
                                      }
        );

        recyclerView.setAdapter(flowItemAdapter);
        /*
        * 참조 사이트 https://recipes4dev.tistory.com/168
        * */

        flowItemAdapter.setOnItemClickListener(new Recyclerview_Flow_ItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putInt("itemPosition", position);
                Log.e("frag", "[" + position + "}");
                Log.e("bundle_Test", "[" + bundle.getInt("itemPosition") + "}");
                getParentFragmentManager().setFragmentResult("requestKey", bundle);
                Log.e("bundle_Test", "[" + getParentFragmentManager().toString() + "}");
            }


        });


        Log.e("frag", "please success");
        return view;
    }

}


//  recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
//            int position;
//            View child;
//
//            GestureDetector.OnGestureListener listener;
//            final GestureDetector gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){
//                @Override
//                public boolean onSingleTapUp(MotionEvent e) {
//                    return true;
//                }
//            });
//
//            @Override
//            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
//
//                int action = e.getAction();
//
//                if (action == MotionEvent.ACTION_DOWN ) {
//                    child = rv.findChildViewUnder(e.getX(), e.getY());
//                    position = rv.getChildAdapterPosition(child);
//                    Toast.makeText(context, "check" + position, Toast.LENGTH_SHORT).show();
//
//                    if (position == 0) {
//
//                        Log.e("test0", "click?");
//                        RecyclerviewItem flowItem = flowItemData.getItem(position);
//                        ImageView imageView = new ImageView(context);
//                        Log.e("test0", "click?" + flowItem.getImage());
//                        imageView.setImageResource(flowItem.getImage());
//
//
//                    }
//                }
//
//                    return true;
//                }
//
//
//            @Override
//            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
//
////                int action = e.getAction();
////                float x = e.getX();
////                float y = e.getY();
////                imageView.setX(x - imageView.getWidth() / 2);
////                imageView.setY(y - imageView.getHeight() / 2);
//
//            }
//
//            @Override
//            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
//
//            }
//        });