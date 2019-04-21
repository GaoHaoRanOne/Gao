package gaohaoran.com.mvp_extracting_one.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import gaohaoran.com.mvp_extracting_one.R;
import gaohaoran.com.mvp_extracting_one.activity.WechatWebActivity;
import gaohaoran.com.mvp_extracting_one.adapter.WechatAdapter;
import gaohaoran.com.mvp_extracting_one.bean.SearchBean;
import gaohaoran.com.mvp_extracting_one.bean.WechatBean;
import gaohaoran.com.mvp_extracting_one.model.MainWechatModelImpl;
import gaohaoran.com.mvp_extracting_one.presenter.MainWechatPresenterImpl;
import gaohaoran.com.mvp_extracting_one.view.MainWechatView;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeChatFragment extends Fragment implements MainWechatView, WechatAdapter.OnItemClickListener {


    private View view;
    private RecyclerView rlv;
    private ArrayList<WechatBean.NewslistBean> list = new ArrayList<>();
    private WechatAdapter adapter;
    private String title;
    private MainWechatPresenterImpl mainWechatPresenter;

    public WeChatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_wechat, container, false);
        mainWechatPresenter = new MainWechatPresenterImpl(new MainWechatModelImpl(), this);

        initView(inflate);
        initData();
//        initData2();
        //注册
        EventBus.getDefault().register(this);
        return inflate;
    }

    private void initData2() {
        list.clear();
        Map<String,Object> map = new HashMap<>();
        map.put("key","52b7ec3471ac3bec6846577e79f20e4c");
        map.put("num",10);
        map.put("page",1);
        map.put("word",title);
//        key=52b7ec3471ac3bec6846577e79f20e4c&num=10&page=1)
        mainWechatPresenter.getWord(map);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //EventBus取消注册
        EventBus.getDefault().unregister(this);
    }


    private void initData() {

        Map<String,Object> map = new HashMap<>();
        map.put("key","52b7ec3471ac3bec6846577e79f20e4c");
        map.put("num",10);
        map.put("page",1);
        mainWechatPresenter.getWechat(map);

    }

    private void initView(View inflate) {
        rlv = (RecyclerView) inflate.findViewById(R.id.rlv);

        adapter = new WechatAdapter(getContext(), list);
        rlv.setAdapter(adapter);
        rlv.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.setOnClick(this);


       /* ArrayList<WechatBean.NewslistBean> list1 = new ArrayList<>();
        WechatAdapter adapter1 = new WechatAdapter(getContext(), list1);
        rlv.setAdapter(adapter1);
        rlv.setLayoutManager(new LinearLayoutManager(getContext()));*/
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onDataSynEvent(String event){
        SearchBean searchBean = new SearchBean();
        title = event;
        initData2();
    }
    @Override
    public void onWechatSuccess(WechatBean wechatBean) {
        list.addAll(wechatBean.getNewslist());
        adapter.setList(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onWordSuccess(WechatBean wechatBean) {
        adapter.addData(wechatBean);
    }

    @Override
    public void onWechatFail(String str) {

    }

    @Override
    public void Click(int position, WechatBean.NewslistBean newslistBean) {
        Intent intent = new Intent(getContext(), WechatWebActivity.class);
        intent.putExtra("url",list.get(position).getUrl());
        getContext().startActivity(intent);
    }

}
