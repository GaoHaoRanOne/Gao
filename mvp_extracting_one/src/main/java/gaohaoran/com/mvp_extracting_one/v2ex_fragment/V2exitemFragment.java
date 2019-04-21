package gaohaoran.com.mvp_extracting_one.v2ex_fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import gaohaoran.com.mvp_extracting_one.R;
import gaohaoran.com.mvp_extracting_one.adapter.V2exAdapter;
import gaohaoran.com.mvp_extracting_one.base.BaseFragment;
import gaohaoran.com.mvp_extracting_one.base.BasePresenter;
import gaohaoran.com.mvp_extracting_one.bean.V2exBean;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class V2exitemFragment extends BaseFragment {


    @BindView(R.id.rlv)
    RecyclerView rlv;
    private View view;
    private Unbinder unbinder;

    private String ss;
    public String url = "https://www.v2ex.com/";
    private List<V2exBean> v2exBeans;
    private String img;
    private String text;
    private String title;
    private String tab;
    private String author;
    private String commentUser;
    private String text1;

    @SuppressLint("ValidFragment")
    public V2exitemFragment(String ss) {
        this.ss = ss;
    }

    @Override
    protected void initData() {
        v2exBeans = new ArrayList<>();
        getData();

    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_v2exitem;
    }

    private void getData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Document document = Jsoup.connect(url).get();
                    //所有的列表数据
                    Elements items = document.select("div.cell.item");
                    for (Element item : items) {
                        //图片
                        Elements images = item.select("table tbody tr td img.avatar");
                        if (images.size() > 0) {
                            img = images.get(0).attr("src");
                            Log.d("TAG", "图片: "+img);
                        }

                        //评论
                        Elements comment = item.select("table tr td a.count_livid");
                        if (comment.size() > 0) {
                            text = comment.get(0).text();
                            //Log.d(TAG, "评论: "+text);
                        }

                        //标题
                        Elements titles = item.select("table tr td span.item_title >a");
                        if (titles.size() > 0) {
                            title = titles.get(0).text();
                            //Log.d(TAG, "title: "+title);
                        }

                        //二类tab
                        Elements secondTabs = item.select("table tr td a.node");
                        if (secondTabs.size() > 0) {
                            tab = secondTabs.get(0).text();
                            //Log.d(TAG, "二类tab: "+tab);
                        }

                        Elements users = item.select("table tr td span.topic_info > strong > a");
                        if (users.size() > 0) {
                            author = users.get(0).text();
                            //Log.d(TAG, "作者:"+author);
                        }

                        if (users.size() > 1) {
                            commentUser = users.get(1).text();
                            //Log.d(TAG, "评论人:"+commentUser);
                        }

                        //时间
                        Elements time = item.select("table tr td span.topic_info");
                        if (time.size() > 0) {
                            text1 = time.get(0).text();
                            //Log.d(TAG, "time: "+text);
                        }
                        v2exBeans.add(new V2exBean(img, text, title, tab, author, commentUser, text1));
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (v2exBeans.size() > 0) {
                                    V2exAdapter v2exAdapter = new V2exAdapter(v2exBeans,getContext());
                                    rlv.setLayoutManager(new LinearLayoutManager(getContext()));
                                    rlv.setAdapter(v2exAdapter);
                                    v2exAdapter.notifyDataSetChanged();
                                }
                            }
                        });
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


}
