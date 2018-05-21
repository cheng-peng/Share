package cn.sharesdk.demo.share;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.HashMap;

import cn.sharesdk.demo.R;
import cn.sharesdk.demo.platform.facebook.FacebookShare;
import cn.sharesdk.demo.platform.sina.WeiboShare;
import cn.sharesdk.demo.platform.tencent.qq.QQShare;
import cn.sharesdk.demo.platform.tencent.qzone.QQZoneShare;
import cn.sharesdk.demo.platform.twitter.TwitterShare;
import cn.sharesdk.demo.platform.wechat.friends.WechatShare;
import cn.sharesdk.demo.platform.wechat.moments.WechatMomentsShare;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;


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
        ShareUtils.IMG_PATH = "http://www.cxp521.com/images.jpg";
        ShareUtils.URL = "http://www.cxp521.com/";
        ShareUtils.CONTENT = "内容。";
        switch (view.getId()) {
            case R.id.share_qq:
                //QQ分享
                QQShare qqShare = new QQShare(platformActionListener);
                qqShare.shareWebPager(platformActionListener);
                break;
            case R.id.share_qzone:
                //Qzone分享
                QQZoneShare qqZoneShare = new QQZoneShare(platformActionListener);
                qqZoneShare.shareWebPager(platformActionListener);
                break;
            case R.id.share_wechat:
                //微信分享
                WechatShare wechatShare = new WechatShare(platformActionListener);
                wechatShare.shareWebpager(platformActionListener);
                break;
            case R.id.share_wechat_moments:
                //微信朋友圈分享
                WechatMomentsShare wechatMomentsShare = new WechatMomentsShare(platformActionListener);
                wechatMomentsShare.shareWebpager(platformActionListener);
                break;
            case R.id.share_sina:
                //新浪分享
                WeiboShare weiboShare = new WeiboShare(platformActionListener);
                weiboShare.shareText(platformActionListener);
                break;
            case R.id.share_facebook:
                //FaceBook分享
                FacebookShare facebookShare = new FacebookShare(platformActionListener);
                facebookShare.shareWebPage(platformActionListener);
                break;
            case R.id.share_twitter:
                //Twitter分享
                TwitterShare twitterShare = new TwitterShare(platformActionListener);
                twitterShare.shareText(platformActionListener);
                break;
            case R.id.share_sms:
                //短信分享
//                ShareUtils.shareTextAndImage(ShareActivity.this, SHARE_MEDIA.SMS,shareListener);
                break;
        }
    }

    private PlatformActionListener platformActionListener=new PlatformActionListener() {
        @Override
        public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
            ShareActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(ShareActivity.this,"成功了",Toast.LENGTH_LONG).show();
                }
            });
        }

        @Override
        public void onError(Platform platform, int i, Throwable throwable) {
            Toast.makeText(ShareActivity.this,"失败",Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCancel(Platform platform, int i) {
            Toast.makeText(ShareActivity.this,"取消了",Toast.LENGTH_LONG).show();
        }
    };

    //页面跳转
    public static void startActivity(Context context){
        Intent intent=new Intent(context,ShareActivity.class);
        context.startActivity(intent);
    }
}
