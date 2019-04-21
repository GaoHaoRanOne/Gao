package gaohaoran.com.mvp_extracting_one.base;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

public class BaseApp extends Application{

    //默认不是夜间模式
    public static int mModel = AppCompatDelegate.MODE_NIGHT_NO;
    private static BaseApp mBaseApp;

    @Override
    public void onCreate() {
        super.onCreate();
        mBaseApp = this;
    }
    public static BaseApp getInstance(){
        return mBaseApp;
    }
}
