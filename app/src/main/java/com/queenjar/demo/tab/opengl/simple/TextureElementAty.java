package com.queenjar.demo.tab.opengl.simple;

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
public class TextureElementAty extends BaseDemoAty {
    private Context mContext;
    private GLSurfaceView mGLSurfaceView;
    private int mGLProgramID = 0;
    private static final float POSITION[] = new float[]{
            -1f, 1f,
            1f, -1f,
            -1f, -1f,
            1f, 1f,
    };
    private static final float TEXTCOORS[] = new float[]{
            0f, 0f,
            1f, 1f,
            0f, 1f,
            1f, 0f,
    };
    private static final short ORDER_TABLE[] = new short[]{
            0, 1, 2,
            0, 1, 3,
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        mGLSurfaceView = new GLSurfaceView(this);
        setContentView(mGLSurfaceView);
        mGLSurfaceView.setEGLContextClientVersion(2);
        mGLSurfaceView.setPreserveEGLContextOnPause(true);
        mGLSurfaceView.setRenderer(new GLSurfaceView.Renderer() {
            @Override
            public void onSurfaceCreated(GL10 gl, EGLConfig config) {
                GLES20.glClearColor(1f, 0f, 0f, 1f);
                mGLProgramID = ShaderHelper.getProgram(
                        AssetsHelper.getFileContent(mContext, "demo/tab/opengl/simple/texture_elment.vert"),
                        AssetsHelper.getFileContent(mContext, "demo/tab/opengl/simple/texture_elment.frag"));
            }

            @Override
            public void onSurfaceChanged(GL10 gl, int width, int height) {
                GLES20.glViewport(0, 0, width, height);
            }

            @Override
            public void onDrawFrame(GL10 gl) {
                int textureID = TextureHelper.initTextureID(AssetsHelper.getBitmap(mContext, "karen.PNG"), true);
                GLES20.glUseProgram(mGLProgramID);
                int positionHandle = GLES20.glGetAttribLocation(mGLProgramID, "aPosition");
                int textcoorHandle = GLES20.glGetAttribLocation(mGLProgramID, "aTextureCoord");
                int uBGTextureHandle = GLES20.glGetAttribLocation(mGLProgramID, "uBackgroundTexture");
                GLES20.glActiveTexture(GLES20.GL_TEXTURE0);
                GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, textureID);
                GLES20.glUniform1i(uBGTextureHandle, 0);
                GLES20.glEnableVertexAttribArray(positionHandle);
                GLES20.glEnableVertexAttribArray(textcoorHandle);
                GLES20.glVertexAttribPointer(positionHandle, 2, GLES20.GL_FLOAT, false, 0, ArrayToBufferHelper.floatArrayToBuffer(POSITION));
                GLES20.glVertexAttribPointer(textcoorHandle, 2, GLES20.GL_FLOAT, false, 0, ArrayToBufferHelper.floatArrayToBuffer(TEXTCOORS));
                GLES20.glDrawElements(GLES20.GL_TRIANGLES, ORDER_TABLE.length, GLES20.GL_UNSIGNED_SHORT, ArrayToBufferHelper.shortArrayToBuffer(ORDER_TABLE));
                GLES20.glDisableVertexAttribArray(positionHandle);
                GLES20.glDisableVertexAttribArray(textcoorHandle);
            }
        });
        mGLSurfaceView.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mGLSurfaceView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mGLSurfaceView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
