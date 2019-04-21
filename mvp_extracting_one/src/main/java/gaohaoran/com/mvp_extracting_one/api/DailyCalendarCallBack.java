package gaohaoran.com.mvp_extracting_one.api;

import gaohaoran.com.mvp_extracting_one.bean.DailyCalendarBean;

public interface DailyCalendarCallBack {


    void onDailyCalendarSuccess(DailyCalendarBean dailyCalendarBean);
    void onDailyCalendarFail(String str);

}
