package com.queenjar.helper.android;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

/**
 * <pre>
 * </pre>
 * Created by QueenJar
 * Wechat: queenjar
 */
public class ToastHelper {
    private static boolean sIsToastDebug = true;

    public static void showToast(Context context, String content) {
        if (sIsToastDebug) {
            Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * <pre>
     *  弹出一个Toast，主要用于非主线程中
     * </pre>
     *
     * @param context
     * @param content
     */
    public static void showToastOnUIThread(final Context context, final String content) {
        Handler h = new Handler(Looper.getMainLooper());
        h.post(new Runnable() {
            @Override
            public void run() {
                if (sIsToastDebug) {
                    Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
