package com.example.myapplication;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.Fragment.CodeFragment;
import com.example.myapplication.Fragment.FlowFragment;
import com.example.myapplication.Fragment.IdeaFragment;
import com.example.myapplication.Fragment.ObjectFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SecondActivity extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private CodeFragment codeFragment = new CodeFragment();
    private FlowFragment flowFragment = new FlowFragment();
    private IdeaFragment IdeaFragment = new IdeaFragment();
    private ObjectFragment objectFragment = new ObjectFragment();

    BottomNavigationView bottomNavigationView;

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

    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener{
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch(menuItem.getItemId())
            {
                case R.id.bottom_navigation_item_idea:
                    transaction.replace(R.id.frameLayout, IdeaFragment).commitAllowingStateLoss();
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
