package atlas.com.trainerapp.widgets;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.jakewharton.rxbinding.widget.RxTextView;

import rx.Observable;

/**
 * Created by paulo.losbanos on 17/08/2016.
 */
public class TAEditText extends EditText implements View.OnTouchListener {
    Context mContext;
    private Drawable dRight, dLeft;
    public static final String TAG = "TAEditText";
    private ButtonListener mListener;

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
        if(dRight != null)
            setOnTouchListener(this);
    }

    public void setButtonListener(ButtonListener listener) {
        mListener = listener;
    }

    public void clearButtons() {
        this.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }

    @Override
    public void setCompoundDrawables(Drawable left, Drawable top, Drawable right, Drawable bottom) {

        if(left != null) {
            dLeft = left;
        }

        if(right != null) {
            dRight = right;
        }

        super.setCompoundDrawables(left, top, right, bottom);
    }

    public void showRightDrawable() {
        this.setCompoundDrawablesWithIntrinsicBounds(null, null, dRight, null);
    }

    public Observable<CharSequence> textChange() {
        return RxTextView.textChanges(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        final int DRAWABLE_LEFT = 0;
        final int DRAWABLE_RIGHT = 2;

        if(event.getAction() == MotionEvent.ACTION_UP) {
            if(event.getRawX() >= (getRight() - getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                mListener.OnCheck();
                return false;
            } else if(event.getRawX() <= (getCompoundDrawables()[DRAWABLE_LEFT].getBounds().width())) {
                mListener.OnCross();
                return false;
            }
        }
        return false;
    }

    public interface ButtonListener {
        void OnCheck();
        void OnCross();
    }
}
