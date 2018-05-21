package cn.sharesdk.demo.platform.tencent.qq;

import android.util.Log;

import com.mob.MobSDK;

import java.util.HashMap;

import cn.sharesdk.demo.entity.ResourcesManager;
import cn.sharesdk.demo.share.ShareUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;

/**
 * Created by yjin on 2017/6/22.
 */

public class QQShare {
	private PlatformActionListener platformActionListener;

	public QQShare(PlatformActionListener mListener){
		this.platformActionListener = mListener;
		String[] pks = {"com.tencent.mobileqq","com.tencent.mobileqqi","com.tencent.qqlite","com.tencent.minihd.qq","com.tencent.tim"};
		ShareUtils.isValidClient(pks);
	}

	public void shareWebPager(){
		Platform platform = ShareSDK.getPlatform(QQ.NAME);
		Platform.ShareParams shareParams = new  Platform.ShareParams();
		shareParams.setText("text");
		shareParams.setTitle("title");
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
		Platform platform = ShareSDK.getPlatform(QQ.NAME);
		Platform.ShareParams shareParams = new  Platform.ShareParams();
		shareParams.setImagePath(ResourcesManager.getInstace(MobSDK.getContext()).getImagePath());
		shareParams.setImageUrl(ResourcesManager.getInstace(MobSDK.getContext()).getImageUrl());
		shareParams.setImageArray(ResourcesManager.getInstace(MobSDK.getContext()).randomPic());
		platform.setPlatformActionListener(platformActionListener);
		shareParams.setShareType(Platform.SHARE_IMAGE);
		platform.share(shareParams);
	}

	public void shareMusic(){
		Platform platform = ShareSDK.getPlatform(QQ.NAME);
		Platform.ShareParams shareParams = new  Platform.ShareParams();
		shareParams.setText(ResourcesManager.getInstace(MobSDK.getContext()).getText());
		shareParams.setTitle(ResourcesManager.getInstace(MobSDK.getContext()).getTitle());
		shareParams.setTitleUrl(ResourcesManager.getInstace(MobSDK.getContext()).getTitleUrl());
		shareParams.setImagePath(ResourcesManager.getInstace(MobSDK.getContext()).getImagePath());
		shareParams.setImageUrl(ResourcesManager.getInstace(MobSDK.getContext()).getImageUrl());
		shareParams.setMusicUrl(ResourcesManager.getInstace(MobSDK.getContext()).getMusicUrl());
		shareParams.setShareType(Platform.SHARE_MUSIC);
		platform.setPlatformActionListener(platformActionListener);
		platform.share(shareParams);
	}

	public void shareWebPager(PlatformActionListener mListener){
		Platform platform = ShareSDK.getPlatform(QQ.NAME);
		Platform.ShareParams shareParams = new  Platform.ShareParams();
		shareParams.setText(ResourcesManager.getInstace(MobSDK.getContext()).getText());
		shareParams.setTitle(ResourcesManager.getInstace(MobSDK.getContext()).getTitle());
		shareParams.setTitleUrl(ResourcesManager.getInstace(MobSDK.getContext()).getTitleUrl());
		shareParams.setShareType(Platform.SHARE_WEBPAGE);
		platform.setPlatformActionListener(mListener);
		platform.share(shareParams);
	}

	public void shareImage(PlatformActionListener mListener){
		Platform platform = ShareSDK.getPlatform(QQ.NAME);
		Platform.ShareParams shareParams = new  Platform.ShareParams();
		shareParams.setImagePath(ResourcesManager.getInstace(MobSDK.getContext()).getImagePath());
		shareParams.setImageUrl(ResourcesManager.getInstace(MobSDK.getContext()).getImageUrl());
		shareParams.setShareType(Platform.SHARE_IMAGE);
		platform.setPlatformActionListener(mListener);
		platform.share(shareParams);
	}

	public void shareMusic(PlatformActionListener mListener){
		Platform platform = ShareSDK.getPlatform(QQ.NAME);
		Platform.ShareParams shareParams = new  Platform.ShareParams();
		shareParams.setText(ResourcesManager.getInstace(MobSDK.getContext()).getText());
		shareParams.setTitle(ResourcesManager.getInstace(MobSDK.getContext()).getTitle());
		shareParams.setTitleUrl(ResourcesManager.getInstace(MobSDK.getContext()).getTitleUrl());
		shareParams.setImagePath(ResourcesManager.getInstace(MobSDK.getContext()).getImagePath());
		shareParams.setImageUrl(ResourcesManager.getInstace(MobSDK.getContext()).getImageUrl());
		shareParams.setMusicUrl(ResourcesManager.getInstace(MobSDK.getContext()).getMusicUrl());
		shareParams.setShareType(Platform.SHARE_MUSIC);
		platform.setPlatformActionListener(mListener);
		platform.share(shareParams);
	}
}
