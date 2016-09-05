package atlas.com.trainerapp.utils;

import android.util.DisplayMetrics;

/**
 * Created by paulo.losbanos on 02/09/2016.
 */
public class DeviceUtils {

    public static String density(int value) {
       switch (value) {
           case DisplayMetrics.DENSITY_MEDIUM:  return "MDPI";
           case DisplayMetrics.DENSITY_HIGH:    return "HDPI";
           case DisplayMetrics.DENSITY_XHIGH:   return "XHDPI";
           case DisplayMetrics.DENSITY_XXHIGH:  return "XXHDPI";
           case DisplayMetrics.DENSITY_XXXHIGH: return "XXXHDPI";
       }
        return "value: "+value;
    }
}
