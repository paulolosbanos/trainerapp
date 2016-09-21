package atlas.com.trainerapp.utils;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import atlas.com.trainerapp.R;

/**
 * Created by paulo.losbanos on 19/09/2016.
 */
public class ColorUtils {

    public static int getColor(Context context, String colorType) {
        switch (colorType) {
            case "bug":
                return ContextCompat.getColor(context, R.color.color_type_bug);
            case "dark":
                return ContextCompat.getColor(context, R.color.color_type_dark);
            case "dragon":
                return ContextCompat.getColor(context, R.color.color_type_dragon);
            case "electric":
                return ContextCompat.getColor(context, R.color.color_type_electric);
            case "fairy":
                return ContextCompat.getColor(context, R.color.color_type_fairy);
            case "fighting":
                return ContextCompat.getColor(context, R.color.color_type_fighting);
            case "fire":
                return ContextCompat.getColor(context, R.color.color_type_fire);
            case "flying":
                return ContextCompat.getColor(context, R.color.color_type_flying);
            case "ghost":
                return ContextCompat.getColor(context, R.color.color_type_ghost);
            case "grass":
                return ContextCompat.getColor(context, R.color.color_type_grass);
            case "ground":
                return ContextCompat.getColor(context, R.color.color_type_ground);
            case "ice":
                return ContextCompat.getColor(context, R.color.color_type_ice);
            case "normal":
                return ContextCompat.getColor(context, R.color.color_type_normal);
            case "poison":
                return ContextCompat.getColor(context, R.color.color_type_poison);
            case "psychic":
                return ContextCompat.getColor(context, R.color.color_type_psychic);
            case "rock":
                return ContextCompat.getColor(context, R.color.color_type_rock);
            case "steel":
                return ContextCompat.getColor(context, R.color.color_type_steel);
            case "water":
                return ContextCompat.getColor(context, R.color.color_type_water);
            default:
                return ContextCompat.getColor(context, R.color.brand_white);
        }
    }

    /**
     *
     *
     <color name="color_type_bug">#8FA401</color>
     <color name="color_type_dark">#4D3A2E</color>
     <color name="color_type_dragon">#4700F3</color>
     <color name="color_type_electric">#F0BF00</color>
     <color name="color_type_fairy">#F334FF</color>
     <color name="color_type_fighting">#C82506</color>
     <color name="color_type_fire">#E05D07</color>
     <color name="color_type_flying">#8D6EDA</color>
     <color name="color_type_ghost">#4F3773</color>
     <color name="color_type_grass">#5AB22D</color>
     <color name="color_type_ground">#D2A732</color>
     <color name="color_type_ice">#71C7C6</color>
     <color name="color_type_normal">#989A5F</color>
     <color name="color_type_poison">#7B1E7D</color>
     <color name="color_type_psychic">#F5125B</color>
     <color name="color_type_rock">#927E1F</color>
     <color name="color_type_steel">#9694B8</color>
     <color name="color_type_water">#3C60EC</color>
     *
     */
}
