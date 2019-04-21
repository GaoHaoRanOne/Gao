package gaohaoran.com.mvp_extracting_one.model;

import java.util.HashMap;
import java.util.Map;

import gaohaoran.com.mvp_extracting_one.api.WechatCallBack;
import gaohaoran.com.mvp_extracting_one.api.WechatService;
import gaohaoran.com.mvp_extracting_one.bean.WechatBean;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainWechatModelImpl implements MainWechatModel{
    @Override
    public void getWechat(final WechatCallBack callBack,Map<String, Object> map) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(WechatService.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        WechatService wechatService = retrofit.create(WechatService.class);
        Observable<WechatBean> wechat = wechatService.getWechat(map);
        wechat.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WechatBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WechatBean wechatBean) {
                        callBack.onWechatSuccess(wechatBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onWechatFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getWord(final WechatCallBack callBack, Map<String, Object> map) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(WechatService.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        WechatService wechatService = retrofit.create(WechatService.class);
        Observable<WechatBean> wechat = wechatService.getWord(map);
        wechat.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WechatBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WechatBean wechatBean) {
                        callBack.onWechatSuccess(wechatBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onWechatFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
