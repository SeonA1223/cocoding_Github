package com.example.myapplication.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.Flow.FlowPagerAdapter;
import com.example.myapplication.R;
import com.google.android.material.tabs.TabLayout;

public class FlowFragment extends Fragment {


    public FlowFragment() {
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
        // flow 화면에서 상단에 두 탭을 만듦. 기본 세팅은 MakeFlowFragment 선택(setSelected true)

        View view = inflater.inflate(R.layout.fragment_flow, container, false);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.flow_tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("흐름도 만들기"), 0, true);
        tabLayout.addTab(tabLayout.newTab().setText("신호"), 1);

        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.flow_viewpager);
        FlowPagerAdapter flowPagerAdapter = new FlowPagerAdapter(getChildFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(flowPagerAdapter);

        viewPager.addOnPageChangeListener(
                new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



        return view;

    }
}