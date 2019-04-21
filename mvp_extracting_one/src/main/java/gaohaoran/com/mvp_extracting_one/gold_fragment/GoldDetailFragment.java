package gaohaoran.com.mvp_extracting_one.gold_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import gaohaoran.com.mvp_extracting_one.R;
import gaohaoran.com.mvp_extracting_one.base.BaseFragment;
import gaohaoran.com.mvp_extracting_one.base.Constants;
import gaohaoran.com.mvp_extracting_one.presenter.EmptyPresenter;
import gaohaoran.com.mvp_extracting_one.view.EmptyView;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoldDetailFragment extends BaseFragment<EmptyView,EmptyPresenter>
        implements EmptyView {


    private View view;
    /**
     * 关于
     */
    private TextView tv;

    public GoldDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_golddetail, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        tv = (TextView) inflate.findViewById(R.id.tv);
    }
    /**
     *
     * @param text 简单文本
     * @return
     */
    public static GoldDetailFragment newInstance(String text){
        GoldDetailFragment fragment = new GoldDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.DATA,text);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_golddetail;
    }

    @Override
    protected void initView() {
        Bundle arguments = getArguments();
        String data = arguments.getString(Constants.DATA);
        tv.setText(data);
    }

    @Override
    protected EmptyPresenter initPresenter() {
        return new EmptyPresenter();
    }
}
