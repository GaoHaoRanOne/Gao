package gaohaoran.com.mvp_extracting_one.api;

import gaohaoran.com.mvp_extracting_one.bean.LoginBean;

public interface CallBack {

    void onSuccess(LoginBean loginBean);
    void onFail(String str);

}
