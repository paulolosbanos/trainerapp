package atlas.com.trainerapp.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.jakewharton.rxbinding.view.RxView;

import rx.Observable;

/**
 * Created by paulo.losbanos on 23/08/2016.
 */
public class TAImageView extends ImageView {

    Context mContext;

    public TAImageView(Context context) {
        super(context);
    }

    public TAImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TAImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Observable<Void> clickObservable() {
        return RxView.clicks(this);
    }
}
