package cn.sharesdk.demo.platform.vkontakte;

import android.util.Log;

import com.mob.MobSDK;

import java.util.HashMap;

import cn.sharesdk.demo.entity.ResourcesManager;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.vkontakte.VKontakte;

/**
 * Created by yjin on 2017/6/22.
 */

public class VKontakteShare {
	private PlatformActionListener platformActionListener;

	public VKontakteShare(PlatformActionListener mListener){
		this.platformActionListener = mListener;
	}

	public void shareMessage(){
		Platform platform = ShareSDK.getPlatform(VKontakte.NAME);
		Platform.ShareParams shareParams = new  Platform.ShareParams();
		shareParams.setText(ResourcesManager.getInstace(MobSDK.getContext()).getText());
//		shareParams.setImagePath(ResourcesManager.getInstace(MobSDK.getContext()).getImagePath());
		shareParams.setImageUrl(ResourcesManager.getInstace(MobSDK.getContext()).getImageUrl());
//		shareParams.setUrl(ResourcesManager.getInstace(MobSDK.getContext()).getUrl());
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

	public void shareMessage(PlatformActionListener mListener){
		Platform platform = ShareSDK.getPlatform(VKontakte.NAME);
		Platform.ShareParams shareParams = new  Platform.ShareParams();
		shareParams.setText(ResourcesManager.getInstace(MobSDK.getContext()).getText());
		shareParams.setImagePath(ResourcesManager.getInstace(MobSDK.getContext()).getImagePath());
		shareParams.setImageUrl(ResourcesManager.getInstace(MobSDK.getContext()).getImageUrl());
		shareParams.setUrl(ResourcesManager.getInstace(MobSDK.getContext()).getUrl());
		shareParams.setFriend(ResourcesManager.IS_FRIEND);
		shareParams.setLatitude(ResourcesManager.latitude);
		shareParams.setLongitude(ResourcesManager.longitude);
		shareParams.setGroupId(" ");
		platform.setPlatformActionListener(mListener);
		platform.share(shareParams);
	}
}
