package gaohaoran.com.mvp_extracting_one.base;

import java.util.ArrayList;

public abstract class BasePresenter <V extends BaseView>{
    protected ArrayList<BaseModel> models = new ArrayList<>();
    protected V mView;

    public BasePresenter(){
        initModel();
    }
    protected abstract void initModel();

    public void bind(V view){

        this.mView=view;

    }
    public void onDestory(){
        mView = null;
        if (models.size()>0){
            for (BaseModel model : models){
                model.onDestory();
            }
        }
    }

}
