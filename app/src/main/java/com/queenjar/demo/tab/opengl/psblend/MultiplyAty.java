package com.queenjar.demo.tab.opengl.psblend;

/**
 * <pre>
 *     正片叠底（多重混合）
 * </pre>
 * Created by QueenJar
 * Wechat: queenjar
 */
public class MultiplyAty extends PSBlendAty {
    @Override
    public String getVertexShaderPathFromAssets() {
        return "demo/tab/opengl/psblend/multiply.vert";
    }

    @Override
    public String getFragmentShaderPathFromAssets() {
        return "demo/tab/opengl/psblend/multiply.frag";
    }
}
