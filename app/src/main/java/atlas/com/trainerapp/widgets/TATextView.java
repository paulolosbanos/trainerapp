package atlas.com.trainerapp.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;

import atlas.com.trainerapp.R;
import rx.Observable;

/**
 * Created by paulo.losbanos on 17/08/2016.
 */
public class TATextView extends TextView {
    Context mContext;
    Typeface mTypeFace;

    public TATextView(Context context) {
        super(context);
        init(context,null);
    }

    public TATextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public TATextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mContext = context;
        mTypeFace = Typeface.createFromAsset(mContext.getAssets(),"fonts/Montserrat-Regular.otf");
        String font = "";
        if(attrs != null) {
            TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TATextViewFont, 0, 0);
            try {
                font = ta.getString(R.styleable.TATextViewFont_font);
            } finally {
                ta.recycle();
            }
            chooseFont(font);
        }
        setTypeface(mTypeFace);
    }

    private void chooseFont(String font) {
        if(font != null)
            switch (font) {
                case BARIOL:
                    mTypeFace = Typeface.createFromAsset(mContext.getAssets(),"fonts/Bariol.ttf");
                    break;
                case MONTSERRAT:
                    mTypeFace = Typeface.createFromAsset(mContext.getAssets(),"fonts/Montserrat-Regular.otf");
                    break;
                default:
                    mTypeFace = Typeface.createFromAsset(mContext.getAssets(),"fonts/Montserrat-Regular.otf");
            }
        else {
            mTypeFace = Typeface.createFromAsset(mContext.getAssets(),"fonts/Montserrat-Regular.otf");
        }
    }

    public Typeface typeFace() {
        return mTypeFace;
    }

    public Observable<Void> clickObservable() {
        return RxView.clicks(this);
    }

    public static final String BARIOL = "bariol";
    public static final String MONTSERRAT = "montserrat";

}
