package gaohaoran.com.mvp_extracting_one.model;

import gaohaoran.com.mvp_extracting_one.api.DailyCalendarCallBack;

public interface MainDailyCalendarModel {


    void getDailyCalendar(String url,DailyCalendarCallBack callBack);

}
