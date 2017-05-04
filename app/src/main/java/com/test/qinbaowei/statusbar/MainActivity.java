package com.test.qinbaowei.statusbar;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.qbw.bar.SystemBar;
import com.qbw.log.XLog;
import com.test.qinbaowei.statusbar.databinding.ActivityMainBinding;

public class MainActivity extends Activity {

    private BottomDialog mBottomDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SystemBar.setColor(this, true, R.color.colorPrimaryDark);
        setContentView(R.layout.activity_main);
        XLog.setEnabled(true);
        mBottomDialog = new BottomDialog(this);
        ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBottomDialog.show();
            }
        });
        mainBinding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TestActivity.class));
            }
        });
    }
}
