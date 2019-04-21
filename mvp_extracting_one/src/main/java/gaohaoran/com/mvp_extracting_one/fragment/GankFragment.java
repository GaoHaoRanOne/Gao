package gaohaoran.com.mvp_extracting_one.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gaohaoran.com.mvp_extracting_one.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GankFragment extends Fragment {


    public GankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_gank, container, false);
        return inflate;
    }

}
