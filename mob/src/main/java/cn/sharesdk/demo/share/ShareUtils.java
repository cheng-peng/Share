package cn.sharesdk.demo.share;

import android.annotation.SuppressLint;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.widget.Toast;

import com.mob.MobSDK;

import cn.sharesdk.demo.AppUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.tencent.qzone.QZone;
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
@SuppressLint("WrongConstant")
public class ShareUtils {

    //图片连接
    public static String IMG_URL = "http://www.cxp521.com/images.jpg";
    //分享内容
    public static String CONTENT = "";
    //分享图片
    public static String IMG_PATH = "";
    //点击后跳转的连接
    public static String URL = "";
    //标题
    public static String TITLE = "CXP";

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
     * 微信朋友圈分享
     */
    public static void wechatMomentsShare(PlatformActionListener listener) {
        WechatMoments.ShareParams sp = new WechatMoments.ShareParams();
        if (AppUtils.isEmpty(TITLE)) {
//            sp.setTitle(TITLE);
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

    //判断有没有客户端——单客户端
    public static boolean isValidClient(String akp) {
        PackageInfo pi;
        try {
            pi = MobSDK.getContext().getPackageManager().getPackageInfo(
                    akp, PackageManager.GET_RESOLVED_FILTER);
            return true;
        } catch (Throwable t) {
            Toast.makeText(MobSDK.getContext(), "client is not install or version low", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    //判断有没有客户端——新浪
    public static boolean isValidClientSina(String akp) {
        PackageInfo pi;
        try {
            pi = MobSDK.getContext().getPackageManager().getPackageInfo(
                    akp, PackageManager.GET_RESOLVED_FILTER);
            return true;
        } catch (Throwable t) {
        }
        return false;
    }

    //判断有没有客户端——多客户端
    public static void isValidClient(String[] akp) {
        int length = akp.length;
        PackageInfo pi = null;
        for (int i = 0; i < length; i++) {
            String packages = akp[i];
            try {
                pi = MobSDK.getContext().getPackageManager().getPackageInfo(
                        packages, PackageManager.GET_RESOLVED_FILTER);
                if (pi != null) {
                    break;
                }
            } catch (Throwable t) {

            }
        }
        if (pi == null) {
            Toast.makeText(MobSDK.getContext(), "client is not install or version low", Toast.LENGTH_SHORT).show();
        }

    }
}
