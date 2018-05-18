package com.cxp.share.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.cxp.share.R;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;

/**
 * 文 件 名: LoginActivity
 * 创 建 人: CXP
 * 创建日期: 2018-05-10 10:22
 * 描    述: 登录页面
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class LoginActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mContext=this;
    }

    public void clickLis(View view) {
        switch (view.getId()) {
            case R.id.login_qq:
                //QQ登录
                LoginUtils.qqLogin(mPlatformActionListener);
                break;
            case R.id.login_wechat:
                //微信登录
                LoginUtils.wechatLogin(mPlatformActionListener);
                break;
            case R.id.login_sina:
                //新浪登录
                LoginUtils.sinaWeiboLogin(mPlatformActionListener);
                break;
            case R.id.login_twitter:
                //Twitter登录
                LoginUtils.twitterLogin(mPlatformActionListener);
                break;
        }
    }

    /**
     * 授权监听
     */
    private PlatformActionListener mPlatformActionListener = new PlatformActionListener() {

        @Override
        public void onError(Platform plat, int arg1, Throwable arg2) {
            // 删除授权
            plat.removeAccount(true);
            //授权失败
            Toast.makeText(mContext,"授权失败",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onComplete(final Platform plat, int arg1, HashMap<String, Object> arg2) {
            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    Log.e("CXP","\nnickName："+plat.getDb().getUserName()+"\nheadImage："+plat.getDb().getUserIcon()+"\nuniqueid："+plat.getDb().getUserId());
                    if (plat.getDb().getUserId() != null) {
                        //登录成功
                        Toast.makeText(mContext,"登录成功",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        @Override
        public void onCancel(Platform plat, int arg1) {
            //删除授权
            plat.removeAccount(true);
            //取消授权
            Toast.makeText(mContext,"取消授权",Toast.LENGTH_SHORT).show();
        }
    };



    //页面跳转
    public static void startActivity(Context context){
        Intent intent=new Intent(context,LoginActivity.class);
        context.startActivity(intent);
    }
}
