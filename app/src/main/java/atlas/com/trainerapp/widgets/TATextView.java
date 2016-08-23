package atlas.com.trainerapp.widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;

import rx.Observable;

/**
 * Created by paulo.losbanos on 17/08/2016.
 */
public class TATextView extends TextView {
    Context mContext;
    Typeface mTypeFace;

    public TATextView(Context context) {
        super(context);
        init(context);
    }

    public TATextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TATextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        mTypeFace = Typeface.createFromAsset(mContext.getAssets(),"fonts/Montserrat-Regular.otf");

        setTypeface(mTypeFace);
    }

    public Typeface typeFace() {
        return mTypeFace;
    }

    public Observable<Void> clickObservable() {
        return RxView.clicks(this);
    }
}
