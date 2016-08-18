package atlas.com.trainerapp.widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;

import com.jakewharton.rxbinding.widget.RxTextView;

import rx.Observable;

/**
 * Created by paulo.losbanos on 17/08/2016.
 */
public class TAEditText extends EditText {
    Context mContext;

    public TAEditText(Context context) {
        super(context);
        init(context);
    }

    public TAEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TAEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        Typeface tf = Typeface.createFromAsset(mContext.getAssets(), "fonts/Montserrat-Regular.otf");
        setTypeface(tf);
    }

    public Observable<CharSequence> textChange() {
        return RxTextView.textChanges(this);
    }
}
