package gaohaoran.com.mvp_extracting_one.api;

import gaohaoran.com.mvp_extracting_one.bean.HotBean;

public interface HotCallBack {

    void onHotSuccess(HotBean hotBean);
    void onHotFail(String str);

}
