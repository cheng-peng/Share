package com.cxp.share;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cxp.share.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext=this;
    }

    public void clickLis(View view) {
        switch (view.getId()) {
            case R.id.main_login:
                //登录
                LoginActivity.startActivity(mContext);
                break;
            case R.id.main_share:
                //分享
//                ShareActivity.startActivity(mContext);
                break;
        }
    }

}
