package gaohaoran.com.mvp_extracting_one.zhihu_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import gaohaoran.com.mvp_extracting_one.R;
import gaohaoran.com.mvp_extracting_one.adapter.HotAdapter;
import gaohaoran.com.mvp_extracting_one.bean.HotBean;
import gaohaoran.com.mvp_extracting_one.model.MainHotModelImpl;
import gaohaoran.com.mvp_extracting_one.presenter.MainHotPresenterImpl;
import gaohaoran.com.mvp_extracting_one.view.MainHotView;

/**
 * A simple {@link Fragment} subclass.
 */
public class hotFragment extends Fragment implements MainHotView {


    private View view;
    private RecyclerView rlv;
    private ArrayList<HotBean.RecentBean> list;
    private HotAdapter adapter;

    public hotFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_hot, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {

        MainHotPresenterImpl mainHotPresenter = new MainHotPresenterImpl(new MainHotModelImpl(), this);
        mainHotPresenter.getHot();

    }

    private void initView(View inflate) {
        rlv = (RecyclerView) inflate.findViewById(R.id.rlv);
        list = new ArrayList<>();
        adapter = new HotAdapter(getContext(), list);
        rlv.setAdapter(adapter);
        rlv.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onHotSuccess(HotBean hotBean) {
        list.addAll(hotBean.getRecent());
        adapter.setList(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onHotFail(String str) {

    }
}
