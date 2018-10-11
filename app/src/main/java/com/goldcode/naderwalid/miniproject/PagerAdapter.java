package com.goldcode.naderwalid.miniproject;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    Context context;
    public PagerAdapter(FragmentManager fm , Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = new ImageFragment();
        Bundle args = new Bundle();
        args.putInt(ImageFragment.RES_ID, MainActivity.drawables[i]);
        args.putString(ImageFragment.POS, String.valueOf(i));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return MainActivity.drawables.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return context.getResources().getStringArray(R.array.moods_names)[position];

    }
}

