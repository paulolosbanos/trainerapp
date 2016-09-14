package atlas.com.trainerapp.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.rxbinding.view.RxView;

import atlas.com.trainerapp.R;
import rx.Observable;

/**
 * Created by paulo.losbanos on 29/08/2016.
 */
public class TAHexagonView extends LinearLayout {
    Context mContext;

    int[] id = {R.id.hex_black, R.id.hex_blue, R.id.hex_red, R.id.hex_yellow, R.id.hex_white, R.id.hex_grey};
    private View mView;

    public TAHexagonView(Context context) {
        super(context);
        init(context, null);
    }

    public TAHexagonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public TAHexagonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        this.mContext = context;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.view_hexagon, this, false);
        addView(mView);
        String color = "";
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.Hexagon, 0, 0);
        try {
            color = ta.getString(R.styleable.Hexagon_hexColorString);
        } finally {
            ta.recycle();
        }

        hideAll(mView);
        TAImageView showHexView = (TAImageView) mView.findViewById(switchColor(color.toLowerCase()));
        showHexView.setVisibility(View.VISIBLE);
    }

    public void setColor(String color) {
        hideAll(mView);
        TAImageView iv = (TAImageView) mView.findViewById(switchColor(color.toLowerCase()));
        iv.setVisibility(View.VISIBLE);
    }

    private int switchColor(String color) {

        switch (color) {
            case YELLOW:
                return R.id.hex_yellow;
            case BLUE:
                return R.id.hex_blue;
            case RED:
                return R.id.hex_red;
            case BLACK:
                return R.id.hex_black;
            case WHITE:
                return R.id.hex_white;
            case GREY:
                return R.id.hex_grey;
            default:
                return getTypingColor(color);
        }
    }

    private void hideAll(View v) {
        for (int i : id) {
            TAImageView view = (TAImageView) v.findViewById(i);
            view.setVisibility(View.GONE);
        }
    }

    public Observable<Void> clickObservable() {
        return RxView.clicks(this);
    }

    private int getTypingColor(String color) {
        switch (color) {
            case BUG:       return R.id.hex_bug;
            case DARK:      return R.id.hex_dark;
            case DRAGON:    return R.id.hex_dragon;
            case FAIRY:     return R.id.hex_fairy;
            case FIRE:      return R.id.hex_fire;
            case FLYING:    return R.id.hex_flying;
            case GHOST:     return R.id.hex_ghost;
            case GRASS:     return R.id.hex_grass;
            case GROUND:    return R.id.hex_ground;
            case ICE:       return R.id.hex_ice;
            case NORMAL:    return R.id.hex_normal;
            case POISON:    return R.id.hex_poison;
            case PSYCHIC:   return R.id.hex_psychic;
            case ELECTRIC:  return R.id.hex_yellow;
            case WATER:     return R.id.hex_blue;
            case FIGHTING:  return R.id.hex_red;
        }
        return 0;
    }


    public static final String YELLOW = "yellow";   //electric
    public static final String BLUE = "blue";       //water
    public static final String RED = "red";         //fighting
    public static final String BLACK = "black";
    public static final String WHITE = "white";
    public static final String GREY = "grey";

    public static final String BUG = "bug";
    public static final String DARK = "dark";
    public static final String DRAGON = "dragon";
    public static final String FAIRY = "fairy";
    public static final String FIRE = "fire";
    public static final String FLYING = "flying";
    public static final String GHOST = "ghost";
    public static final String GRASS = "grass";
    public static final String GROUND = "ground";
    public static final String ICE = "ice";
    public static final String NORMAL = "normal";
    public static final String POISON = "poison";
    public static final String PSYCHIC = "psychic";
    public static final String ELECTRIC = "electric";
    public static final String WATER = "water";
    public static final String FIGHTING = "fighting";

}
