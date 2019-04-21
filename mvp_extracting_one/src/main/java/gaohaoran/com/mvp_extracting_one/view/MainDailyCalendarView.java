package gaohaoran.com.mvp_extracting_one.view;

import gaohaoran.com.mvp_extracting_one.bean.DailyCalendarBean;

public interface MainDailyCalendarView {

    void onDailyCalendarSuccess(DailyCalendarBean dailyCalendarBean);
    void onDailyCalendarFail(String str);

}
