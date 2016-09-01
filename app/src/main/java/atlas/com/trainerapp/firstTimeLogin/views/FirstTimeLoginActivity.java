package atlas.com.trainerapp.firstTimeLogin.views;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;

import java.util.concurrent.TimeUnit;

import atlas.com.trainerapp.R;
import atlas.com.trainerapp.bases.BaseActivity;
import atlas.com.trainerapp.bases.interfaces.ActivityBindingSpecs;
import atlas.com.trainerapp.databinding.ActivityFirstTimeBinding;
import atlas.com.trainerapp.firstTimeLogin.views.adapters.FirstTimeLoginAdapter;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by paulo.losbanos on 01/09/2016.
 */
public class FirstTimeLoginActivity extends BaseActivity<ActivityFirstTimeBinding> implements ActivityBindingSpecs {

    FirstTimeLoginAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_time);
        setBindingSpecs(this);
        mAdapter = new FirstTimeLoginAdapter(getSupportFragmentManager(), this);
        init();
    }

    private void init() {
        getBinding().pgrFirstTime.setAdapter(mAdapter);
        getBinding().pgrFirstTime.setScrollDurationFactor(3);
        Observable.just(true)
                .delay(2, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(bool -> {
                    getBinding().pgrFirstTime.setCurrentItem(1);
                });
    }


    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_first_time;
    }
}
