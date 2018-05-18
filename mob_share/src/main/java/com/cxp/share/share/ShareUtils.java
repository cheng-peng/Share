package com.cxp.share.share;

import com.cxp.share.AppUtils;

import cn.sharesdk.facebook.Facebook;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.system.text.ShortMessage;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.tencent.qzone.QZone;
import cn.sharesdk.twitter.Twitter;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;

/**
 * 文 件 名: ShareUtils
 * 创 建 人: CXP
 * 创建日期: 2017-02-08 16:30
 * 描    述: 分享工具类
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class ShareUtils {

    //图片连接
    public static String IMG_URL = "https://www.cxp521.com/images.jpg";

    //分享内容
    public static String CONTENT = "";
    //分享图片
    public static String IMG_PATH = "";
    //点击后跳转的连接
    public static String URL = "";
    //分享标题
    public final static String TITLE = "CXP";

    /**
     * 新浪分享
     */
    public static void sinaShare(PlatformActionListener listener) {

        Platform.ShareParams sp = new Platform.ShareParams();
        if (AppUtils.isEmpty(CONTENT)) {
            sp.setText(CONTENT);
        }
        if (AppUtils.isEmpty(IMG_PATH)) {
            sp.setImagePath(IMG_PATH);
        }

        Platform sina = ShareSDK.getPlatform(SinaWeibo.NAME);
        // 设置分享事件回调
        sina.setPlatformActionListener(listener);

        // 执行图文分享
        sina.share(sp);
    }

    /**
     * FaceBook分享
     */
    public static void faceBookShare(PlatformActionListener listener) {

        //图片分享
//        Platform platform = ShareSDK.getPlatform(Facebook.NAME);
//        Platform.ShareParams shareParams = new  Platform.ShareParams();
//        shareParams.setImageUrl("http://www.cxp521.com/images.jpg");
//        shareParams.setContentType(Platform.SHARE_IMAGE);
//        platform.setPlatformActionListener(listener);
//        platform.share(shareParams);

        Platform.ShareParams sp = new Platform.ShareParams();
        sp.setUrl("http://www.cxp521.com/facebook.html");
        Platform faceBook = ShareSDK.getPlatform(Facebook.NAME);
        // 设置分享事件回调
        faceBook.setPlatformActionListener(listener);

        //执行图文分享
        faceBook.share(sp);
    }

    /**
     * Twitter分享
     */
    public static void twitterShare(PlatformActionListener listener) {

        Platform.ShareParams sp = new Platform.ShareParams();
        sp.setImageUrl("http://www.cxp521.com/images.jpg");
        sp.setText("程小鹏个人博客http://www.cxp521.com/");
        Platform twitter = ShareSDK.getPlatform(Twitter.NAME);
        // 设置分享事件回调
        twitter.setPlatformActionListener(listener);

        // 执行图文分享
        twitter.share(sp);
    }

    /**
     * QQ分享
     */
    public static void qqShare(PlatformActionListener listener) {

        QQ.ShareParams sp = new QQ.ShareParams();
        if (AppUtils.isEmpty(TITLE)) {
            sp.setTitle(TITLE);
            sp.setSite(TITLE);
        }
        if (AppUtils.isEmpty(CONTENT)) {
            sp.setText(CONTENT);
        }
        if (AppUtils.isEmpty(URL)) {
            sp.setTitleUrl((URL));  // 标题的超链接
        }
        if (AppUtils.isEmpty(IMG_PATH)) {
            sp.setImageUrl(IMG_PATH);
        }

        Platform qq = ShareSDK.getPlatform(QQ.NAME);
        // 设置分享事件回调
        qq.setPlatformActionListener(listener);

        // 执行图文分享
        qq.share(sp);
    }

    /**
     * QQ空间分享
     */
    public static void qzoneShare(PlatformActionListener listener) {

        QZone.ShareParams sp = new QZone.ShareParams();
        if (AppUtils.isEmpty(TITLE)) {
            sp.setTitle(TITLE);
            sp.setSite(TITLE);
        }
        if (AppUtils.isEmpty(CONTENT)) {
            sp.setText(CONTENT);
        }
        if (AppUtils.isEmpty(URL)) {
            sp.setTitleUrl((URL));  // 标题的超链接
        }
        if (AppUtils.isEmpty(IMG_PATH)) {
            sp.setImageUrl(IMG_PATH);
        }

        Platform qzone = ShareSDK.getPlatform(QZone.NAME);
        // 设置分享事件回调
        qzone.setPlatformActionListener(listener);

        // 执行图文分享
        qzone.share(sp);
    }

    /**
     * 短信分享
     */
    public static void smsShare(PlatformActionListener listener) {

        ShortMessage.ShareParams sp = new ShortMessage.ShareParams();

        if (AppUtils.isEmpty(TITLE)) {
            sp.setText(TITLE + CONTENT + URL);
        }
        Platform sms = ShareSDK.getPlatform(ShortMessage.NAME);
        // 设置分享事件回调
        sms.setPlatformActionListener(listener);

        // 执行图文分享
        sms.share(sp);
    }

    /**
     * 微信朋友圈分享
     */
    public static void wechatMomentsShare(PlatformActionListener listener) {
        WechatMoments.ShareParams sp = new WechatMoments.ShareParams();
        if (AppUtils.isEmpty(TITLE)) {
//            sp.setTitle(ConstantUtils.TITLE);
        }
        if (AppUtils.isEmpty(CONTENT)) {
            sp.setTitle(CONTENT);
        }
        if (AppUtils.isEmpty(IMG_PATH)) {
            sp.setImageUrl(IMG_PATH);
        }
        if (AppUtils.isEmpty(URL)) {
            sp.setUrl(URL);
        }
        sp.setShareType(Platform.SHARE_WEBPAGE);

        Platform wechatMoments = ShareSDK.getPlatform(WechatMoments.NAME);
        // 设置分享事件回调
        wechatMoments.setPlatformActionListener(listener);

        // 执行图文分享
        wechatMoments.share(sp);
    }

    /**
     * 微信分享
     */
    public static void wechatShare(PlatformActionListener listener) {

        Wechat.ShareParams sp = new Wechat.ShareParams();
        if (AppUtils.isEmpty(TITLE)) {
            sp.setTitle(TITLE);
        }
        if (AppUtils.isEmpty(CONTENT)) {
            sp.setText(CONTENT);
        }
        if (AppUtils.isEmpty(URL)) {
            sp.setUrl((URL));  // 标题的超链接
        }
        if (AppUtils.isEmpty(IMG_PATH)) {
            sp.setImageUrl(IMG_PATH);
        }
        sp.setShareType(Platform.SHARE_WEBPAGE);

        Platform wechat = ShareSDK.getPlatform(Wechat.NAME);
        // 设置分享事件回调
        wechat.setPlatformActionListener(listener);

        // 执行图文分享
        wechat.share(sp);
    }
}
