package gaohaoran.com.mvp_extracting_one.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import java.util.ArrayList;

import butterknife.BindView;
import gaohaoran.com.mvp_extracting_one.R;
import gaohaoran.com.mvp_extracting_one.adapter.RlvShowAdapter;
import gaohaoran.com.mvp_extracting_one.base.BaseActivity;
import gaohaoran.com.mvp_extracting_one.base.Constants;
import gaohaoran.com.mvp_extracting_one.bean.GoldShowBean;
import gaohaoran.com.mvp_extracting_one.presenter.EmptyPresenter;
import gaohaoran.com.mvp_extracting_one.view.EmptyView;
import gaohaoran.com.mvp_extracting_one.widget.SimpleTouchHelperCallBack;

public class ShowActivity extends BaseActivity<EmptyView, EmptyPresenter> implements EmptyView {

    @BindView(R.id.toolBar)
    Toolbar mToolBar;
    @BindView(R.id.rlv)
    RecyclerView mRlv;
    private ArrayList<GoldShowBean> mList;

    @Override
    protected EmptyPresenter initPresenter() {
        return new EmptyPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_show;
    }

    @Override
    protected void initView() {
        mList = (ArrayList<GoldShowBean>) getIntent().getSerializableExtra(Constants.DATA);

        mToolBar.setTitle(R.string.special_show);
        mToolBar.setNavigationIcon(R.drawable.ic_close);
        setSupportActionBar(mToolBar);

        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAct();
            }
        });

        mRlv.setLayoutManager(new LinearLayoutManager(this));
        RlvShowAdapter rlvShowAdapter = new RlvShowAdapter(mList);
        mRlv.setAdapter(rlvShowAdapter);
        mRlv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        //拖拽移动和侧滑删除的功能
        SimpleTouchHelperCallBack simpleTouchHelperCallBack =
                new SimpleTouchHelperCallBack(rlvShowAdapter);
        simpleTouchHelperCallBack.setSwipeEnable(false);
        ItemTouchHelper helper = new ItemTouchHelper(simpleTouchHelperCallBack);
        helper.attachToRecyclerView(mRlv);
    }

    private void finishAct() {
        Intent intent = new Intent();
        intent.putExtra(Constants.DATA, mList);
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        finishAct();
    }

}
