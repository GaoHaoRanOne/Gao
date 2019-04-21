package gaohaoran.com.mvp_extracting_one.zhihu_fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import gaohaoran.com.mvp_extracting_one.R;
import gaohaoran.com.mvp_extracting_one.activity.TheCalendarActivity;
import gaohaoran.com.mvp_extracting_one.adapter.DailyCalendarAdapter;
import gaohaoran.com.mvp_extracting_one.adapter.DailyNewsAdapter;
import gaohaoran.com.mvp_extracting_one.bean.DailyCalendarBean;
import gaohaoran.com.mvp_extracting_one.bean.DailyNewsBean;
import gaohaoran.com.mvp_extracting_one.model.MainDailyCalendarModelImpl;
import gaohaoran.com.mvp_extracting_one.model.MainDailyNewsModelImpl;
import gaohaoran.com.mvp_extracting_one.presenter.MainDailyCalendarPresenterImpl;
import gaohaoran.com.mvp_extracting_one.presenter.MainDailyNewsPresenterImpl;
import gaohaoran.com.mvp_extracting_one.view.MainDailyCalendarView;
import gaohaoran.com.mvp_extracting_one.view.MainDailyNewsView;

/**
 * A simple {@link Fragment} subclass.
 */
public class DailyFragment extends Fragment implements MainDailyNewsView {


    private View view;
    private RecyclerView rlv;
    private ArrayList<DailyNewsBean.TopStoriesBean> bannerlist;
    private ArrayList<DailyNewsBean.StoriesBean> itemlist;
    private DailyNewsAdapter adapter;
    private FloatingActionButton fab;
    private String url;
    private String mData;
    private ArrayList<DailyCalendarBean.StoriesBean> list = new ArrayList<>();
    private DailyCalendarAdapter dailyCalendarAdapter;
    public DailyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View inflate = inflater.inflate(R.layout.fragment_daily, container, false);
        initView(inflate);
        initData();

        //EventBus.getDefault().register(this);
        initCalendar();
        return inflate;
    }

//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        EventBus.getDefault().unregister(this);
//    }

//    @Subscribe(threadMode = ThreadMode.MAIN)
//    private void initDailyCalendarEvenbus(String data) {
//        mData = "news/before/"+data;
//        String yy = data.substring(0, 4);
//        String mm = data.substring(4, 6);
//
//        list.clear();
//        initDailyCalendar();
//
//    }

//    private void initDailyCalendar() {
//
//
//        MainDailyCalendarPresenterImpl mainDailyCalendarPresenter = new MainDailyCalendarPresenterImpl(new MainDailyCalendarModelImpl(), this);
//
//        mainDailyCalendarPresenter.getDailyCalendar(url);
//
//    }

    private void initCalendar() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), TheCalendarActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initData() {

        MainDailyNewsPresenterImpl mainDailyNewsPresenter = new MainDailyNewsPresenterImpl(new MainDailyNewsModelImpl(), this);
        mainDailyNewsPresenter.getDailyNews();

    }

    private void initView(View inflate) {

        rlv = (RecyclerView) inflate.findViewById(R.id.rlv);
        bannerlist = new ArrayList<>();
        itemlist = new ArrayList<>();
        adapter = new DailyNewsAdapter(getContext(), bannerlist, itemlist);
        rlv.setAdapter(adapter);
        rlv.setLayoutManager(new LinearLayoutManager(getContext()));
        fab = (FloatingActionButton) inflate.findViewById(R.id.fab);



//        dailyCalendarAdapter = new DailyCalendarAdapter(getContext(), list);
//        rlv.setAdapter(dailyCalendarAdapter);
//        rlv.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onDailyNewsSuccess(DailyNewsBean dailyNewsBean) {
        itemlist.addAll(dailyNewsBean.getStories());
        bannerlist.addAll(dailyNewsBean.getTop_stories());
        adapter.setItemlist(itemlist);
        adapter.setBannerlist(bannerlist);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDailyNewsFail(String str) {

    }

//    @Override
//    public void onDailyCalendarSuccess(DailyCalendarBean dailyCalendarBean) {
//
//        list.addAll(dailyCalendarBean.getStories());
//        dailyCalendarAdapter.setList(list);
//        dailyCalendarAdapter.notifyDataSetChanged();
//
//    }
//
//    @Override
//    public void onDailyCalendarFail(String str) {
//
//    }
}
