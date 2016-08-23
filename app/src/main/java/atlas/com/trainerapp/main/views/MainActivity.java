package atlas.com.trainerapp.main.views;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import atlas.com.trainerapp.R;
import atlas.com.trainerapp.bases.BaseActivity;
import atlas.com.trainerapp.bases.interfaces.ActivityBindingSpecs;
import atlas.com.trainerapp.databinding.ActivityMainBinding;

/**
 * Created by paulo.losbanos on 19/08/2016.
 */
public class MainActivity extends BaseActivity<ActivityMainBinding> implements ActivityBindingSpecs {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setBindingSpecs(this);
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }
}
