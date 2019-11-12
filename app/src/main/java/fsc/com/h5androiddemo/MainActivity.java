package fsc.com.h5androiddemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    JavaScript javaScript;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webview);
        javaScript = new JavaScript(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.loadUrl("file:///android_asset/javascript.html");
        webView.addJavascriptInterface(javaScript, "demo");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            String result = data.getStringExtra("edittext");
            webView.loadUrl("javascript:androidResult('" + result + "')");
        } else {
            webView.loadUrl("javascript:androidResult('没有返回值')");
        }
    }
}
