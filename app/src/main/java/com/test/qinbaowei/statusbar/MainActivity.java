package com.test.qinbaowei.statusbar;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.qbw.bar.SystemBar;
import com.qbw.log.XLog;
import com.test.qinbaowei.statusbar.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private boolean mLightStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SystemBar.setColor(MainActivity.this.getWindow(),
                           true,
                           android.R.color.holo_purple,
                           mLightStatus,
                           true,
                           android.R.color.holo_red_dark,
                           mLightStatus);
        setContentView(R.layout.activity_main);
        XLog.setEnabled(true);
        ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this,
                                                                         R.layout.activity_main);
        mainBinding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLightStatus = !mLightStatus;
                SystemBar.setStatusLight(MainActivity.this.getWindow(), mLightStatus);
                SystemBar.setNavigationLight(MainActivity.this.getWindow(), mLightStatus);
            }
        });
    }
}
