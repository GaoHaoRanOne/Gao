package gaohaoran.com.mvp_extracting_one.api;

import gaohaoran.com.mvp_extracting_one.bean.DailyNewsBean;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface DailyNewsService {

    String url = "http://news-at.zhihu.com/api/4/";

    @GET("news/latest")
    Observable<DailyNewsBean> getDailyNews();

}
