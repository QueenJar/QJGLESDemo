precision mediump float;
uniform sampler2D uBackgroundTexture;
varying vec2 vTextureCoord;

void main() {
    gl_FragColor = texture2D(uBackgroundTexture, vTextureCoord);
}