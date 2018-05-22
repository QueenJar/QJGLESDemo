package com.queenjar.helper.android;

import android.util.Log;

import com.queenjar.helper.imp.QJALogHelper;

/**
 * <pre>
 *     log help class
 *     打印帮助类
 * </pre>
 * Created by QuennJar on 2018/3/22.
 * Wechat: queenjar
 */
public class LogHelper extends QJALogHelper {

    public void d(String tag, String content) {
        Log.d(tag, content);
    }

    public void e(String tag, String content) {
        Log.e(tag, content);
    }

    public void e(String tag, String content, Exception e) {
        Log.e(tag, content + " e=" + e.getMessage());
    }

}
