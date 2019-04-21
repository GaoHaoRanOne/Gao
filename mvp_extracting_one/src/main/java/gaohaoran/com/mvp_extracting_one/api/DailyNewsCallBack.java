package gaohaoran.com.mvp_extracting_one.api;

import gaohaoran.com.mvp_extracting_one.bean.DailyNewsBean;

public interface DailyNewsCallBack {

    void onDailyNewsSuccess(DailyNewsBean dailyNewsBean);
    void onDailyNewsFail(String str);

}
