package gaohaoran.com.mvp_extracting_one.view;

import gaohaoran.com.mvp_extracting_one.bean.WechatBean;

public interface MainWechatView {
    void onWechatSuccess(WechatBean wechatBean);
    void onWordSuccess(WechatBean wechatBean);
    void onWechatFail(String str);
}
