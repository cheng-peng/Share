package com.umeng.soexample.share;

import android.app.Activity;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

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
    public static String IMG_URL = "http://www.cxp521.com/images.jpg";
    //分享内容
    public static String CONTENT = "";
    //分享图片
    public static String IMG_PATH = "";
    //点击后跳转的连接
    public static String URL = "";
    //标题
    public static String TITLE = "CXP";

    public static void shareTextAndImage(Activity activity,SHARE_MEDIA share_media,UMShareListener umShareListener){
        //本地图
//        UMImage imagelocal = new UMImage(activity, R.mipmap.ic_launcher);
        UMImage imagelocal = new UMImage(activity, IMG_PATH);
        //缩略图
//        imagelocal.setThumb(new UMImage(activity, R.drawable.ic_launcher_background));
        new ShareAction(activity).withText(CONTENT)
                .withMedia(imagelocal)
                .setPlatform(share_media)
                .setCallback(umShareListener).share();
    }

    public static void shareUrl(Activity activity,SHARE_MEDIA share_media,UMShareListener umShareListener){
        UMWeb web = new UMWeb(URL);
        web.setTitle(TITLE);
        //缩略图
        web.setThumb(new UMImage(activity, IMG_URL));
        web.setDescription(CONTENT);
        new ShareAction(activity).withMedia(web)
                .setPlatform(share_media)
                .setCallback(umShareListener).share();
    }
}
