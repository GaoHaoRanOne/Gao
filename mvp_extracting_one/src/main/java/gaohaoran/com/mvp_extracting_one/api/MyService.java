package gaohaoran.com.mvp_extracting_one.api;

import gaohaoran.com.mvp_extracting_one.bean.LoginBean;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface MyService {

    String url = "http://yun918.cn/study/public/index.php/";
    @FormUrlEncoded
    @POST("login")
    Observable<LoginBean> login(@Field("username") String name,
                                @Field("password") String psd);

}
