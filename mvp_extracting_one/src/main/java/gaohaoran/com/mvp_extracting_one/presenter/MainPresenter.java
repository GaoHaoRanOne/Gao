package gaohaoran.com.mvp_extracting_one.presenter;

import android.text.TextUtils;


import gaohaoran.com.mvp_extracting_one.api.CallBack;
import gaohaoran.com.mvp_extracting_one.base.BasePresenter;
import gaohaoran.com.mvp_extracting_one.bean.LoginBean;
import gaohaoran.com.mvp_extracting_one.model.MainModel;
import gaohaoran.com.mvp_extracting_one.utils.Logger;
import gaohaoran.com.mvp_extracting_one.view.MainView;

public class MainPresenter extends BasePresenter<MainView>{
    private static final String TAG = "MainPresenter";
    private MainModel mainModel;
    public void getData(){
        //获取数据，假设数据从网络来的
        String data = "网络回来的数据";
        if (mView !=null){
            mView.setData(data);
        }
    }

    public void login(){
        String name = mView.getUserName();
        String paw = mView.getPaw();
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(paw)){
            mView.showToast("用户名或密码不能为空");
            return;
        }

        mainModel.login(name, paw, new CallBack() {


            @Override
            public void onSuccess(LoginBean loginBean) {
                if (loginBean != null){
                    Logger.logD(TAG,loginBean.toString());
                    if (loginBean.getCode() == 200){
                        //防止页面销毁,数据返回后设置页面的时空指针
                        if (mView !=null){
                            mView.showToast("登陆成功");
                        }
                    }else{
                        if (mView != null){
                            mView.showToast("登陆失败");
                        }
                    }
                }
            }
            @Override
            public void onFail(String str) {
                Logger.logD(TAG,str);
                if (mView !=null){
                    mView.showToast("登陆失败");
                }
            }
        });

    }

    @Override
    protected void initModel() {
        MainModel mainModel = new MainModel();
        models.add(mainModel);
    }
}
