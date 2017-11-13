package com.eastwinddc.sample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import android.widget.TextView;

/**
 * Created by ewinddc on 2017/10/30.
 */

public class TextViewActivity extends BaseActivity{
    private TextView plainView;
    private TextView htmlView;
    private TextView htmlFormatView;

    private TextView spanView;
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
        spanView = (TextView) findViewById(R.id.spanText);

        String text = getString(R.string.plain_text,"plain formatting");
        plainView.setText(text);
        htmlView.setText(R.string.html_text);
        text = getString(R.string.html_format_text, TextUtils.htmlEncode("html formatting"));
        htmlFormatView.setText(Html.fromHtml(text));

        text = "我们中国 is a span text which is just a test";
        SpannableStringBuilder ssb = new SpannableStringBuilder(text);
        ssb.setSpan(new ScaleXSpan(2.0f),0,5, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        ssb.setSpan(new ForegroundColorSpan(Color.RED),5,8,Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        ssb.setSpan(new RelativeSizeSpan(2.0f),9,13,Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        ssb.setSpan(new ForegroundColorSpan(Color.BLUE),14,text.length(),Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        spanView.setText(ssb);
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
