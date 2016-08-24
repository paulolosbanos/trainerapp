package atlas.com.trainerapp.main.views;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import atlas.com.trainerapp.R;
import atlas.com.trainerapp.bases.BaseActivity;
import atlas.com.trainerapp.bases.interfaces.ActivityBindingSpecs;
import atlas.com.trainerapp.databinding.ActivityMainBinding;
import atlas.com.trainerapp.main.presenters.MainPresenter;
import atlas.com.trainerapp.main.views.adapter.MainViewAdapter;
import atlas.com.trainerapp.widgets.TANonSwipePager;

/**
 * Created by paulo.losbanos on 19/08/2016.
 */
public class MainActivity extends BaseActivity<ActivityMainBinding> implements ActivityBindingSpecs {

    MainPresenter mPresenter;
    ViewPager mPager;
    MainViewAdapter mAdapter;
    TabLayout mTab;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setBindingSpecs(this);

        mAdapter = new MainViewAdapter(getSupportFragmentManager(),this);
        getBinding().pgrMain.setAdapter(mAdapter);
        getBinding().pgrMain.setCurrentItem(MainViewAdapter.TRAINER);
        mPager = getBinding().pgrMain;
        mPresenter = new MainPresenter(this,getBinding().llMainBody);

        mTab = getBinding().tabMain;
        mTab.setupWithViewPager(mPager);

        for (int i = 0;i < mTab.getTabCount();i++) {
            TabLayout.Tab tab =  mTab.getTabAt(i);
            tab.setCustomView(mAdapter.getCustomView(i));
        }

        init();
    }

    private void init() {
        getBinding().btnSignout.clickObservable()
                .subscribe(aVoid -> {
                    mPresenter.signOut();
                });
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
