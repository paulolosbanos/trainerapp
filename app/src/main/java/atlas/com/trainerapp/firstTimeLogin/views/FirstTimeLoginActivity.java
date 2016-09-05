package atlas.com.trainerapp.firstTimeLogin.views;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;

import com.jakewharton.rxbinding.support.v4.view.RxViewPager;

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
    public static final String UID = "uid";
    public static final String TAG = "FirstTimeLoginActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_time);
        setBindingSpecs(this);
        String uid = getIntent().getStringExtra(UID);
        mAdapter = new FirstTimeLoginAdapter(getSupportFragmentManager(), this, uid,getBinding().ivInputAcceptIndicator);
        init();
    }

    private void init() {
        String format = getBinding().tvIndicator.getText().toString();
        getBinding().pgrFirstTime.setAdapter(mAdapter);
        getBinding().pgrFirstTime.setScrollDurationFactor(3);
        getBinding().ibNext.setEnabled(false);
        getBinding().ibPrevious.setEnabled(false);
        getBinding().tvIndicator.setVisibility(View.GONE);
        getBinding().ibNext.setVisibility(View.GONE);
        getBinding().ibPrevious.setVisibility(View.GONE);
        RxViewPager.pageSelections(getBinding().pgrFirstTime)
                .subscribe(position -> {
                    getBinding().tvIndicator.setText(String.format(format, (position)));
                    if (position == 5) {
                        getBinding().tvIndicator.setVisibility(View.GONE);
                        getBinding().ibNext.setVisibility(View.GONE);
                        getBinding().ibPrevious.setVisibility(View.GONE);
                        getBinding().ibNext.setEnabled(false);
                        getBinding().ibPrevious.setEnabled(false);
                    } else if (position > 1) {
                        getBinding().ibPrevious.setEnabled(true);
                    } else{
                        getBinding().ibPrevious.setEnabled(false);
                    }
                });

        getBinding().ibPrevious.clickObservable()
                .subscribe(aVoid -> {
                    int current = getBinding().pgrFirstTime.getCurrentItem();
                    if (current > 1)
                        getBinding().pgrFirstTime.setCurrentItem(current - 1);
                });

        getBinding().ibNext.clickObservable()
                .subscribe(aVoid -> {
                    int current = getBinding().pgrFirstTime.getCurrentItem();
                    if (current < mAdapter.getCount() - 1 && mAdapter.isAnswered(current)) {
                        getBinding().pgrFirstTime.setCurrentItem(current + 1);
                        getBinding().ivInputAcceptIndicator.setVisibility(View.INVISIBLE);
                    }
                });

        Observable.just(true)
                .delay(3, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(bool -> {
                    getBinding().pgrFirstTime.setCurrentItem(1);
                    getBinding().tvIndicator.setText(String.format(format, 1));
                    getBinding().ibNext.setEnabled(true);
                    getBinding().tvIndicator.setVisibility(View.VISIBLE);
                    getBinding().ibNext.setVisibility(View.VISIBLE);
                    getBinding().ibPrevious.setVisibility(View.VISIBLE);
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
