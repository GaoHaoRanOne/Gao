package gaohaoran.com.mvp_extracting_one.api;

import gaohaoran.com.mvp_extracting_one.bean.ColumnBean;

public interface ColumnCallBack {

    void onColumnSuccess(ColumnBean columnBean);
    void onColumnFail(String str);

}
