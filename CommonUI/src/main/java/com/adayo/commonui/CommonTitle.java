package com.adayo.commonui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.adayo.commonui.R;

/**
 * Created by admin on 2018/9/18.
 */

public class CommonTitle extends LinearLayout {

    private ImageView imageView;
    private TextView textView;
    private LinearLayout linearLayout;

    public CommonTitle(Context context) {
        super(context);
    }

    public CommonTitle(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.title_bar, null, false);
        addView(view);
        imageView = view.findViewById(R.id.iv_title);
        textView = view.findViewById(R.id.tv_title);
        linearLayout = view.findViewById(R.id.ll_title);
    }

    /**
     *
     * @param resId 设置图片背景
     */
    public void setBackground(int resId) {
        imageView.setBackgroundResource(resId);
    }

    /**
     *
     * @param isShow 是否显示小图标
     */
    public void isShowImageView(boolean isShow) {
        if (isShow) {
            imageView.setVisibility(VISIBLE);
        } else {
            imageView.setVisibility(GONE);
        }
    }

    /**
     * title 名字
     * @param title
     */
    public void setTitle(String title) {
        textView.setText(title);
    }


}
