package luyao.everything.base;

import android.annotation.SuppressLint;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.BindView;
import luyao.everything.R;

/**
 * Created by Lu
 * on 2016/11/23 11:59.
 */

public abstract class BaseWebViewActivity extends BaseActivity {

    @BindView(R.id.webView)
    protected WebView webView;

//    @BindView(R.id.progressBar)
//    ProgressBar mProgressBar;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_webview;
    }


    @Override
    protected void initView() {
        initWebView();
    }

    @Override
    protected void initData() {

    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initWebView() {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setGeolocationEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);

        webView.setWebViewClient(new WebViewClient() {


            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }

        });

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
//                mProgressBar.setProgress(newProgress);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}

