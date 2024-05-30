package com.vishal.chartr;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.vishal.chartr.homefragment.HomeFrag;
import com.vishal.chartr.homefragment.NearBy;
import com.vishal.chartr.homefragment.Wallet;
import com.vishal.chartr.homefragment.aroundME;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                updateTabStyle(tab, true);
                viewPager.setCurrentItem(tab.getPosition(), false); // Disable swipe
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                updateTabStyle(tab, false);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // Do nothing
            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeFrag(), "Home");
        adapter.addFragment(new NearBy(), "Near By");
        adapter.addFragment(new aroundME(), "Around Me");
        adapter.addFragment(new Wallet(), "Wallet");
        viewPager.setAdapter(adapter);
    }

    private void setupTabIcons() {
        int[] tabIcons = {
                R.drawable.home,
                R.drawable.ic_nearby,
                R.drawable.ic_nearby,
                R.drawable.wallet
        };

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                View customView = LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
                ImageView tabIcon = customView.findViewById(R.id.tab_icon);
                TextView tabText = customView.findViewById(R.id.tab_text);
                tabIcon.setImageResource(tabIcons[i]);
                tabText.setText(tabLayout.getTabAt(i).getText());
                tabText.setTextSize(12); // Adjust text size as needed
                tab.setCustomView(customView);

                // Make the first tab bold initially
                if (i == 0) {
                    tabText.setTypeface(tabText.getTypeface(), Typeface.BOLD);
                }
            }
        }
    }

    private void updateTabStyle(TabLayout.Tab tab, boolean isSelected) {
        View customView = tab.getCustomView();
        if (customView != null) {
            TextView tabText = customView.findViewById(R.id.tab_text);
            if (isSelected) {
                tabText.setTypeface(tabText.getTypeface(), Typeface.BOLD);
            } else {
                tabText.setTypeface(null, Typeface.NORMAL);
            }
        }
    }

    static class MyPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> fragmentList = new ArrayList<>();
        private final List<String> fragmentTitleList = new ArrayList<>();

        MyPagerAdapter(FragmentManager fm) {
            super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        void addFragment(Fragment fragment, String title) {
            fragmentList.add(fragment);
            fragmentTitleList.add(title);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitleList.get(position);
        }
    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                return;
            }

            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Please press again to exit Chartr", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000); // 2 seconds delay
        } else {
            viewPager.setCurrentItem(0);
        }
    }
}
