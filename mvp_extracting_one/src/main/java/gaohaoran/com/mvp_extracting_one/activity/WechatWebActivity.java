package gaohaoran.com.mvp_extracting_one.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import gaohaoran.com.mvp_extracting_one.R;

public class WechatWebActivity extends AppCompatActivity {

    private ProgressBar prog;
    private WebView web;
    private String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wechatweb);
        initView();
        initData();
    }

    private void initData() {

        //进度条 +  详情页面
        WebSettings seting = web.getSettings();
        seting.setJavaScriptEnabled(true);//设置webview支持javascript脚本
        web.loadUrl(url);
        // 覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
        web.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });
        web.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                // TODO Auto-generated method stub
                if (newProgress == 100) {
                    // 网页加载完成
                    prog.setVisibility(View.GONE);//加载完网页进度条消失
                } else {
                    // 加载中
                    prog.setVisibility(View.VISIBLE);//开始加载网页时显示进度条
                    prog.setProgress(newProgress);//设置进度值
                }

            }
        });

    }

    private void initView() {
        prog = (ProgressBar) findViewById(R.id.prog);
        web = (WebView) findViewById(R.id.web);
        Intent intent = getIntent();
        intent.getStringExtra("url");
    }
}
