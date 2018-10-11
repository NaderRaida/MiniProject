package com.goldcode.naderwalid.miniproject;

import android.app.ActionBar;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class HomeFragment extends Fragment {
    private PagerAdapter mPagerAdapter;
    private ViewPager mViewPager;
    ActionBar actionBar;
    TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        actionBar = getActivity().getActionBar();
//
//
//        // Specify that tabs should be displayed in the action bar.
////        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
//
//        // Create a tab listener that is called when the user changes tabs.
//        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
//            @Override
//            public void onTabSelected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {
//                mViewPager.setCurrentItem(tab.getPosition());
//
//            }
//
//            @Override
//            public void onTabUnselected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {
//
//            }
//
//            @Override
//            public void onTabReselected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {
//
//            }
//
//
//        };
//
//        // Add 3 tabs, specifying the tab's text and TabListener
//        for (int i = 0; i < PagerAdapter.names_here.length; i++) {
//            actionBar.addTab(
//                    actionBar.newTab()
//                             .setText(PagerAdapter.names_here[i])
//                            .setTabListener(tabListener));
//        }
//
//        mViewPager.setOnPageChangeListener(
//                new ViewPager.SimpleOnPageChangeListener() {
//                    @Override
//                    public void onPageSelected(int position) {
//                        // When swiping between pages, select the
//                        // corresponding tab.
//                        actionBar.setSelectedNavigationItem(position);
//                    }
//                });

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment_layout, container, false);
        textView =  view.findViewById(R.id.textViewP);
        final String text = textView.getText().toString();
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD),0,36, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
        mViewPager = view.findViewById(R.id.viewPager);
        mViewPager.setClipToPadding(false);
//        mViewPager.setPadding(300, 0, 300, 0);

        // Create a new ImageAdapter (subclass of FragmentStatePagerAdapter)
        // ViewPager uses support library, so use getSupportFragmentManager()
        // instead of getFragmentManager()
        mPagerAdapter = new PagerAdapter(getActivity().getSupportFragmentManager(),getActivity());

        // Set the Adapter on the ViewPager
        mViewPager.setAdapter(mPagerAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                textView.setText(getResources().getStringArray(R.array.moods_desc)[position]);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return view;
    }


}
