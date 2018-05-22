//package com.cxp.share;
//
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.graphics.Color;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.telecom.Call;
//import android.util.Log;
//import android.view.View;
//import android.widget.Toast;
//
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
//import com.sina.weibo.sdk.api.ImageObject;
//import com.sina.weibo.sdk.api.TextObject;
//import com.sina.weibo.sdk.api.WeiboMultiMessage;
//import com.sina.weibo.sdk.auth.AccessTokenKeeper;
//import com.sina.weibo.sdk.auth.Oauth2AccessToken;
//import com.sina.weibo.sdk.auth.WbConnectErrorMessage;
//import com.sina.weibo.sdk.auth.sso.SsoHandler;
//import com.sina.weibo.sdk.share.WbShareCallback;
//import com.sina.weibo.sdk.share.WbShareHandler;
//
//import java.io.BufferedInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.net.URLConnection;
//import java.util.HashMap;
//import java.util.Map;
//
//
//public class MainActivity extends AppCompatActivity implements WbShareCallback {
//
//    private Context mContext;
//
//    /**
//     * 封装了 "access_token"，"expires_in"，"refresh_token"，并提供了他们的管理功能
//     */
//    private Oauth2AccessToken mAccessToken;
//    /**
//     * 注意：SsoHandler 仅当 SDK 支持 SSO 时有效
//     */
//    private SsoHandler mSsoHandler;
//    //分享
//    private WbShareHandler shareHandler;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        mContext = this;
//
//
//    }
//
//
//
//    public void clickLis(View view) {
//
//        switch (view.getId()) {
//            case R.id.main_bt1:
//                mSsoHandler = new SsoHandler(MainActivity.this);
//                mSsoHandler.authorize(new SelfWbAuthListener());
//                break;
//            case R.id.main_bt2:
//                shareHandler = new WbShareHandler(this);
//                shareHandler.registerApp();
//                shareHandler.setProgressColor(Color.TRANSPARENT);
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        WeiboMultiMessage weiboMessage = new WeiboMultiMessage();
//                        weiboMessage.textObject = getTextObj();
//                        weiboMessage.imageObject=getImageObj(mContext,"http://www.cxp521.com/images.jpg");
//                        shareHandler.shareMessage(weiboMessage, false);
//                    }
//                }).start();
////                WeiboMultiMessage weiboMessage = new WeiboMultiMessage();
////                weiboMessage.textObject = getTextObj();
////                weiboMessage.imageObject=getImageObj(this,"http://www.cxp521.com/images.jpg");
//////                "http://www.cxp521.com/images.jpg"
//////                weiboMessage.imageObject = getImageObj(this, Environment.getExternalStorageDirectory().getPath() +"/images.jpg");
////                shareHandler.shareMessage(weiboMessage, false);
//
////                UMShareConfig config = new UMShareConfig();
////                config.isNeedAuthOnGetUserInfo(true);
////                UMShareAPI mShareAPI = UMShareAPI.get(MainActivity.this);
////                mShareAPI.setShareConfig(config);
////                mShareAPI.getPlatformInfo(MainActivity.this, SHARE_MEDIA.SINA, authListener);
//                break;
//        }
//
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if (shareHandler!=null) {
//            shareHandler=null;
//        }
//    }
//
//    @Override
//    public void onWbShareSuccess() {
//        Toast.makeText(mContext,
//                "成功", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onWbShareCancel() {
//        Toast.makeText(mContext,
//                "取消", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onWbShareFail() {
//        Toast.makeText(mContext,
//                "失败", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onNewIntent(Intent intent) {
//        super.onNewIntent(intent);
//        shareHandler.doResultIntent(intent, this);
//    }
//
//    /**
//     * 创建文本消息对象。
//     *
//     * @return 文本消息对象。
//     */
//    private TextObject getTextObj() {
//        TextObject textObject = new TextObject();
//        textObject.text = "CXP";
//        return textObject;
//    }
//
//    /**
//     * 创建图片消息对象。
//     *
//     * @return 图片消息对象。
//     */
//    private ImageObject getImageObj(Context context, String imgPath) {
//        ImageObject imageObject = new ImageObject();
//        //将图片的长和宽缩小味原来的1/2
////        Bitmap bitmap=BitmapFactory.decodeFile(imgPath,getBitmapOption(2));
//
//        Bitmap bitmap=getBitmap(imgPath);
//        imageObject.setImageObject(bitmap);
//        return imageObject;
//    }
//
//    private BitmapFactory.Options getBitmapOption(int inSampleSize){
//        System.gc();
//        BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inPurgeable = true;
//        options.inSampleSize = inSampleSize;
//        return options;
//    }
//
//    /**
//     * 根据图片的url路径获得Bitmap对象  (必须在子线程里执行)
//     * @param url
//     * @return
//     */
//    public Bitmap getBitmap(String url) {
//        Bitmap bm = null;
//        try {
//            URL iconUrl = new URL(url);
//            URLConnection conn = iconUrl.openConnection();
//            HttpURLConnection http = (HttpURLConnection) conn;
//
//            int length = http.getContentLength();
//
//            conn.connect();
//            // 获得图像的字符流
//            InputStream is = conn.getInputStream();
//            BufferedInputStream bis = new BufferedInputStream(is, length);
//            bm = BitmapFactory.decodeStream(bis);
//            bis.close();
//            is.close();// 关闭流
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        return bm;
//    }
//
//    private class SelfWbAuthListener implements com.sina.weibo.sdk.auth.WbAuthListener {
//        @Override
//        public void onSuccess(final Oauth2AccessToken token) {
//            MainActivity.this.runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    mAccessToken = token;
//                    if (mAccessToken.isSessionValid()) {
//                        Log.e("CXP", mAccessToken.getToken());
//                        AccessTokenKeeper.writeAccessToken(mContext, mAccessToken);
//                        Map<String, String> map = new HashMap<>();
//                        map.put("access_token", mAccessToken.getToken());
//                        map.put("uid", mAccessToken.getUid());
//                        getOkHttp("https://api.weibo.com/2/users/show.json?access_token=" + mAccessToken.getToken() + "&uid=" + mAccessToken.getUid(), new Callback() {
//                            @Override
//                            public void onFailure(Call call, IOException e) {
//                                Toast.makeText(mContext,
//                                        "失败", Toast.LENGTH_SHORT).show();
//                            }
//
//                            @Override
//                            public void onResponse(Call call, Response response) throws IOException {
//
//
//                                Gson gson = new Gson();
//                                Map<String, Object> map = gson.fromJson(response.body().string(), new TypeToken<Map<String, Object>>() {
//                                }.getType());
//                                Log.e("CXP", "11111");
//
//                                Toast.makeText(mContext,
//                                        "成功", Toast.LENGTH_SHORT).show();
//
//                            }
//                        });
//                    }
//                }
//            });
//        }
//
//        @Override
//        public void cancel() {
//            Toast.makeText(mContext,
//                    "取消", Toast.LENGTH_SHORT).show();
//        }
//
//        @Override
//        public void onFailure(WbConnectErrorMessage errorMessage) {
//            Toast.makeText(mContext, "失败", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        // SSO 授权回调
//        // 重要：发起 SSO 登陆的 Activity 必须重写 onActivityResults
//        if (mSsoHandler != null) {
//            mSsoHandler.authorizeCallBack(requestCode, resultCode, data);
//        }
//    }
//
//    //    private  UMAuthListener authListener = new UMAuthListener() {
////        /**
////         * @desc 授权开始的回调
////         * @param platform 平台名称
////         */
////        @Override
////        public void onStart(SHARE_MEDIA platform) {
////
////        }
////
////        /**
////         * @desc 授权成功的回调
////         * @param platform 平台名称
////         * @param action 行为序号，开发者用不上
////         * @param data 用户资料返回
////         */
////        @Override
////        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
////
////            Toast.makeText(mContext, "成功了", Toast.LENGTH_LONG).show();
////
////        }
////
////        /**
////         * @desc 授权失败的回调
////         * @param platform 平台名称
////         * @param action 行为序号，开发者用不上
////         * @param t 错误原因
////         */
////        @Override
////        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
////
////            Toast.makeText(mContext, "失败：" + t.getMessage(),                                     Toast.LENGTH_LONG).show();
////        }
////
////        /**
////         * @desc 授权取消的回调
////         * @param platform 平台名称
////         * @param action 行为序号，开发者用不上
////         */
////        @Override
////        public void onCancel(SHARE_MEDIA platform, int action) {
////            Toast.makeText(mContext, "取消", Toast.LENGTH_LONG).show();
////        }
////    };
//}
