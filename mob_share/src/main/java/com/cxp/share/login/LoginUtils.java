package com.cxp.share.login;

import cn.sharesdk.facebook.Facebook;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.twitter.Twitter;
import cn.sharesdk.wechat.friends.Wechat;

/**
 * 文 件 名: LoginUtils
 * 创 建 人: CXP
 * 创建日期: 2018-05-11 15:22
 * 描    述: 登录工具类
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class LoginUtils {


    /**
     * QQ登录
     */
    public static void qqLogin(PlatformActionListener listener) {

        Platform plat = ShareSDK.getPlatform(QQ.NAME);
        if (plat != null) {
            plat.removeAccount(true);
        }
        // 授权
        authorize(plat, listener);
    }


    /**
     * Wechat登录
     */
    public static void wechatLogin(PlatformActionListener listener) {

        Platform plat = ShareSDK.getPlatform(Wechat.NAME);
        if (plat != null) {
            plat.removeAccount(true);
        }
        // 授权
        authorize(plat, listener);
    }

    /**
     * SinaWeibo登录
     */
    public static void sinaWeiboLogin(PlatformActionListener listener) {

        Platform plat = ShareSDK.getPlatform(SinaWeibo.NAME);
        if (plat != null) {
            plat.removeAccount(true);
        }
        // 授权
        authorize(plat, listener);
    }


    /**
     * FaceBook登录
     */
    public static void faceBookLogin(PlatformActionListener listener) {

        Platform plat = ShareSDK.getPlatform(Facebook.NAME);
        if (plat != null) {
            plat.removeAccount(true);
        }
        // 授权
        authorize(plat, listener);
    }

    /**
     * Twitter登录
     */
    public static void twitterLogin(PlatformActionListener listener) {

        Platform plat = ShareSDK.getPlatform(Twitter.NAME);
        if (plat != null) {
            plat.removeAccount(true);
        }
        // 授权
        authorize(plat, listener);
    }

    // 授权
    private static void authorize(Platform plat, PlatformActionListener listener) {
        // 判断指定平台是否已经完成授权
        if (plat.isAuthValid()) {
            plat.removeAccount(true);
        }
        plat.setPlatformActionListener(listener);
        // true不使用SSO授权，false使用SSO授权
        plat.SSOSetting(false);
        // 获取用户资料
        plat.showUser(null);
    }

}
