package com.test.qinbaowei.statusbar;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.qbw.log.XLog;
import com.test.qinbaowei.statusbar.databinding.BottomDialogBinding;


/**
 * Created by Bond on 2017/01/14 11:30
 * you can contact me at qbaowei@qq.com
 */

public class BottomDialog extends Dialog {

    private Context mContext;

    private BottomDialogBinding mBinding;

    private Animation mEnterAnim;
    private Animation mExitAnim;

    public BottomDialog(Context context) {
        super(context, R.style.DialogTheme);
        mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.bind(LayoutInflater.from(mContext)
                                                      .inflate(R.layout.bottom_dialog, null));
        setContentView(mBinding.getRoot());
        Window window = getWindow();
        window.setWindowAnimations(0);
        window.setGravity(Gravity.BOTTOM);
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(layoutParams);
        mEnterAnim = AnimationUtils.loadAnimation(mContext, R.anim.enter);
        mExitAnim = AnimationUtils.loadAnimation(mContext, R.anim.exit);
        mExitAnim.setFillAfter(true);
    }

    /**
     * 5.0以上，设置状态栏颜色需要设置FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS，这个参数导致底部对话框向上移动时（前提是你设置了向上移动的动画）从虚拟按键的底部移出
     * 解决方法：不使用对话框配置动画的方式（setWindowAnimations（style）），设置对话框根布局动画
     */

    @Override
    public void show() {
        super.show();
        mEnterAnim.cancel();
        mExitAnim.cancel();
        mBinding.getRoot().startAnimation(mEnterAnim);
    }

    @Override
    public void dismiss() {
        XLog.i("in");
        mEnterAnim.cancel();
        mExitAnim.cancel();
        mExitAnim.setAnimationListener(mExitAnimListener);
        mBinding.getRoot().startAnimation(mExitAnim);
    }

    private Animation.AnimationListener mExitAnimListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {}

        @Override
        public void onAnimationEnd(Animation animation) {
            BottomDialog.super.dismiss();
        }

        @Override
        public void onAnimationRepeat(Animation animation) {}
    };
}
