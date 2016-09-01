package atlas.com.trainerapp.utils;

import com.google.gson.Gson;

/**
 * Created by paulo.losbanos on 01/09/2016.
 */
public class GsonUtils {

    public static String toJSON(Object obj) {
        return new Gson().toJson(obj);
    }
}
