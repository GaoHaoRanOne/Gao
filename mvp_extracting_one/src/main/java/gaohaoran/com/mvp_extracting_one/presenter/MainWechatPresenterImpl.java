package gaohaoran.com.mvp_extracting_one.presenter;

import java.util.Map;

import gaohaoran.com.mvp_extracting_one.api.WechatCallBack;
import gaohaoran.com.mvp_extracting_one.bean.WechatBean;
import gaohaoran.com.mvp_extracting_one.model.MainWechatModel;
import gaohaoran.com.mvp_extracting_one.view.MainWechatView;

public class MainWechatPresenterImpl implements MainWechatPresenter,WechatCallBack{
    private MainWechatModel mainWechatModel;
    private MainWechatView mainWechatView;

    public MainWechatPresenterImpl(MainWechatModel mainWechatModel, MainWechatView mainWechatView) {
        this.mainWechatModel = mainWechatModel;
        this.mainWechatView = mainWechatView;
    }

    @Override
    public void onWechatSuccess(WechatBean wechatBean) {
        mainWechatView.onWechatSuccess(wechatBean);
    }

    @Override
    public void onWordSuccess(WechatBean wechatBean) {
        mainWechatView.onWordSuccess(wechatBean);
    }

    @Override
    public void onWechatFail(String str) {
        mainWechatView.onWechatFail(str);
    }

    @Override
    public void getWechat(Map<String, Object> map) {
        mainWechatModel.getWechat(this,map);
    }

    @Override
    public void getWord(Map<String, Object> map) {
        mainWechatModel.getWord(this,map);
    }
}
