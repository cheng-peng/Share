package com.cxp.share.share;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.cxp.share.R;

import java.util.HashMap;

import cn.sharesdk.facebook.Facebook;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.twitter.Twitter;

/**
 * 文 件 名: ShareActivity
 * 创 建 人: CXP
 * 创建日期: 2018-05-10 10:22
 * 描    述: 分享页面
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class ShareActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        mContext=this;
    }

    public void clickLis(View view) {
        ShareUtils.IMG_PATH = "http://www.cxp521.com/imaes.jpg";
        ShareUtils.URL = "http://www.cxp521.com/";
        ShareUtils.CONTENT = "内容。";
        switch (view.getId()) {
            case R.id.share_qq:
                //QQ分享
                ShareUtils.qqShare(mPlatformActionListener);
                break;
            case R.id.share_qzone:
                //Qzone分享
                ShareUtils.qzoneShare(mPlatformActionListener);
                break;
            case R.id.share_sms:
                //短信分享
                ShareUtils.smsShare(mPlatformActionListener);
                break;
            case R.id.share_facebook:
                //FaceBook分享
                ShareUtils.faceBookShare(mPlatformActionListener);
                break;
            case R.id.share_twitter:
                //Twitter分享
                ShareUtils.twitterShare(mPlatformActionListener);
                break;
        }
    }

    //分享回调
    private PlatformActionListener mPlatformActionListener = new PlatformActionListener() {
        @Override
        public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {

            //FaceBook 成功失败都走成功回到，所以成功失败都不做处理
            if (!platform.getName().equals(Facebook.NAME)) {
                if (platform.getName().equals(Twitter.NAME)) {
                    ShareActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(mContext,"分享成功",Toast.LENGTH_SHORT).show();
                        }
                    });
                }else{
                    Toast.makeText(mContext,"分享成功",Toast.LENGTH_SHORT).show();
                }
            }

        }

        @Override
        public void onError(Platform platform, int i, Throwable throwable) {
            Toast.makeText(mContext,"分享失败",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(Platform platform, int i) {
            Toast.makeText(mContext,"分享取消",Toast.LENGTH_SHORT).show();
        }
    };


    //页面跳转
    public static void startActivity(Context context){
        Intent intent=new Intent(context,ShareActivity.class);
        context.startActivity(intent);
    }
}
