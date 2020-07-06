package com.example.myapplication.Code;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.myapplication.Flow.MakeFlowFragment;
import com.example.myapplication.Flow.SignalFragment;

public class CodePagerAdapter extends FragmentStatePagerAdapter {
    //makeFlowFragment와 signalFragment 연결하는 Adapter
    private int mPageCount;


    public CodePagerAdapter(FragmentManager fm, int mPageCount) {
        super(fm);
        this.mPageCount = mPageCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                CodeBlockRecyclerview codeBlockRecyclerview = new CodeBlockRecyclerview();
                return codeBlockRecyclerview;
            case 1:
                CodeBlockRecyclerview2 codeBlockRecyclerview2 = new CodeBlockRecyclerview2();
                return codeBlockRecyclerview2;
            case 2:
                CodeBlockRecyclerview2 codeBlockRecyclerview3 = new CodeBlockRecyclerview2();
                return codeBlockRecyclerview3;
            case 3:
                CodeBlockRecyclerview2 codeBlockRecyclerview4 = new CodeBlockRecyclerview2();
                return codeBlockRecyclerview4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mPageCount;
    }
}
