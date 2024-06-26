package net.srfennec.lib.util;


public class RenderUtils {
    public static class rgbaColor{
        int r;int g;int b;int a;
        public rgbaColor(int r, int g, int b, int a){
            this.r = r;
            this.g = g;
            this.b = b;
            this.a = a;
        }
        public rgbaColor(int r, int g, int b){
            this(r,g,b,255);
        }
    }
    public static rgbaColor mergeColor(rgbaColor colorA, rgbaColor colorB, float amount){
        return new rgbaColor(
                (int) (colorA.r+(colorB.r*amount)),
                (int) (colorA.g+(colorB.g*amount)),
                (int) (colorA.b+(colorB.b*amount)),
                (int) (colorA.a+(colorB.a*amount))
        );
    }

    public static int rgbaToDec(int red, int green, int blue, int alpha) {
        red = Math.min(255, Math.max(0, red));
        green = Math.min(255, Math.max(0, green));
        blue = Math.min(255, Math.max(0, blue));
        alpha = Math.min(255, Math.max(0, alpha));
        return (alpha << 24) | (red << 16) | (green << 8) | blue;
    }
    public static int rgbaToDec(rgbaColor color){
        return rgbaToDec(color.r,color.g,color.b,color.a);
    }
}
