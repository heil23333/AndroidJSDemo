package fsc.com.h5androiddemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.webkit.JavascriptInterface;

public class JavaScript {
    Activity context;

    public JavaScript(Activity context) {
        this.context = context;
    }

    @JavascriptInterface
    public void startActivity() {
        context.startActivityForResult(new Intent(context, SecondActivity.class), 100);
    }
}
