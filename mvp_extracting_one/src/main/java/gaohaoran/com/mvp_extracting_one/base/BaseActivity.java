package gaohaoran.com.mvp_extracting_one.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity <V extends BaseView,P extends BasePresenter>extends AppCompatActivity implements BaseView{


    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        presenter = initPresenter();
        if (presenter!=null){
            //直接强转不对,因为BaseActivity不作为页面展示,展示的都是他的子类,
            // 而子类必须实现BaseMvpView
            presenter.bind((V)this);
        }
        initView();
        initListener();
        initData();
    }

    protected void initData() {

    }

    protected void initListener() {

    }

    protected void initView() {

    }

    protected abstract P initPresenter();

    protected abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //切断V层和P层的联系
        presenter.onDestory();
        presenter = null;
    }
}
