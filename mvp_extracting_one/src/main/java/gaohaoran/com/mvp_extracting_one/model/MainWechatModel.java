package gaohaoran.com.mvp_extracting_one.model;

import java.util.Map;

import gaohaoran.com.mvp_extracting_one.api.WechatCallBack;

public interface MainWechatModel {

    void getWechat(WechatCallBack callBack, Map<String,Object> map);
    void getWord(WechatCallBack callBack, Map<String,Object> map);


}
