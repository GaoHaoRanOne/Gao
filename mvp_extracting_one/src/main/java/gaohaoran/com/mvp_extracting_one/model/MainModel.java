package gaohaoran.com.mvp_extracting_one.model;

import android.service.carrier.CarrierMessagingService;

import gaohaoran.com.mvp_extracting_one.api.CallBack;
import gaohaoran.com.mvp_extracting_one.api.MyService;
import gaohaoran.com.mvp_extracting_one.base.BaseModel;
import gaohaoran.com.mvp_extracting_one.bean.LoginBean;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModel extends BaseModel{

    public void login(String name, String paw, final CallBack callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(MyService.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        MyService myService = retrofit.create(MyService.class);
        Observable<LoginBean> login = myService.login(name, paw);
        login.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        callback.onSuccess(loginBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
