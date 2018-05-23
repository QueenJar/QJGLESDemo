precision mediump float;
uniform sampler2D uBackgroundTexture;
uniform sampler2D uForegroundTexture;
uniform float uBlendStrength;

varying vec2 vTextureCoord;

        /*
        *多重混合（正片叠底）
        */
        vec4 MultiplyBlend(vec4 bgColor, vec4 fgColor, float opacity)//多重混合
        {
            if(fgColor.a > 0.0){
                fgColor.rgb = clamp(fgColor.rgb / fgColor.a, 0.0, 1.0);

                mediump vec3 result = fgColor.rgb * bgColor.rgb;
                result = clamp(result, 0.0, 1.0);

                return vec4(mix(bgColor.rgb, result, fgColor.a * opacity), 1.0);
            }
            return bgColor;
        }

void main() {
    vec4 backgroundColor = texture2D(uBackgroundTexture, vTextureCoord);
    vec4 foregroundColor = texture2D(uForegroundTexture, vTextureCoord);

     gl_FragColor = MultiplyBlend(backgroundColor,foregroundColor,uBlendStrength);
}