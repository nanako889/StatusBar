package com.qbw.bar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

/**
 * Author：qbw on 2019/3/22 17:16
 */
public class StatusBarPlaceHolderView extends View {

    private int extraHeight;

    public StatusBarPlaceHolderView(Context context) {
        super(context);
        init(context, null);
    }

    public StatusBarPlaceHolderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public StatusBarPlaceHolderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                                                               R.styleable.StatusBarPlaceHolderView);
        extraHeight = (int) typedArray.getDimension(R.styleable.StatusBarPlaceHolderView_sb_extra_height,
                                                    0);
        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int sh = getStatusHeight(getContext());
        super.onMeasure(widthMeasureSpec,
                        MeasureSpec.makeMeasureSpec(sh + extraHeight, MeasureSpec.EXACTLY));
    }

    public static int getStatusHeight(Context context) {
        int statusHeight = (int) dp2px(context, 24);
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("status_bar_height")
                                               .get(object)
                                               .toString());
            statusHeight = context.getResources().getDimensionPixelSize(height);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return statusHeight;
    }

    public static float dp2px(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return dp * scale + 0.5f;
    }
}
