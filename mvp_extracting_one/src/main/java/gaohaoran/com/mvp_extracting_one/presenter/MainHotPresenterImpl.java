package gaohaoran.com.mvp_extracting_one.presenter;

import gaohaoran.com.mvp_extracting_one.api.HotCallBack;
import gaohaoran.com.mvp_extracting_one.bean.HotBean;
import gaohaoran.com.mvp_extracting_one.model.MainHotModel;
import gaohaoran.com.mvp_extracting_one.view.MainHotView;

public class MainHotPresenterImpl implements MainHotPresenter,HotCallBack{
    private MainHotModel mainHotModel;
    private MainHotView mainHotView;

    public MainHotPresenterImpl(MainHotModel mainHotModel, MainHotView mainHotView) {
        this.mainHotModel = mainHotModel;
        this.mainHotView = mainHotView;
    }

    @Override
    public void onHotSuccess(HotBean hotBean) {
        mainHotView.onHotSuccess(hotBean);
    }

    @Override
    public void onHotFail(String str) {
        mainHotView.onHotFail(str);
    }

    @Override
    public void getHot() {
        mainHotModel.getHot(this);
    }
}
