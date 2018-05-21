package com.queenjar.helper;

import com.queenjar.ihelper.ILogHelper;

/**
 * <pre>
 *     打印帮助类，具体的打印实现方式将由{@link #setLogHelper(ILogHelper)}的内容去实现
 *     The log helper class, what to print depends upon the content that set by {@link #setLogHelper(ILogHelper)}
 * </pre>
 * Created by QueenJar
 * Wechat: queenjar
 */
public class QJLogHelper {
    private static ILogHelper mLogHelper;
    private static boolean sIsLogDebug = true;

    /**
     * <pre>
     *     设置ILogHelper实例
     *     set the ILogHelper instance
     * </pre>
     *
     * @param logHelper ILogHelper instance
     */
    public static void setLogHelper(ILogHelper logHelper) {
        mLogHelper = logHelper;
    }

    /**
     * <pre>
     *     打印
     *     print
     * </pre>
     */
    public static void d(String tag, String content) {
        if (sIsLogDebug && mLogHelper != null) {
            mLogHelper.d(tag, content);
        }
    }

    /**
     * <pre>
     *     打印错误信息
     *     print the exception message
     * </pre>
     */
    public static void e(String tag, String content) {
        if (sIsLogDebug && mLogHelper != null) {
            mLogHelper.e(tag, content);
        }
    }

    /**
     * <pre>
     *     打印错误信息
     *     print the exception message
     * </pre>
     */
    public static void e(String tag, String content, Exception e) {
        if (sIsLogDebug && mLogHelper != null) {
            mLogHelper.e(tag, content, e);
        }
    }

    /**
     * <pre>
     *     得到调用此方法的线程的线程名
     *     get the Thread name
     * </pre>
     */
    public static String getThreadName() {
        if (sIsLogDebug && mLogHelper != null) {
            return mLogHelper.getThreadName();
        }
        return "";
    }

    /**
     * <pre>
     *     是否是Debug模式，是的话将不会打印内容
     *     there will no content to print if it is a Debug mode
     * </pre>
     *
     * @return true:Debug mode
     */
    public static boolean isLogDebug() {
        if (sIsLogDebug && mLogHelper != null) {
            return mLogHelper.isLogDebug();
        }
        return sIsLogDebug;
    }

    /**
     * <pre>
     *     设置是否是Debug模式
     *     set if it is a Debug mode
     * </pre>
     *
     * @param isLogDebug true:Debug mode
     */
    public static void setLogDebug(boolean isLogDebug) {
        if (mLogHelper != null) {
            mLogHelper.setLogDebug(isLogDebug);
        }
        sIsLogDebug = isLogDebug;
    }

    /**
     * <pre>
     *     得到Log的根tag
     *     get the root tag
     * </pre>
     */
    public static String getRootTag() {
        if (sIsLogDebug && mLogHelper != null) {
            return mLogHelper.getRootTag();
        }
        return "";
    }

    /**
     * <pre>
     *     设置Log的根TAG
     *     set the root TAG
     * </pre>
     */
    public static void setRootTag(String rootTag) {
        if (sIsLogDebug && mLogHelper != null) {
            mLogHelper.setRootTag(rootTag);
        }
    }
}