package gaohaoran.com.mvp_extracting_one.api;

import gaohaoran.com.mvp_extracting_one.bean.DailyCalendarBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface DailyCalendarService {

    String url = "http://news-at.zhihu.com/api/4/";
    @GET()
    Observable<DailyCalendarBean> getDailyCalendar(@Url String url);
}
