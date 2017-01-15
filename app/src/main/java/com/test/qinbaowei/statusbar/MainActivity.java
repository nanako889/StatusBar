package com.test.qinbaowei.statusbar;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.qbw.barcolor.SystemBar;
import com.qbw.log.XLog;
import com.test.qinbaowei.statusbar.databinding.ActivityMainBinding;

public class MainActivity extends Activity {

    private BottomDialog mBottomDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        XLog.setEnabled(true);
        mBottomDialog = new BottomDialog(this);
        ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        SystemBar.setColor(this, true, R.color.colorPrimaryDark);
        mainBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBottomDialog.show();
            }
        });
    }
}
