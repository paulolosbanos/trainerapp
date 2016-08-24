package atlas.com.trainerapp.authentication.views;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.TimeUnit;

import atlas.com.trainerapp.R;
import atlas.com.trainerapp.authentication.presenters.AuthPresenter;
import atlas.com.trainerapp.authentication.presenters.interfaces.SignInListener;
import atlas.com.trainerapp.authentication.views.adapters.AuthPagerAdapter;
import atlas.com.trainerapp.bases.BaseActivity;
import atlas.com.trainerapp.bases.interfaces.ActivityBindingSpecs;
import atlas.com.trainerapp.databinding.ActivityAuthBinding;
import atlas.com.trainerapp.widgets.TANonSwipePager;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by paulo.losbanos on 17/08/2016.
 */
public class AuthActivity extends BaseActivity<ActivityAuthBinding> implements ActivityBindingSpecs,SignInListener {

    AuthPagerAdapter mAdapter;
    AuthPresenter mAuthPresenter;
    public TANonSwipePager mPager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        setBindingSpecs(this);

        mAdapter = new AuthPagerAdapter(getSupportFragmentManager());
        getBinding().pager.setAdapter(mAdapter);
        getBinding().pager.setCurrentItem(AuthPagerAdapter.ORIGIN);
        mPager = getBinding().pager;
        mAuthPresenter = new AuthPresenter(this);

    }

    @Override
    public void onSignIn(FirebaseUser user) {
        Observable.just(true)
                .delay(2, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(bool -> {
                    if (user != null) {
                        mAuthPresenter.goToHome();
                    } else {
                        getBinding().pager.setCurrentItem(AuthPagerAdapter.LOGIN,true);
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuthPresenter.onStartAuth();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAuthPresenter.onStopAuth();
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
