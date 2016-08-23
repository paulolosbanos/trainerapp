package atlas.com.trainerapp.authentication.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import atlas.com.trainerapp.R;
import atlas.com.trainerapp.authentication.presenters.fragmentPresenters.RegisterPresenter;
import atlas.com.trainerapp.authentication.views.AuthActivity;
import atlas.com.trainerapp.authentication.views.adapters.AuthPagerAdapter;
import atlas.com.trainerapp.bases.BaseFragment;
import atlas.com.trainerapp.bases.interfaces.FragmentBindingSpecs;
import atlas.com.trainerapp.databinding.FragmentRegisterBinding;

/**
 * Created by paulo.losbanos on 18/08/2016.
 */
public class RegisterFragment extends BaseFragment<FragmentRegisterBinding> implements FragmentBindingSpecs {

    RegisterPresenter mRegisterPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflater.inflate(R.layout.fragment_register, container, false);
        mInflater = inflater;
        mContainer = container;
        setBindingSpecs(this);
        mRegisterPresenter = new RegisterPresenter(getActivity(),getBinding().llMainBody);
        init();
        return getBinding().getRoot();
    }

    private void init() {
        getBinding().etUsername.textChange().subscribe(uname -> mRegisterPresenter.setUsername(uname));
        getBinding().etPassword.textChange().subscribe(pword -> mRegisterPresenter.setPassword(pword));
        getBinding().etEmail.textChange().subscribe(email -> mRegisterPresenter.setEmail(email));
        getBinding().btnRegister.clickObservable().subscribe(aVoid -> mRegisterPresenter.clickRegister());
        getBinding().btnBack.clickObservable()
                .map(aVoid -> (AuthActivity) getActivity())
                .map(parent -> parent.mPager)
                .subscribe(pager -> pager.setCurrentItem(AuthPagerAdapter.LOGIN,true));
    }

    @Override
    public LayoutInflater getLayoutInflater() {
        return mInflater;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_register;
    }

    @Override
    public ViewGroup getViewGroup() {
        return mContainer;
    }
}
