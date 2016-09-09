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

    int[] id = {R.id.hex_black, R.id.hex_blue, R.id.hex_red, R.id.hex_yellow,R.id.hex_white,R.id.hex_grey};
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
        mView = inflater.inflate(R.layout.view_hexagon, this, true);
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
        TAImageView iv = (TAImageView) mView.findViewById(R.id.hex_black);
        iv.setVisibility(View.GONE);
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

    private int getTypingColor(String color) {
        return R.id.hex_yellow;
    }

    private void hideAll(View v) {
        for (int i : id) {
            TAImageView view = (TAImageView) v.findViewById(i);
            view.setVisibility(View.GONE);
        }
    }

    public Observable<Void> clickObservable(){
        return RxView.clicks(this);
    }

    public static final String YELLOW = "yellow";
    public static final String BLUE = "blue";
    public static final String RED = "red";
    public static final String BLACK = "black";
    public static final String WHITE = "white";
    public static final String GREY = "grey";
}
