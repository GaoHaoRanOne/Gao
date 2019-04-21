package gaohaoran.com.mvp_extracting_one.api;

import gaohaoran.com.mvp_extracting_one.bean.ColumnBean;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ColumnService {

    String url = "http://news-at.zhihu.com/api/4/";
    @GET("sections")
    Observable<ColumnBean> GetColumn();

}
