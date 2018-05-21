package cn.sharesdk.demo.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.HashMap;

import cn.sharesdk.demo.R;
import cn.sharesdk.facebook.Facebook;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.twitter.Twitter;
import cn.sharesdk.wechat.friends.Wechat;

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
    private Platform mPlatform;

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
                mPlatform= ShareSDK.getPlatform(QQ.NAME);
                LoginUtils.authorize(mContext,mPlatform,mAuthorizeListener);
                break;
            case R.id.login_wechat:
                //微信登录
                mPlatform= ShareSDK.getPlatform(Wechat.NAME);
                LoginUtils.authorize(mContext,mPlatform,mAuthorizeListener);
                break;
            case R.id.login_sina:
                //新浪登录
                mPlatform= ShareSDK.getPlatform(SinaWeibo.NAME);
                LoginUtils.authorize(mContext,mPlatform,mAuthorizeListener);
                break;
            case R.id.login_facebook:
                //Facebook登录
                mPlatform= ShareSDK.getPlatform(Facebook.NAME);
                LoginUtils.authorize(mContext,mPlatform,mAuthorizeListener);
                break;
            case R.id.login_twitter:
                //Twitter登录
                mPlatform= ShareSDK.getPlatform(Twitter.NAME);
                LoginUtils.authorize(mContext,mPlatform,mAuthorizeListener);
                break;
            case R.id.login_exit:
                //删除授权
                mPlatform.removeAccount(true);
                break;
        }
    }


    private LoginUtils.AuthorizeListener mAuthorizeListener=new LoginUtils.AuthorizeListener() {
        @Override
        public void onSuccess(Platform arg0, int arg1, HashMap<String, Object> arg2) {
            Log.e("CXP","昵称："+arg0.getDb().getUserName()+"\nuid："+ arg0.getDb().getUserId()+"\n性别："+ arg0.getDb().getUserGender()+
            "\ntoken："+arg0.getDb().getToken()+"\n头像："+arg0.getDb().getUserIcon());
            Toast.makeText(mContext, "昵称："+arg0.getDb().getUserName()+"\nuid："+ arg0.getDb().getUserId()+"\n性别："+ arg0.getDb().getUserGender()+
                    "\ntoken："+arg0.getDb().getToken()+"\n头像："+arg0.getDb().getUserIcon(),Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onFaild() {
            mPlatform.removeAccount(true);
        }
    };

    //页面跳转
    public static void startActivity(Context context){
        Intent intent=new Intent(context,LoginActivity.class);
        context.startActivity(intent);
    }
}
