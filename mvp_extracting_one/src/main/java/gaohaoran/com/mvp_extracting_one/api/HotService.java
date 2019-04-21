package gaohaoran.com.mvp_extracting_one.api;


import gaohaoran.com.mvp_extracting_one.bean.HotBean;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface HotService {

    String url = "http://news-at.zhihu.com/api/4/";
    @GET("news/hot")
    Observable<HotBean> GetHot();

}
