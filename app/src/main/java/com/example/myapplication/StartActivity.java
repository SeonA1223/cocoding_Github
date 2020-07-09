package com.example.myapplication;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.Flow.FlowItemRecyclerview;
import com.example.myapplication.Fragment.CodeFragment;
import com.example.myapplication.Fragment.FlowFragment;
import com.example.myapplication.Fragment.IdeaFragment;
import com.example.myapplication.Fragment.ObjectFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class StartActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private Fragment codeFragment = new CodeFragment();
    private Fragment flowFragment = new FlowFragment();
    private Fragment IdeaFragment = new IdeaFragment();
    private Fragment objectFragment = new ObjectFragment();
  //  private FlowItemRecyclerview flowItemRecyclerview = new FlowItemRecyclerview();

    protected BottomNavigationView bottomNavigationView;

   // FrameLayout frameLayout = findViewById(R.id.framelayout);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_navigation_bar);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, IdeaFragment).commitAllowingStateLoss();

        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener{
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch(menuItem.getItemId())
            {
                case R.id.bottom_navigation_item_idea:
                    transaction.replace(R.id.frameLayout, IdeaFragment).commitAllowingStateLoss();
//                    transaction.hide(flowFragment);
                    break;
                case R.id.bottom_navigation_item_flow:
                    transaction.replace(R.id.frameLayout, flowFragment).commitAllowingStateLoss();
                    break;
                case R.id.bottom_navigation_item_object:
                    transaction.replace(R.id.frameLayout, objectFragment).commitAllowingStateLoss();
                    break;
                case R.id.bottom_navigation_item_code:
                    transaction.replace(R.id.frameLayout, codeFragment).commitAllowingStateLoss();
                    break;
            }
            return false;
        }
    }



}
