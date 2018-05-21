package cn.sharesdk.demo;

import android.app.Application;

import com.mob.MobSDK;

import cn.sharesdk.demo.entity.ResourcesManager;


/**
 * 文 件 名: App
 * 创 建 人: CXP
 * 创建日期: 2018-05-10 14:41
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ResourcesManager.getInstace(MobSDK.getContext());
    }
}
