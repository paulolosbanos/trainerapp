package atlas.com.trainerapp.authentication.views;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import java.util.concurrent.TimeUnit;

import atlas.com.trainerapp.R;
import atlas.com.trainerapp.authentication.views.adapters.AuthPagerAdapter;
import atlas.com.trainerapp.bases.BaseActivity;
import atlas.com.trainerapp.bases.interfaces.ActivityBindingSpecs;
import atlas.com.trainerapp.databinding.ActivityAuthBinding;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by paulo.losbanos on 17/08/2016.
 */
public class AuthActivity extends BaseActivity<ActivityAuthBinding> implements ActivityBindingSpecs {

    AuthPagerAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        setBindingSpecs(this);
        mAdapter = new AuthPagerAdapter(getSupportFragmentManager());
        getBinding().pager.setAdapter(mAdapter);
        getBinding().pager.setCurrentItem(AuthPagerAdapter.ORIGIN);

        Observable.just(true)
                .delay(2, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(bool -> getBinding().pager.setCurrentItem(0,bool));

    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_auth;
    }
}
