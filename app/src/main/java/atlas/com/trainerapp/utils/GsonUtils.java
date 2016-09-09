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
}
