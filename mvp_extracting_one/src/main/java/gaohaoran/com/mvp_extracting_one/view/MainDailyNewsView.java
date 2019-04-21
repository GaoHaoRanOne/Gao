package gaohaoran.com.mvp_extracting_one.view;

import gaohaoran.com.mvp_extracting_one.bean.DailyNewsBean;

public interface MainDailyNewsView {

    void onDailyNewsSuccess(DailyNewsBean dailyNewsBean);
    void onDailyNewsFail(String str);

}
