package cn.sharesdk.demo;

/**
 * 文 件 名: AppUtils
 * 创 建 人: CXP
 * 创建日期: 2017-01-21 5:15
 * 描    述: 常用方法工具类
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class AppUtils {

    /**
     * 判断字符串是否为空
     *
     * @param object
     * @return
     */
    public static boolean isEmpty(Object object) {
        boolean flag = false;
        if (object != null && object.toString().trim().length() != 0) {
            flag = true;
        }
        return flag;
    }
}
