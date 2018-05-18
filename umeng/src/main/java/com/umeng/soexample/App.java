package com.umeng.soexample;

import android.app.Application;

import com.umeng.commonsdk.UMConfigure;

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

        //设置LOG开关，默认为false
//        UMConfigure.setLogEnabled(true);
        //初始化组件化基础库, 统计SDK/推送SDK/分享SDK都必须调用此初始化接口
        UMConfigure.init(this,"59892f08310c9307b60023d0","umeng",UMConfigure.DEVICE_TYPE_PHONE,"");
        //初始化umeng
        UmengUtils.initUmeng();
    }
}
