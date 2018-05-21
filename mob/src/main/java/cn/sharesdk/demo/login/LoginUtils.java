package cn.sharesdk.demo.login;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;

/**
 * 文 件 名: LoginUtils
 * 创 建 人: CXP
 * 创建日期: 2018-05-21 11:07
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class LoginUtils {


    private static Context mContext;
    private static AuthorizeListener mAuthorizeListener;

    // 授权
    public static void authorize(Context context,Platform plat,AuthorizeListener authorizeListener) {
        mContext=context;
        mAuthorizeListener=authorizeListener;
        // 判断指定平台是否已经完成授权
        if (plat.isAuthValid()) {
            plat.removeAccount(true);
        }
        plat.setPlatformActionListener(actionLis);
        // true不使用SSO授权，false使用SSO授权
        plat.SSOSetting(false);
        // 获取用户资料
        plat.showUser(null);
    }

    /**
     * 授权监听
     */
    private static PlatformActionListener actionLis = new PlatformActionListener() {

        @Override
        public void onError(Platform arg0, int arg1, Throwable arg2) {
            Toast.makeText(mContext, "登录失败",Toast.LENGTH_SHORT).show();
            mAuthorizeListener.onFaild();
        }

        @Override
        public void onComplete(final Platform arg0,final int arg1,final HashMap<String, Object> arg2) {
            ((Activity)mContext).runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    mAuthorizeListener.onSuccess(arg0,arg1, arg2);
                }
            });
        }

        @Override
        public void onCancel(Platform arg0, int arg1) {
            Toast.makeText(mContext, "取消",Toast.LENGTH_SHORT).show();
            mAuthorizeListener.onFaild();
        }
    };

    public interface AuthorizeListener {
        void onSuccess(final Platform arg0, int arg1, HashMap<String, Object> arg2);
        void onFaild();
    }
}
