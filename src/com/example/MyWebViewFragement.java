package com.example;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewFragment;
import android.widget.Toast;

public class MyWebViewFragement extends WebViewFragment {
    private String mUrl;

    public MyWebViewFragement(String url) {
        super();
        mUrl = url;
    }

    @Override
    public void onStart() {
        super.onStart();
        WebView webView = getWebView();

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    Toast.makeText(getActivity(), "fragment: " + motionEvent.getX() + " - " + motionEvent.getY(), Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

        webView.loadUrl(mUrl);
    }
}
