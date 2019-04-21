package gaohaoran.com.mvp_extracting_one.model;

import gaohaoran.com.mvp_extracting_one.api.HotCallBack;
import gaohaoran.com.mvp_extracting_one.api.HotService;
import gaohaoran.com.mvp_extracting_one.bean.HotBean;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainHotModelImpl implements MainHotModel{
    @Override
    public void getHot(final HotCallBack callBack) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(HotService.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        HotService hotService = retrofit.create(HotService.class);
        Observable<HotBean> hot = hotService.GetHot();
        hot.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HotBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HotBean hotBean) {
                        callBack.onHotSuccess(hotBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onHotFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
