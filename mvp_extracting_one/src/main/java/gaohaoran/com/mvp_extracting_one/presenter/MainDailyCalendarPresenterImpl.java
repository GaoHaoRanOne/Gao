package gaohaoran.com.mvp_extracting_one.presenter;

import gaohaoran.com.mvp_extracting_one.api.DailyCalendarCallBack;
import gaohaoran.com.mvp_extracting_one.bean.DailyCalendarBean;
import gaohaoran.com.mvp_extracting_one.model.MainDailyCalendarModel;
import gaohaoran.com.mvp_extracting_one.view.MainDailyCalendarView;

public class MainDailyCalendarPresenterImpl implements MainDailyCalendarPresenter,DailyCalendarCallBack{

    private MainDailyCalendarModel mainDailyCalendarModel;
    private MainDailyCalendarView mainDailyCalendarView;

    public MainDailyCalendarPresenterImpl(MainDailyCalendarModel mainDailyCalendarModel, MainDailyCalendarView mainDailyCalendarView) {
        this.mainDailyCalendarModel = mainDailyCalendarModel;
        this.mainDailyCalendarView = mainDailyCalendarView;
    }

    @Override
    public void onDailyCalendarSuccess(DailyCalendarBean dailyCalendarBean) {
        mainDailyCalendarView.onDailyCalendarSuccess(dailyCalendarBean);
    }

    @Override
    public void onDailyCalendarFail(String str) {
        mainDailyCalendarView.onDailyCalendarFail(str);
    }

    @Override
    public void getDailyCalendar(String url) {
        mainDailyCalendarModel.getDailyCalendar(url,this);
    }
}
