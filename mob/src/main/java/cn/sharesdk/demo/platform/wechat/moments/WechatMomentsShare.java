package cn.sharesdk.demo.platform.wechat.moments;

import android.util.Log;

import com.mob.MobSDK;

import java.util.HashMap;

import cn.sharesdk.demo.entity.ResourcesManager;
import cn.sharesdk.demo.share.ShareUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;

/**
 * Created by yjin on 2017/6/22.
 */

public class WechatMomentsShare {
	private PlatformActionListener platformActionListener;

	public WechatMomentsShare(PlatformActionListener mListener){
		this.platformActionListener = mListener;
		ShareUtils.isValidClient("com.tencent.mm");
	}

	public void shareText(){
		Platform platform = ShareSDK.getPlatform(QQ.NAME);
		Platform.ShareParams shareParams = new  Platform.ShareParams();
		shareParams.setText("title");
		shareParams.setTitle("text");
		shareParams.setTitleUrl("https://www.baidu.com");
		shareParams.setImageUrl("http://f1.webshare.mob.com/dimgs/1c950a7b02087bf41bc56f07f7d3572c11dfcf36.jpg");
		platform.setPlatformActionListener(new PlatformActionListener() {
            @Override
            public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                Log.i("ssss","onComplete");
            }

            @Override
            public void onError(Platform platform, int i, Throwable throwable) {
                Log.i("ssss","onError"+throwable);
                throwable.printStackTrace();
            }

            @Override
            public void onCancel(Platform platform, int i) {
                Log.i("ssss","oncancel");
            }
        });
		platform.share(shareParams);
	}

	public void shareImage(){
//		shareParams.setText(ResourcesManager.getInstace(MobSDK.getContext()).getText());
//		shareParams.setImagePath(ResourcesManager.getInstace(MobSDK.getContext()).getImagePath());
//		shareParams.setImageUrl(ResourcesManager.getInstace(MobSDK.getContext()).getImageUrl());
//		shareParams.setImageData(ResourcesManager.getInstace(MobSDK.getContext()).getImageBmp());
		Platform platform = ShareSDK.getPlatform(WechatMoments.NAME);
		Platform.ShareParams shareParams = new  Platform.ShareParams();
		shareParams.setImageArray(randomPic());
		shareParams.setShareType(Platform.SHARE_IMAGE);
		platform.setPlatformActionListener(platformActionListener);
		platform.share(shareParams);
	}

	public static String[] randomPic() {
		String url = "http://git.oschina.net/alexyu.yxj/MyTmpFiles/raw/master/kmk_pic_fld/";
		String urlSmall = "http://git.oschina.net/alexyu.yxj/MyTmpFiles/raw/master/kmk_pic_fld/small/";
		String[] pics = new String[]{
				"120.JPG",
				"127.JPG",
				"130.JPG",
				"18.JPG",
				"184.JPG",
				"22.JPG",
				"236.JPG",
				"237.JPG",
				"254.JPG",
				"255.JPG",
				"263.JPG",
				"265.JPG",
				"273.JPG",
				"37.JPG",
				"39.JPG",
				"IMG_2219.JPG",
				"IMG_2270.JPG",
				"IMG_2271.JPG",
				"IMG_2275.JPG",
				"107.JPG"
		};
		int index = 0;
		return new String[]{
				url + pics[index],
				urlSmall + pics[index],
				url + pics[index + 1],
				urlSmall + pics[index + 1],
				url + pics[index + 2],
				urlSmall + pics[index + 2],
				url + pics[index + 3],
				urlSmall + pics[index + 3],
				url + pics[index + 4]
		};
	}

	public void shareMusic(){
		Platform platform = ShareSDK.getPlatform(WechatMoments.NAME);
		Platform.ShareParams shareParams = new  Platform.ShareParams();
		shareParams.setText(ResourcesManager.getInstace(MobSDK.getContext()).getText());
		shareParams.setTitle(ResourcesManager.getInstace(MobSDK.getContext()).getTitle());
		shareParams.setImagePath(ResourcesManager.getInstace(MobSDK.getContext()).getImagePath());
		shareParams.setImageUrl(ResourcesManager.getInstace(MobSDK.getContext()).getImageUrl());
		shareParams.setUrl(ResourcesManager.getInstace(MobSDK.getContext()).getUrl());
		shareParams.setMusicUrl(ResourcesManager.getInstace(MobSDK.getContext()).getMusicUrl());
		shareParams.setShareType(Platform.SHARE_MUSIC);
		platform.setPlatformActionListener(platformActionListener);
		platform.share(shareParams);
	}

	public void shareVideo(){
		Platform platform = ShareSDK.getPlatform(WechatMoments.NAME);
		Platform.ShareParams shareParams = new  Platform.ShareParams();
		shareParams.setText(ResourcesManager.getInstace(MobSDK.getContext()).getText());
		shareParams.setTitle(ResourcesManager.getInstace(MobSDK.getContext()).getTitle());
		shareParams.setUrl(ResourcesManager.getInstace(MobSDK.getContext()).getUrl());
		shareParams.setImagePath(ResourcesManager.getInstace(MobSDK.getContext()).getImagePath());
		shareParams.setShareType(Platform.SHARE_VIDEO);
		platform.setPlatformActionListener(platformActionListener);
		platform.share(shareParams);
	}

	public void shareWebpager(){
		Platform platform = ShareSDK.getPlatform(Wechat.NAME);
		Platform.ShareParams shareParams = new  Platform.ShareParams();
		shareParams.setText("text");
		shareParams.setTitle("title");
		shareParams.setUrl("https://www.baidu.com");
		shareParams.setImageUrl("http://f1.webshare.mob.com/dimgs/1c950a7b02087bf41bc56f07f7d3572c11dfcf36.jpg");
		shareParams.setShareType(Platform.SHARE_WEBPAGE);
			platform.setPlatformActionListener(new PlatformActionListener() {
				@Override
				public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
					Log.i("ssss","onComplete");
				}

				@Override
				public void onError(Platform platform, int i, Throwable throwable) {
					Log.i("ssss","onError"+throwable);
					throwable.printStackTrace();
				}

				@Override
				public void onCancel(Platform platform, int i) {
					Log.i("ssss","oncancel");
				}
			});
		platform.share(shareParams);
	}

	public void shareText(PlatformActionListener mListener){
		Platform platform = ShareSDK.getPlatform(WechatMoments.NAME);
		Platform.ShareParams shareParams = new  Platform.ShareParams();
		shareParams.setText(ResourcesManager.getInstace(MobSDK.getContext()).getText());
		shareParams.setTitle(ResourcesManager.getInstace(MobSDK.getContext()).getTitle());
		shareParams.setShareType(Platform.SHARE_TEXT);
		platform.setPlatformActionListener(mListener);
		platform.share(shareParams);
	}

	public void shareImage(PlatformActionListener mListener){
		Platform platform = ShareSDK.getPlatform(WechatMoments.NAME);
		Platform.ShareParams shareParams = new  Platform.ShareParams();
		shareParams.setText(ResourcesManager.getInstace(MobSDK.getContext()).getText());
		shareParams.setImagePath(ResourcesManager.getInstace(MobSDK.getContext()).getImagePath());
		shareParams.setImageUrl(ResourcesManager.getInstace(MobSDK.getContext()).getImageUrl());
		shareParams.setImageData(ResourcesManager.getInstace(MobSDK.getContext()).getImageBmp());
		shareParams.setShareType(Platform.SHARE_IMAGE);
		platform.setPlatformActionListener(mListener);
		platform.share(shareParams);
	}

	public void shareMusic(PlatformActionListener mListener){
		Platform platform = ShareSDK.getPlatform(WechatMoments.NAME);
		Platform.ShareParams shareParams = new  Platform.ShareParams();
		shareParams.setText(ResourcesManager.getInstace(MobSDK.getContext()).getText());
		shareParams.setTitle(ResourcesManager.getInstace(MobSDK.getContext()).getTitle());
		shareParams.setImagePath(ResourcesManager.getInstace(MobSDK.getContext()).getImagePath());
		shareParams.setImageUrl(ResourcesManager.getInstace(MobSDK.getContext()).getImageUrl());
		shareParams.setUrl(ResourcesManager.getInstace(MobSDK.getContext()).getUrl());
		shareParams.setMusicUrl(ResourcesManager.getInstace(MobSDK.getContext()).getMusicUrl());
		shareParams.setShareType(Platform.SHARE_MUSIC);
		platform.setPlatformActionListener(mListener);
		platform.share(shareParams);
	}

	public void shareVideo(PlatformActionListener mListener){
		Platform platform = ShareSDK.getPlatform(WechatMoments.NAME);
		Platform.ShareParams shareParams = new  Platform.ShareParams();
		shareParams.setFilePath(ResourcesManager.getInstace(MobSDK.getContext()).getFilePath());
		shareParams.setText(ResourcesManager.getInstace(MobSDK.getContext()).getText());
		shareParams.setTitle(ResourcesManager.getInstace(MobSDK.getContext()).getTitle());
		shareParams.setUrl(ResourcesManager.getInstace(MobSDK.getContext()).getUrl());
		shareParams.setShareType(Platform.SHARE_VIDEO);
		platform.setPlatformActionListener(mListener);
		platform.share(shareParams);
	}

	public void shareWebpager(PlatformActionListener mListener){
		Platform platform = ShareSDK.getPlatform(WechatMoments.NAME);
		Platform.ShareParams shareParams = new  Platform.ShareParams();
		shareParams.setFilePath(ResourcesManager.getInstace(MobSDK.getContext()).getFilePath());
		shareParams.setText(ResourcesManager.getInstace(MobSDK.getContext()).getText());
		shareParams.setTitle(ResourcesManager.getInstace(MobSDK.getContext()).getTitle());
		shareParams.setUrl(ResourcesManager.getInstace(MobSDK.getContext()).getUrl());
		shareParams.setImageData(ResourcesManager.getInstace(MobSDK.getContext()).getImageBmp());
		shareParams.setImagePath(ResourcesManager.getInstace(MobSDK.getContext()).getImagePath());
		shareParams.setShareType(Platform.SHARE_WEBPAGE);
		platform.setPlatformActionListener(mListener);
		platform.share(shareParams);
	}


}
