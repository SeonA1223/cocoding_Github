package com.example.myapplication.Code;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.Flow.FlowPagerAdapter;
import com.example.myapplication.R;
import com.google.android.material.tabs.TabLayout;

public class CodeBlockPage extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // flow 화면에서 상단에 두 탭을 만듦. 기본 세팅은 MakeFlowFragment 선택(setSelected true)

        View view = inflater.inflate(R.layout.fragment_code_block_page, container, false);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.code_tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("객체"), 0, true);
        tabLayout.addTab(tabLayout.newTab().setText("동작"), 1);
        tabLayout.addTab(tabLayout.newTab().setText("형태"), 2);
        tabLayout.addTab(tabLayout.newTab().setText("이벤트"), 3);
        tabLayout.addTab(tabLayout.newTab().setText("제어"), 4);
        tabLayout.addTab(tabLayout.newTab().setText("감지"), 5);
        tabLayout.addTab(tabLayout.newTab().setText("연산"), 6);
        tabLayout.addTab(tabLayout.newTab().setText("변수"), 7);


        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.code_viewpager);
        CodePagerAdapter codePagerAdapter = new CodePagerAdapter(getChildFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(codePagerAdapter);

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
