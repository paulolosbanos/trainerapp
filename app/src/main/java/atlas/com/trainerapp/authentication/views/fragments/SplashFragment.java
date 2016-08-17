package atlas.com.trainerapp.authentication.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import atlas.com.trainerapp.R;
import atlas.com.trainerapp.bases.BaseFragment;
import atlas.com.trainerapp.bases.interfaces.FragmentBindingSpecs;
import atlas.com.trainerapp.databinding.FragmentSplashBinding;
import rx.Observable;

/**
 * Created by paulo.losbanos on 17/08/2016.
 */
public class SplashFragment extends BaseFragment<FragmentSplashBinding> implements FragmentBindingSpecs{

    LayoutInflater mInflater;
    ViewGroup mContainer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.fragment_splash, container, false);
        mContainer = container;
        mInflater = inflater;
        setBindingSpecs(this);
        return rootview;
    }

    @Override
    public LayoutInflater getLayoutInflater() {
        return mInflater;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_splash;
    }

    @Override
    public ViewGroup getViewGroup() {
        return mContainer;
    }
}
