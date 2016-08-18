package atlas.com.trainerapp.widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

import com.jakewharton.rxbinding.view.RxView;

import rx.Observable;

/**
 * Created by paulo.losbanos on 17/08/2016.
 */
public class TAButton extends Button {
    Context mContext;

    public TAButton(Context context) {
        super(context);
        init(context);
    }

    public TAButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TAButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        Typeface tf = Typeface.createFromAsset(mContext.getAssets(), "fonts/Montserrat-Regular.otf");
        setTypeface(tf);
    }

    public Observable<Void> clickObservable() {
        return RxView.clicks(this);
    }


}
