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
                CodeBlockRecyclerview1 codeBlockRecyclerview1 = new CodeBlockRecyclerview1();
                return codeBlockRecyclerview1;
            case 2:
                CodeBlockRecyclerview2 codeBlockRecyclerview2 = new CodeBlockRecyclerview2();
                return codeBlockRecyclerview2;
            case 3:
                CodeBlockRecyclerview3 codeBlockRecyclerview3 = new CodeBlockRecyclerview3();
                return codeBlockRecyclerview3;
            case 4:
                CodeBlockRecyclerview4 codeBlockRecyclerview4 = new CodeBlockRecyclerview4();
                return codeBlockRecyclerview4;
            case 5:
                CodeBlockRecyclerview5 codeBlockRecyclerview5 = new CodeBlockRecyclerview5();
                return codeBlockRecyclerview5;
            case 6:
                CodeBlockRecyclerview6 codeBlockRecyclerview6 = new CodeBlockRecyclerview6();
                return codeBlockRecyclerview6;
            case 7:
                CodeBlockRecyclerview7 codeBlockRecyclerview7 = new CodeBlockRecyclerview7();
                return codeBlockRecyclerview7;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mPageCount;
    }
}
