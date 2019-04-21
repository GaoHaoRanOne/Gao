package gaohaoran.com.mvp_extracting_one.view;

import gaohaoran.com.mvp_extracting_one.bean.HotBean;

public interface MainHotView {

    void onHotSuccess(HotBean hotBean);
    void onHotFail(String str);

}
