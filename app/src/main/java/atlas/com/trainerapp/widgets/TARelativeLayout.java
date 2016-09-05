package atlas.com.trainerapp.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.jakewharton.rxbinding.view.RxView;

import rx.Observable;

/**
 * Created by paulo.losbanos on 05/09/2016.
 */
public class TARelativeLayout extends RelativeLayout {
    Context mContext;

    public TARelativeLayout(Context context) {
        super(context);
        init(context);
    }

    public TARelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TARelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context context) {
        mContext = context;
    }

    public Observable<Void> clickObservable() {
        return RxView.clicks(this);
    }
}
