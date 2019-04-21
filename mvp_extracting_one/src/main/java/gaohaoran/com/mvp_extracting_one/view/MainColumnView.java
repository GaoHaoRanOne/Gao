package gaohaoran.com.mvp_extracting_one.view;

import gaohaoran.com.mvp_extracting_one.bean.ColumnBean;

public interface MainColumnView {

    void onColumnSuccess(ColumnBean columnBean);
    void onColumnFail(String str);

}
