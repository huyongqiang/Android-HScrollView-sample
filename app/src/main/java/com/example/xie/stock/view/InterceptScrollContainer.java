package com.example.xie.stock.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * 拦截父容器事件的布局
 */
public class InterceptScrollContainer extends LinearLayout {
    public InterceptScrollContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InterceptScrollContainer(Context context) {
        super(context);
    }

    /**
     * 拦截父容器的事件
     * @param ev
     * @return
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.i("pdwy", "ScrollContainer onInterceptTouchEvent");
        return true;

    }
}
