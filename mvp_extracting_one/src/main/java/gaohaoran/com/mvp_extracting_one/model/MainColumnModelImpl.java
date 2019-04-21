package gaohaoran.com.mvp_extracting_one.model;

import gaohaoran.com.mvp_extracting_one.api.ColumnCallBack;
import gaohaoran.com.mvp_extracting_one.api.ColumnService;
import gaohaoran.com.mvp_extracting_one.api.DailyNewsService;
import gaohaoran.com.mvp_extracting_one.bean.ColumnBean;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainColumnModelImpl implements MainColumnModel{
    @Override
    public void getColumn(final ColumnCallBack columnCallBack) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ColumnService.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ColumnService columnService = retrofit.create(ColumnService.class);
        Observable<ColumnBean> column = columnService.GetColumn();
        column.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ColumnBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ColumnBean columnBean) {
                        columnCallBack.onColumnSuccess(columnBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        columnCallBack.onColumnFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
