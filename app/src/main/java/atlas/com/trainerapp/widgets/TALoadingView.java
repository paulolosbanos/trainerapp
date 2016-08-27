package atlas.com.trainerapp.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import atlas.com.trainerapp.R;

/**
 * Created by paulo.losbanos on 24/08/2016.
 */
public class TALoadingView extends LinearLayout {

    Context mContext;
    Animation rotation;
    ImageView ico;
    public TALoadingView(Context context) {
        super(context);
        init(context);
    }

    public TALoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TALoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context context) {
        mContext = context;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.view_loading, this, true);
        ico = (ImageView) v.findViewById(R.id.iv_logo);

        rotation = AnimationUtils.loadAnimation(mContext,R.anim.rotate);
        rotation.setFillAfter(true);
        ico.startAnimation(rotation);
    }

    public void stopLoading() {
        ico.clearAnimation();
    }
}
