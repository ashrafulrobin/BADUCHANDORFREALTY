package com.example.ashra.badu_chandorfrealty;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by ashra on 12/26/2018.
 */

public class LoginFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     View view =inflater.inflate(R.layout.fragment_login,container,false);

        WebView webView = (WebView) view.findViewById(R.id.homeSaleWebViewId);


        webView.loadUrl("https://portal.phpbd.net/property-medium/?search_type=custom&property_type=for-sale");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient());

     return  view;
    }
}
