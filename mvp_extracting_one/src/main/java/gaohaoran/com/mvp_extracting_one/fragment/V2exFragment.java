package gaohaoran.com.mvp_extracting_one.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import gaohaoran.com.mvp_extracting_one.R;
import gaohaoran.com.mvp_extracting_one.base.BaseFragment;
import gaohaoran.com.mvp_extracting_one.bean.V2exTabBean;
import gaohaoran.com.mvp_extracting_one.presenter.V2exPresenter;
import gaohaoran.com.mvp_extracting_one.v2ex_fragment.V2exitemFragment;
import gaohaoran.com.mvp_extracting_one.view.V2exView;

/**
 * A simple {@link Fragment} subclass.
 */
public class V2exFragment extends BaseFragment {


    private static final String TAG = "V2exFragment";
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    private String url = "https://www.v2ex.com/";
    private Unbinder unbinder;
    private ArrayList<String> list;
    private ArrayList<String> heaf;
    @Override
    protected V2exPresenter initPresenter() {
        return new V2exPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_v2ex;
    }

    @Override
    protected void initData() {
        list = new ArrayList<>();
        heaf = new ArrayList<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Document document = Jsoup.connect(url).get();
                    Elements select = document.select("div#Tabs > a");
                    for (Element se : select) {
                        String text = se.text();
                        String herfurl = se.attr("href");
                        Log.d("tag", "====>" + text);
                        Log.d("tag", "====>" + herfurl);
                        list.add(text);
                        heaf.add(herfurl);
                    }
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (list.size() > 0) {
                                tab.setupWithViewPager(vp);
                                vp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
                                    @Override
                                    public Fragment getItem(int i) {
                                        return new V2exitemFragment(heaf.get(i));
                                    }

                                    @Nullable
                                    @Override
                                    public CharSequence getPageTitle(int position) {
                                        return list.get(position);
                                    }

                                    @Override
                                    public int getCount() {
                                        return list.size();
                                    }
                                });

                            }
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //Log.d(TAG, "tabsList: " + tabsList.toString());
        }
    }).start();

}

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
