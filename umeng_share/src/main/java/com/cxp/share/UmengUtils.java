package com.cxp.share;

import com.umeng.socialize.PlatformConfig;

/**
 * 文 件 名: UmengUtils
 * 创 建 人: CXP
 * 创建日期: 2018-05-18 14:16
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class UmengUtils {

    /**
     * 初始化第三方配置
     */
    public static void initUmeng(){
        PlatformConfig.setQQZone("1106823993", "mym0fmQbIbPmr92b");
        PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0");
        //豆瓣RENREN平台目前只能在服务器端配置
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
        PlatformConfig.setTwitter("3aIN7fuF685MuZ7jtXkQxalyi", "MK6FEYG63eWcpDFgRYw4w9puJhzDl0tyuqWjZ3M7XJuuG7mMbO");
        PlatformConfig.setAlipay("2018051860142870");
        PlatformConfig.setDing("dingoalmlnohc0wggfedpk");
    }
}
