package com.cxp.share;

import android.app.Application;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

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
        UMConfigure.init(this,"5af3007fb27b0a73d400019f","umeng",UMConfigure.DEVICE_TYPE_PHONE,"");
        PlatformConfig.setQQZone("1106823993", "mym0fmQbIbPmr92b");
        //初始化umeng
//        UmengUtils.initUmeng();
    }
}
