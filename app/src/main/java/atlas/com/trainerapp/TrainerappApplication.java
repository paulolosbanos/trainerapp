package atlas.com.trainerapp;

import android.app.Application;
import android.util.Log;

import atlas.com.trainerapp.utils.DeviceUtils;

/**
 * Created by paulo.losbanos on 02/09/2016.
 */
public class TrainerappApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("TrainerApp","Device Density: "+ DeviceUtils.density(getResources().getDisplayMetrics().densityDpi));
    }
}
