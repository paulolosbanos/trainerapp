package atlas.com.trainerapp.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import atlas.com.trainerapp.R;

/**
 * Created by paulo.losbanos on 29/08/2016.
 */
public class TAHexagonView extends LinearLayout {
    Context mContext;

    int[] id = {R.id.hex_black, R.id.hex_blue, R.id.hex_red, R.id.hex_yellow};

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
        View v = inflater.inflate(R.layout.view_hexagon, this, true);
        String color = "";

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.Hexagon, 0, 0);
        try {
            color = ta.getString(R.styleable.Hexagon_hexColorString);
        } finally {
            ta.recycle();
        }

        hideAll(v);
        TAImageView showHexView = (TAImageView) v.findViewById(switchColor(color.toLowerCase()));
        showHexView.setVisibility(View.VISIBLE);

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
            default:
                return R.id.hex_black;
        }
    }

    private void hideAll(View v) {
        for (int i : id) {
            TAImageView view = (TAImageView) v.findViewById(i);
            view.setVisibility(View.GONE);
        }

    }

    public static final String YELLOW = "yellow";
    public static final String BLUE = "blue";
    public static final String RED = "red";
    public static final String BLACK = "black";

}