package gaohaoran.com.mvp_extracting_one.presenter;

import gaohaoran.com.mvp_extracting_one.api.DailyNewsCallBack;
import gaohaoran.com.mvp_extracting_one.bean.DailyNewsBean;
import gaohaoran.com.mvp_extracting_one.model.MainDailyNewsModel;
import gaohaoran.com.mvp_extracting_one.view.MainDailyNewsView;

public class MainDailyNewsPresenterImpl implements MainDailyNewsPresenter,DailyNewsCallBack{
    private MainDailyNewsModel mainDailyNewsModel;
    private MainDailyNewsView mainDailyNewsView;

    public MainDailyNewsPresenterImpl(MainDailyNewsModel mainDailyNewsModel, MainDailyNewsView mainDailyNewsView) {
        this.mainDailyNewsModel = mainDailyNewsModel;
        this.mainDailyNewsView = mainDailyNewsView;
    }

    @Override
    public void onDailyNewsSuccess(DailyNewsBean dailyNewsBean) {
        mainDailyNewsView.onDailyNewsSuccess(dailyNewsBean);
    }

    @Override
    public void onDailyNewsFail(String str) {
        mainDailyNewsView.onDailyNewsFail(str);
    }

    @Override
    public void getDailyNews() {
        mainDailyNewsModel.getDailyNews(this);
    }
}
