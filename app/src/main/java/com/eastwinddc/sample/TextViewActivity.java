package com.eastwinddc.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.text.TextUtils;
import android.widget.TextView;

/**
 * Created by ewinddc on 2017/10/30.
 */

public class TextViewActivity extends BaseActivity{
    private TextView plainView;
    private TextView htmlView;
    private TextView htmlFormatView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_text_view;
    }

    @Override
    protected void initViews() {
        super.initViews();
        plainView = (TextView) findViewById(R.id.plainText);
        htmlView = (TextView) findViewById(R.id.htmlText);
        htmlFormatView = (TextView) findViewById(R.id.htmlArguText);

        String text = getString(R.string.plain_text,"plain formatting");
        plainView.setText(text);
        htmlView.setText(R.string.html_text);
        text = getString(R.string.html_format_text, TextUtils.htmlEncode("html formatting"));
        htmlFormatView.setText(Html.fromHtml(text));
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
