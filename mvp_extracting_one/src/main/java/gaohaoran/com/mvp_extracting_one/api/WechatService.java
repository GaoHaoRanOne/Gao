package gaohaoran.com.mvp_extracting_one.api;

import java.util.Map;

import gaohaoran.com.mvp_extracting_one.bean.WechatBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface WechatService {

    String url = "http://api.tianapi.com/wxnew/";
    @GET("?")
    Observable<WechatBean> getWechat(@QueryMap Map<String,Object> map);

    Observable<WechatBean> getWord(@QueryMap Map<String,Object> map);

}
