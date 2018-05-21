package com.queenjar.helper.java;

import com.queenjar.helper.QJALogHelper;

/**
 * 打印帮助类
 *
 * @author dengchukun
 */
public class LogHelper extends QJALogHelper {


    /**
     * 打印log详细信息 相见LogDemo类和MainActivity类 最好是每个方法中都调用此方法
     */
    public void d(String tag, String content) {
        System.out.println(tag + ":" + content);
    }

    @Override
    public void e(String tag, String content) {
        System.out.println(tag + ":" + content);
    }

    @Override
    public void e(String tag, String content, Exception e) {
        System.out.println(tag + ":" + content + " e=" + e.getMessage());
    }

}
