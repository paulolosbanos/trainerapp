package atlas.com.trainerapp.bases;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by paulo.losbanos on 18/08/2016.
 */
public class BasePresenter {
    protected final String TAG = getClass().getSimpleName();
    protected Context mContext;
    protected View mParentView;
    public BasePresenter(Context context,View layout) {
        mContext = context;
        mParentView = layout;
        Log.d(TAG,"CREATED");
    }
}
