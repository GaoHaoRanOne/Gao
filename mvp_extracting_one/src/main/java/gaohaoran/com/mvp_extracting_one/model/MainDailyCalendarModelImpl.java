package gaohaoran.com.mvp_extracting_one.model;

import gaohaoran.com.mvp_extracting_one.api.DailyCalendarCallBack;
import gaohaoran.com.mvp_extracting_one.api.DailyCalendarService;
import gaohaoran.com.mvp_extracting_one.bean.DailyCalendarBean;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainDailyCalendarModelImpl implements MainDailyCalendarModel{
    @Override
    public void getDailyCalendar(String url, final DailyCalendarCallBack callBack) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(DailyCalendarService.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        DailyCalendarService dailyCalendarService = retrofit.create(DailyCalendarService.class);
        Observable<DailyCalendarBean> dailyCalendar = dailyCalendarService.getDailyCalendar(url);
        dailyCalendar.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DailyCalendarBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DailyCalendarBean dailyCalendarBean) {
                        callBack.onDailyCalendarSuccess(dailyCalendarBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onDailyCalendarFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
