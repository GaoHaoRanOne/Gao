package gaohaoran.com.mvp_extracting_one.utils;

import android.widget.Toast;

import gaohaoran.com.mvp_extracting_one.base.BaseApp;

public class ToastUtils {

    public static void showShort(String str){
        //避免内存泄漏的一个方法,用到上下文的地方,能用application的就application
        Toast.makeText(BaseApp.getInstance(), str, Toast.LENGTH_SHORT).show();
    }
    public static void showLong (String str){
        //避免内存泄漏的一个方法，用到上下文的地方，能用application的就application
        Toast.makeText(BaseApp.getInstance(), str, Toast.LENGTH_SHORT).show();
    }

}
