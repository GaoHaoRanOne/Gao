package gaohaoran.com.mvp_extracting_one.api;

import gaohaoran.com.mvp_extracting_one.bean.WechatBean;

public interface WechatCallBack {

    void onWechatSuccess(WechatBean wechatBean);
    void onWordSuccess(WechatBean wechatBean);
    void onWechatFail(String str);

}
