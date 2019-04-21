package gaohaoran.com.mvp_extracting_one.utils;

import android.util.Log;

import gaohaoran.com.mvp_extracting_one.base.Constants;

public class Logger {

    public static void logD(String tag,String str){
        if (Constants.isDebug){
            Log.d(tag, "logD: "+str );
        }
    }

}
