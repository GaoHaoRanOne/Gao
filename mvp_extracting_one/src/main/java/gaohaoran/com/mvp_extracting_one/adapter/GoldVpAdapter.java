package gaohaoran.com.mvp_extracting_one.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import java.util.ArrayList;

import gaohaoran.com.mvp_extracting_one.base.BaseFragment;
import gaohaoran.com.mvp_extracting_one.bean.GoldShowBean;

public class GoldVpAdapter extends FragmentPagerAdapter{
    private ArrayList<BaseFragment> mFragments;
    private ArrayList<GoldShowBean> mTitles;
    private ArrayList<String> mNewTitles = new ArrayList<>();

    public GoldVpAdapter(FragmentManager fm,
                         ArrayList<BaseFragment> fragments,
                         ArrayList<GoldShowBean> titles) {
        super(fm);
        mFragments = fragments;
        mTitles = titles;

        for (int i = 0; i < mTitles.size(); i++) {
            GoldShowBean bean = mTitles.get(i);
            if (bean.isChecked){
                mNewTitles.add(bean.title);
            }
        }
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mNewTitles.get(position);
    }
}
