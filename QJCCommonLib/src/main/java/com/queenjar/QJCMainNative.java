package com.queenjar;

/**
 * <pre>
 * </pre>
 */
public class QJCMainNative {
    static {
        System.loadLibrary("QJCGLES");
    }

    public static native int test();
}
