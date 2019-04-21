package gaohaoran.com.mvp_extracting_one.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import gaohaoran.com.mvp_extracting_one.R;
import gaohaoran.com.mvp_extracting_one.adapter.ZhiHuAdapter;
import gaohaoran.com.mvp_extracting_one.zhihu_fragment.ColumnFragment;
import gaohaoran.com.mvp_extracting_one.zhihu_fragment.DailyFragment;
import gaohaoran.com.mvp_extracting_one.zhihu_fragment.hotFragment;

/**
 * A simple {@link Fragment} subclass.
 * 高浩然1808D
 */
public class ZhihuFragment extends Fragment {


    private View view;
    private ViewPager vp;
    private RecyclerView rlv;
    private TabLayout tab;

    public ZhihuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_zhihu, container, false);
        initView(inflate);
        addFragment();
        return inflate;
    }

    private void addFragment() {

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new DailyFragment());
        fragments.add(new ColumnFragment());
        fragments.add(new hotFragment());
        ArrayList<String> strings = new ArrayList<>();
        strings.add("日报");
        strings.add("专栏");
        strings.add("热门");
        ZhiHuAdapter zhiHuAdapter = new ZhiHuAdapter(getChildFragmentManager(), fragments, strings);
        vp.setAdapter(zhiHuAdapter);
        tab.setupWithViewPager(vp);

    }

    private void initView(View inflate) {
        vp = (ViewPager) inflate.findViewById(R.id.vp);
        rlv = (RecyclerView) inflate.findViewById(R.id.rlv);
        tab = (TabLayout) inflate.findViewById(R.id.tab);
    }
}
