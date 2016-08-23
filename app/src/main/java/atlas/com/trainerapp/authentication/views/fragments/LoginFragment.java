package atlas.com.trainerapp.authentication.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import atlas.com.trainerapp.authentication.views.AuthActivity;
import atlas.com.trainerapp.authentication.views.adapters.AuthPagerAdapter;
import atlas.com.trainerapp.bases.BaseFragment;
import atlas.com.trainerapp.R;
import atlas.com.trainerapp.bases.interfaces.FragmentBindingSpecs;
import atlas.com.trainerapp.databinding.FragmentLoginBinding;

/**
 * Created by paulo.losbanos on 17/08/2016.
 */
public class LoginFragment extends BaseFragment<FragmentLoginBinding> implements FragmentBindingSpecs{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.fragment_login, container, false);
        mContainer = container;
        mInflater = inflater;
        setBindingSpecs(this);
        init();
        return getBinding().getRoot();
    }

    private void init() {
        getBinding().tvRegister.clickObservable()
                .map(aVoid -> (AuthActivity) getActivity())
                .map(parent -> parent.mPager)
                .subscribe(pager -> pager.setCurrentItem(AuthPagerAdapter.REGISTER,true));
    }

    @Override
    public LayoutInflater getLayoutInflater() {
        return mInflater;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    public ViewGroup getViewGroup() {
        return mContainer;
    }
}
