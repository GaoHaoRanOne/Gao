package gaohaoran.com.mvp_extracting_one.fragment;


import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import gaohaoran.com.mvp_extracting_one.R;
import gaohaoran.com.mvp_extracting_one.activity.ShowActivity;
import gaohaoran.com.mvp_extracting_one.adapter.GoldVpAdapter;
import gaohaoran.com.mvp_extracting_one.base.BaseFragment;
import gaohaoran.com.mvp_extracting_one.base.Constants;
import gaohaoran.com.mvp_extracting_one.bean.GoldShowBean;
import gaohaoran.com.mvp_extracting_one.gold_fragment.GoldDetailFragment;
import gaohaoran.com.mvp_extracting_one.presenter.GoldPresenter;
import gaohaoran.com.mvp_extracting_one.view.GankView;
import gaohaoran.com.mvp_extracting_one.view.GoldView;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoldFragment extends BaseFragment<GoldView, GoldPresenter>
        implements GankView {


    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.iv)
    ImageView iv;
    @BindView(R.id.vp)
    ViewPager vp;
    private ArrayList<GoldShowBean> mList;
    private ArrayList<BaseFragment> mFragments;

    @Override
    protected GoldPresenter initPresenter() {
        return new GoldPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gold;
    }

    @Override
    protected void initView() {
        initTitle();
        setFragments();
    }

    private void setFragments() {
        initFragments();
        GoldVpAdapter adapter = new GoldVpAdapter(getChildFragmentManager(),
                mFragments, mList);
        vp.setAdapter(adapter);
        tab.setupWithViewPager(vp);
    }

    private void initFragments() {
        mFragments = new ArrayList<>();
        for (int i = 0; i < mList.size(); i++) {
            GoldShowBean bean = mList.get(i);
            if (bean.isChecked){
                mFragments.add(GoldDetailFragment.newInstance(bean.title));
            }
        }
    }

    private void initTitle() {
        mList = new ArrayList<>();
        mList.add(new GoldShowBean("工具资源",true));
        mList.add(new GoldShowBean("Android",true));
        mList.add(new GoldShowBean("iOS",true));
        mList.add(new GoldShowBean("设计",true));
        mList.add(new GoldShowBean("产品",true));
        mList.add(new GoldShowBean("阅读",true));
        mList.add(new GoldShowBean("前端",true));
        mList.add(new GoldShowBean("后端",true));
    }

    @OnClick({R.id.iv})
    public void click(View v){
        switch (v.getId()) {
            case R.id.iv:
                go2ShowActivity();
                break;
        }
    }

    private void go2ShowActivity() {
        Intent intent = new Intent(getContext(), ShowActivity.class);
        intent.putExtra(Constants.DATA,mList);
        startActivityForResult(intent,100);
        //getActivity().startActivityForResult();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null){
            if (requestCode == 100 && resultCode == Activity.RESULT_OK){
                mList = (ArrayList<GoldShowBean>) data.getSerializableExtra(Constants.DATA);
                //刷新界面
                setFragments();
            }
        }
    }
}
