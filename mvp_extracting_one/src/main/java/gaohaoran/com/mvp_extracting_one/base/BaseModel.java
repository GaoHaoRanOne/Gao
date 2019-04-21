package gaohaoran.com.mvp_extracting_one.base;

import io.reactivex.disposables.CompositeDisposable;

public class BaseModel {

    protected CompositeDisposable CompositeDisposable = new CompositeDisposable();
    public void onDestory() {
        CompositeDisposable.clear();
    }
}
