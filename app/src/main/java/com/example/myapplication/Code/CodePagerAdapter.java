package com.example.myapplication.Code;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.myapplication.Flow.MakeFlowFragment;
import com.example.myapplication.Flow.SignalFragment;

public class CodePagerAdapter extends FragmentPagerAdapter {
    //Fragment들을 연결하는 Adapter
    int mCount;



    public CodePagerAdapter(FragmentManager fm, int mCount) {
        super(fm);
        this.mCount = mCount;

    }

    @Override
    public Fragment getItem(int position) {
        //위치에 맞는 fragment 동적 생성
        Fragment fragment = new CodeRecyclerview(position);
        return  fragment;
    }

    @Override
    public int getCount() {
        return mCount;
    }
}
