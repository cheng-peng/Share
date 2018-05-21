package com.cxp.share.share;

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
        UMImage imageurl = new UMImage(activity,IMG_URL);
        //缩略图
//        imagelocal.setThumb(new UMImage(activity, R.drawable.ic_launcher_background));
        new ShareAction(activity).withText(CONTENT)
                .withMedia(imageurl)
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

    //不常用
//    //分享文本
//    public void shareText(Activity activity,SHARE_MEDIA share_media,UMShareListener umShareListener){
//        new ShareAction(activity).withText(CONTENT)
//                .setPlatform(share_media)
//                .setCallback(umShareListener).share();
//    }
//    //分享本地图片
//    public void shareImageLocal(Activity activity,SHARE_MEDIA share_media,UMShareListener umShareListener){
//        UMImage imagelocal = new UMImage(activity, R.drawable.logo);
//        imagelocal.setThumb(new UMImage(activity, R.drawable.thumb));
//        new ShareAction(activity).withMedia(imagelocal )
//                .setPlatform(share_media)
//                .setCallback(umShareListener).share();
//    }
//    //分享网络图片
//    public void shareImageNet(Activity activity,SHARE_MEDIA share_media,UMShareListener umShareListener){
//        UMImage imageurl = new UMImage(activity,Defaultcontent.imageurl);
//        imageurl.setThumb(new UMImage(activity, R.drawable.thumb));
//        new ShareAction(activity).withMedia(imageurl )
//                .setPlatform(share_media)
//                .setCallback(umShareListener).share();
//    }
//
//    //分享音乐
//    public void shareMusic(Activity activity,SHARE_MEDIA share_media,UMShareListener umShareListener){
//        UMusic music = new UMusic(Defaultcontent.musicurl);
//        music.setTitle("activity is music title");
//        music.setThumb(new UMImage(activity, R.drawable.thumb));
//        music.setDescription("my description");
//        music.setmTargetUrl(Defaultcontent.url);
//        new ShareAction(activity).withMedia(music )
//                .setPlatform(share_media)
//                .setCallback(umShareListener).share();
//    }
//    //分享视频
//    public void shareVideo(Activity activity,SHARE_MEDIA share_media,UMShareListener umShareListener){
//        UMVideo video = new UMVideo(Defaultcontent.videourl);
//        video.setThumb(new UMImage(activity,R.drawable.thumb));
//        video.setTitle("activity is video title");
//        video.setDescription("my description");
//        new ShareAction(activity).withMedia(video )
//                .setPlatform(share_media)
//                .setCallback(umShareListener).share();
//    }
//
//    //分享多图
//    public void shareMulImage(){
//        UMImage imagelocal1 = new UMImage(activity, IMG_PATH);
//        imagelocal1.setThumb(new UMImage(activity, R.drawable.thumb));
//        UMImage imagelocal2 = new UMImage(activity, R.drawable.thumb);
//        imagelocal2.setThumb(new UMImage(activity, R.drawable.thumb));
//        new ShareAction(activity).withText("多图分享").withMedias(imagelocal1,imagelocal2 )
//                .setPlatform(share_media)
//                .setCallback(umShareListener).share();
//    }
//    //分享文件
//    public void shareFile(Activity activity,SHARE_MEDIA share_media,UMShareListener umShareListener){
//        File file = new File(activity.getFilesDir()+"test.txt");
//        if (!file.exists()){
//            try {
//                file.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        if (SocializeUtils.File2byte(file).length<=0){
//            String content = "U-share分享";
//            byte[] contentInBytes = content.getBytes();
//            try {
//                FileOutputStream fop = new FileOutputStream(file);
//                fop.write(contentInBytes);
//                fop.flush();
//                fop.close();
//
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//        new ShareAction(activity)
//                .withFile(file)
//                .withText(CONTENT)
//                .withSubject(Defaultcontent.title)
//                .setPlatform(share_media)
//                .setCallback(umShareListener).share();
//    }
//    //分享表情
//    public void shareEmoji(Activity activity,SHARE_MEDIA share_media,UMShareListener umShareListener){
//        UMEmoji emoji = new UMEmoji(activity,"http://img5.imgtn.bdimg.com/it/u=2749190246,3857616763&fm=21&gp=0.jpg");
//        emoji.setThumb(new UMImage(activity, R.drawable.thumb));
//        new ShareAction(activity)
//                .withMedia(emoji)
//                .setPlatform(share_media)
//                .setCallback(umShareListener).share();
//    }
//    //小程序
//    public void shareMINApp(Activity activity,SHARE_MEDIA share_media,UMShareListener umShareListener){
//        UMMin umMin = new UMMin(Defaultcontent.url);
//        umMin.setThumb(new UMImage(activity,R.drawable.thumb));
//        umMin.setTitle(Defaultcontent.title);
//        umMin.setDescription(CONTENT);
//        umMin.setPath("pages/page10007/page10007");
//        umMin.setUserName("gh_3ac2059ac66f");
//        new ShareAction(activity)
//                .withMedia(umMin)
//                .setPlatform(share_media)
//                .setCallback(umShareListener).share();
//    }
}
