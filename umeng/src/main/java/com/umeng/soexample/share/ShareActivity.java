package com.umeng.soexample.share;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.soexample.R;


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


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

    }

    public void clickLis(View view) {
        ShareUtils.IMG_PATH = "http://www.cxp521.com/imaes.jpg";
        ShareUtils.URL = "http://www.cxp521.com/";
        ShareUtils.CONTENT = "内容。";
        switch (view.getId()) {
            case R.id.share_qq:
                //QQ分享
                ShareUtils.shareUrl(ShareActivity.this, SHARE_MEDIA.QQ,shareListener);
                break;
            case R.id.share_qzone:
                //Qzone分享
                ShareUtils.shareUrl(ShareActivity.this, SHARE_MEDIA.QZONE,shareListener);
                break;
            case R.id.share_wechat:
                //微信分享
                ShareUtils.shareUrl(ShareActivity.this, SHARE_MEDIA.WEIXIN,shareListener);
                break;
            case R.id.share_wechat_moments:
                //微信朋友圈分享
                ShareUtils.shareUrl(ShareActivity.this, SHARE_MEDIA.WEIXIN_CIRCLE,shareListener);
                break;
            case R.id.share_sina:
                //新浪分享
                ShareUtils.shareUrl(ShareActivity.this, SHARE_MEDIA.SINA,shareListener);
                break;
            case R.id.share_facebook:
                //FaceBook分享
                ShareUtils.shareUrl(ShareActivity.this, SHARE_MEDIA.FACEBOOK,shareListener);
                break;
            case R.id.share_twitter:
                //Twitter分享
                ShareUtils.shareUrl(ShareActivity.this, SHARE_MEDIA.TWITTER,shareListener);
                break;
            case R.id.share_sms:
                //短信分享
//                ShareUtils.shareTextAndImage(ShareActivity.this, SHARE_MEDIA.SMS,shareListener);
                break;
        }
    }

    private UMShareListener shareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            Toast.makeText(ShareActivity.this,"开始了",Toast.LENGTH_LONG).show();
        }

        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(ShareActivity.this,"成功了",Toast.LENGTH_LONG).show();
        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(ShareActivity.this,"失败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(ShareActivity.this,"取消了",Toast.LENGTH_LONG).show();

        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        UMShareAPI.get(this).release();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode,resultCode,data);
    }

    //页面跳转
    public static void startActivity(Context context){
        Intent intent=new Intent(context,ShareActivity.class);
        context.startActivity(intent);
    }
}
