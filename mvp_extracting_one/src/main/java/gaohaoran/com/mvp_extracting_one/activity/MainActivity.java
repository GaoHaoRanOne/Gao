package gaohaoran.com.mvp_extracting_one.activity;


import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;


import com.miguelcatalan.materialsearchview.MaterialSearchView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import butterknife.BindView;
import gaohaoran.com.mvp_extracting_one.R;
import gaohaoran.com.mvp_extracting_one.adapter.WechatAdapter;
import gaohaoran.com.mvp_extracting_one.base.BaseActivity;
import gaohaoran.com.mvp_extracting_one.bean.SearchBean;
import gaohaoran.com.mvp_extracting_one.bean.WechatBean;
import gaohaoran.com.mvp_extracting_one.fragment.AboutFragment;
import gaohaoran.com.mvp_extracting_one.fragment.CollectFragment;
import gaohaoran.com.mvp_extracting_one.fragment.GankFragment;
import gaohaoran.com.mvp_extracting_one.fragment.GoldFragment;
import gaohaoran.com.mvp_extracting_one.fragment.SettingsFragment;
import gaohaoran.com.mvp_extracting_one.fragment.V2exFragment;
import gaohaoran.com.mvp_extracting_one.fragment.WeChatFragment;
import gaohaoran.com.mvp_extracting_one.fragment.ZhihuFragment;
import gaohaoran.com.mvp_extracting_one.presenter.MainPresenter;
import gaohaoran.com.mvp_extracting_one.view.MainView;

public class MainActivity extends BaseActivity<MainView,MainPresenter>implements MainView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fragment_container)
    FrameLayout frameLayout;
    @BindView(R.id.nv)
    NavigationView nv;
    @BindView(R.id.dl)
    DrawerLayout dl;
    @BindView(R.id.search_view)
    MaterialSearchView search_view;
    private ArrayList<Fragment> fragments;
    private ArrayList<Integer> titles;
    private FragmentManager manager;

    private final  int TYPE_ZHIHU = 0;
    private final  int TYPE_WECHAT = 1;
    private final  int TYPE_GANK = 2;
    private final  int TYPE_GOLD = 3;
    private final  int TYPE_V2EX = 4;
    private final  int TYPE_COLLECT = 5;
    private final  int TYPE_SETTINGS = 6;
    private final  int TYPE_ABOUT = 7;
    private int mLastFragmentPosition;
    private String mTitle;
    private MenuItem SearchItem;
    private ArrayList<WechatBean.NewslistBean> list;
    private ArrayList<WechatBean.NewslistBean> datas;
    private WechatAdapter adapter;
    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void setData(String str) {

    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public String getPaw() {
        return null;
    }

    @Override
    protected void initView() {
        manager = getSupportFragmentManager();
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,dl, toolbar, R.string.about, R.string.about);
        actionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        dl.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        //search_view.setSuggestions(getResources());

        initFragments();
        initTitles();
        addZhihuFragment();
        initToolBar();

    }

    private void initToolBar() {




    }

    private void addZhihuFragment() {

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fragment_container,fragments.get(0));
        transaction.commit();

        toolbar.setTitle(titles.get(0));

    }

    private void initTitles() {

        titles = new ArrayList<>();
        titles.add(R.id.zhihu);
        titles.add(R.id.wechat);
        titles.add(R.id.gank);
        titles.add(R.id.gold);
        titles.add(R.id.v2ex);
        titles.add(R.id.collect);
        titles.add(R.id.settings);
        titles.add(R.id.about);


    }

    private void initFragments() {

        fragments = new ArrayList<>();
        fragments.add(new ZhihuFragment());
        fragments.add(new WeChatFragment());
        fragments.add(new GankFragment());
        fragments.add(new GoldFragment());
        fragments.add(new V2exFragment());
        fragments.add(new CollectFragment());
        fragments.add(new SettingsFragment());
        fragments.add(new AboutFragment());

    }

    @Override
    protected void initListener() {
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId!= R.id.info_title && itemId!=R.id.options_title){
                    item.setChecked(true);

                    switch (itemId){
                        case R.id.zhihu:
                            switchFragment(TYPE_ZHIHU);
                            toolbar.setTitle(R.string.zhihu);
                            break;
                        case R.id.wechat:
                            switchFragment(TYPE_WECHAT);
                            toolbar.setTitle(R.string.wechat);
                            break;
                        case R.id.gank:
                            switchFragment(TYPE_GANK);
                            toolbar.setTitle(R.string.gank);
                            break;
                        case R.id.gold:
                            switchFragment(TYPE_GOLD);
                            toolbar.setTitle(R.string.gold);
                            break;
                        case R.id.v2ex:
                            switchFragment(TYPE_V2EX);
                            toolbar.setTitle(R.string.v2ex);
                            break;
                        case R.id.collect:
                            switchFragment(TYPE_COLLECT);
                            toolbar.setTitle(R.string.collect);
                            break;
                        case R.id.settings:
                            switchFragment(TYPE_SETTINGS);
                            toolbar.setTitle(R.string.settings);
                            break;
                        case R.id.about:
                            switchFragment(TYPE_ABOUT);
                            toolbar.setTitle(R.string.about);
                            break;

                    }
                    dl.closeDrawer(Gravity.LEFT);

                }else{
                    item.setChecked(false);
                }

                return false;
            }
        });
        search_view.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //按下搜索或者提交的时候回调,
                //ToastUtil.showShort("提交的内容:"+query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //搜索框内容发生改变的回调,
                //ToastUtil.showShort(newText);

                SearchBean searchBean = new SearchBean();
                searchBean.setTitle(newText);
                EventBus.getDefault().post(searchBean);

                return true;
            }
        });

        search_view.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                //搜索框展示
                //ToastUtil.showShort("展示");
            }

            @Override
            public void onSearchViewClosed() {
                //搜索框隐藏
                //ToastUtil.showShort("关闭");
            }
        });

    }

    private void switchFragment(int type) {
        //显示一个fragment隐藏一个fragment
        //显示
        Fragment fragment = fragments.get(type);
        //需要隐藏
        Fragment fragment1 = fragments.get(mLastFragmentPosition);
        FragmentTransaction transaction = manager.beginTransaction();
        if (!fragment.isAdded()){
            transaction.add(R.id.fragment_container,fragment);
        }
        transaction.hide(fragment1);
        transaction.show(fragment);
        transaction.commit();
        mLastFragmentPosition = type;


        //显示或者隐藏搜索框
        if (type == TYPE_WECHAT || type == TYPE_GANK){
            SearchItem.setVisible(true);
        }else{
            SearchItem.setVisible(false);
        }
    }

    @Override
    public void showToast(String msg) {

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu,menu);
        SearchItem = menu.findItem(R.id.action_search);
        //隐藏搜索栏
        SearchItem.setVisible(false);
        search_view.setMenuItem(SearchItem);

        return true;

    }
    //回退建点击回退
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (search_view.isSearchOpen()){
            search_view.closeSearch();
        }else{
            super.onBackPressed();
        }
    }
        //search_view.setVoiceSearch(true); //or false
}
