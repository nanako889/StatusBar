package com.test.qinbaowei.statusbar;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.qbw.bar.SystemBar;

/**
 * @author qinbaowei
 * @createtime 2017/05/04 14:47
 * @email qbaowei@qq.com
 * @description
 */


public class TestActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        SystemBar.setColor(this, true, android.R.color.white, true);
    }
}
