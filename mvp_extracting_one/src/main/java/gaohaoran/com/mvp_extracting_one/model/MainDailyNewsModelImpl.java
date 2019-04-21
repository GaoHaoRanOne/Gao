package gaohaoran.com.mvp_extracting_one.model;

import gaohaoran.com.mvp_extracting_one.api.DailyNewsCallBack;
import gaohaoran.com.mvp_extracting_one.api.DailyNewsService;
import gaohaoran.com.mvp_extracting_one.api.MyService;
import gaohaoran.com.mvp_extracting_one.bean.DailyNewsBean;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainDailyNewsModelImpl implements MainDailyNewsModel{
    @Override
    public void getDailyNews(final DailyNewsCallBack callBack) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(DailyNewsService.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        DailyNewsService dailyNewsService = retrofit.create(DailyNewsService.class);
        Observable<DailyNewsBean> dailyNews = dailyNewsService.getDailyNews();
        dailyNews.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DailyNewsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DailyNewsBean dailyNewsBean) {
                        callBack.onDailyNewsSuccess(dailyNewsBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onDailyNewsFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
