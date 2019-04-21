package gaohaoran.com.mvp_extracting_one.zhihu_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import gaohaoran.com.mvp_extracting_one.R;
import gaohaoran.com.mvp_extracting_one.adapter.ColumnAdapter;
import gaohaoran.com.mvp_extracting_one.bean.ColumnBean;
import gaohaoran.com.mvp_extracting_one.model.MainColumnModelImpl;
import gaohaoran.com.mvp_extracting_one.presenter.MainColumnPresenterImpl;
import gaohaoran.com.mvp_extracting_one.view.MainColumnView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColumnFragment extends Fragment implements MainColumnView {


    private View view;
    private RecyclerView rlv;
    private ArrayList<ColumnBean.DataBean> list;
    private ColumnAdapter adapter;

    public ColumnFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_column, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {

        MainColumnPresenterImpl mainColumnPresenter = new MainColumnPresenterImpl(new MainColumnModelImpl(), this);
        mainColumnPresenter.getColumn();

    }

    private void initView(View inflate) {
        rlv = (RecyclerView) inflate.findViewById(R.id.rlv);
        list = new ArrayList<>();
        adapter = new ColumnAdapter(getContext(), list);
        rlv.setAdapter(adapter);
        rlv.setLayoutManager(new GridLayoutManager(getContext(),2));
    }

    @Override
    public void onColumnSuccess(ColumnBean columnBean) {
        list.addAll(columnBean.getData());
        adapter.setList(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onColumnFail(String str) {

    }
}
