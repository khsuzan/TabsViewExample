package com.plus.tabsviewexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.plus.tabsviewexample.fragments.ParaFragment;
import com.plus.tabsviewexample.fragments.QuranFragment;
import com.plus.tabsviewexample.fragments.SuraFragment;

public class MainActivity extends AppCompatActivity {

    public static final String[] name = {"Quran","Sura","Para"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tablayout);
        ViewPager2 viewPager2 = findViewById(R.id.viewPager);

        viewPager2.setAdapter(new TabAdapter(getSupportFragmentManager(), getLifecycle()));

        new TabLayoutMediator(tabLayout,viewPager2,(tab, position) -> tab.setText(name[position])
        ).attach();

    }
    static class TabAdapter extends FragmentStateAdapter {
        public static final int TAB_COUNT = 3;

        public TabAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
        }


        @NonNull
        @Override
        public Fragment createFragment(int position) {

            switch (position){
                case 0:
                    return new QuranFragment();
                case 1:
                    return new SuraFragment();
                case 2:
                    return new ParaFragment();
                default: return new QuranFragment();
            }
        }

        @Override
        public int getItemCount() {
            return TAB_COUNT;
        }
    }
}