package atlas.com.trainerapp.utils;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by paulo.losbanos on 01/09/2016.
 */
public class GsonUtils {

    public static String toJSONString(Object obj) {
        return new Gson().toJson(obj);
    }
    public static JSONObject toJSONObject(String json) throws JSONException {return new JSONObject(json);}

    public static Object getObject(String jsonString,Class<?> tClass) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString,tClass);
    }
}
