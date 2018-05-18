package com.umeng.soexample.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.soexample.R;

import java.util.Map;

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
    private SHARE_MEDIA mType;

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
                mType=SHARE_MEDIA.QQ;
                UMShareAPI.get(mContext).getPlatformInfo(LoginActivity.this, mType, authListener);
                break;
            case R.id.login_wechat:
                //微信登录
                mType=SHARE_MEDIA.WEIXIN;
                UMShareAPI.get(mContext).getPlatformInfo(LoginActivity.this, mType, authListener);
                break;
            case R.id.login_sina:
                //新浪登录
                mType=SHARE_MEDIA.SINA;
                UMShareAPI.get(mContext).getPlatformInfo(LoginActivity.this, mType, authListener);
                break;
            case R.id.login_twitter:
                //Twitter登录
                mType=SHARE_MEDIA.TWITTER;
                UMShareAPI.get(mContext).getPlatformInfo(LoginActivity.this, mType, authListener);
                break;
            case R.id.login_exit:
                //删除授权
                UMShareAPI.get(mContext).deleteOauth(LoginActivity.this, mType, authListener);
                break;
        }
    }

    /**
     * 授权监听
     */
    private UMAuthListener authListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            Toast.makeText(mContext, "开始了", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            if (data!=null) {
                //用户昵称
                String name=data.get("name");
                //唯一标识
                String uid=data.get("uid");
                //性别
                String gender=data.get("gender");
                //头像
                String iconurl=data.get("iconurl");
                //token
                String access_token=data.get("access_token");
                Log.e("CXP","用户昵称："+name+"\n唯一标识："+uid+"\n性别："+gender+"\n头像："+iconurl+"\naccess_token："+access_token);
                Toast.makeText(mContext, "\n成功了\n用户昵称："+name+"\n唯一标识："+uid+"\n性别："+gender+"\n头像："+iconurl+"\naccess_token："+access_token, Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText(mContext, "失败：" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(mContext, "取消了", Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        UMShareAPI.get(this).release();
    }

    //页面跳转
    public static void startActivity(Context context){
        Intent intent=new Intent(context,LoginActivity.class);
        context.startActivity(intent);
    }
}
