package gaohaoran.com.mvp_extracting_one.view;

import gaohaoran.com.mvp_extracting_one.base.BaseView;

public interface MainView extends BaseView {

    void setData(String str);

    String getUserName();
    String getPaw();

    void showToast(String msg);

}
