package com.queenjar.demo.tab.opengl.psblend;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.queenjar.demo.tab.BaseDemoAty;
import com.queenjar.helper.android.res.AssetsHelper;
import com.queenjar.helper.java.nio.ArrayToBufferHelper;
import com.queenjar.helper.jopengl.ShaderHelper;
import com.queenjar.helper.jopengl.TextureHelper;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * <pre>
 *     简单的展示
 * </pre>
 * Created by QueenJar
 * Wechat: queenjar
 */
public class NormalAty extends PSBlendAty {
    @Override
    public String getVertexShaderPathFromAssets() {
        return "demo/tab/opengl/psblend/normal.vert";
    }

    @Override
    public String getFragmentShaderPathFromAssets() {
        return "demo/tab/opengl/psblend/normal.frag";
    }
}
