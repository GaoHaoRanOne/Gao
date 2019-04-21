package gaohaoran.com.mvp_extracting_one.presenter;

import gaohaoran.com.mvp_extracting_one.api.ColumnCallBack;
import gaohaoran.com.mvp_extracting_one.bean.ColumnBean;
import gaohaoran.com.mvp_extracting_one.model.MainColumnModel;
import gaohaoran.com.mvp_extracting_one.view.MainColumnView;

public class MainColumnPresenterImpl implements MainColumnPresenter,ColumnCallBack{
    private MainColumnModel mainColumnModel;
    private MainColumnView mainColumnView;

    public MainColumnPresenterImpl(MainColumnModel mainColumnModel, MainColumnView mainColumnView) {
        this.mainColumnModel = mainColumnModel;
        this.mainColumnView = mainColumnView;
    }

    @Override
    public void onColumnSuccess(ColumnBean columnBean) {
        mainColumnView.onColumnSuccess(columnBean);
    }

    @Override
    public void onColumnFail(String str) {
        mainColumnView.onColumnFail(str);
    }

    @Override
    public void getColumn() {
        mainColumnModel.getColumn(this);
    }
}
