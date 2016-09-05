package atlas.com.trainerapp.firstTimeLogin.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import atlas.com.trainerapp.R;
import atlas.com.trainerapp.bases.BaseFragment;
import atlas.com.trainerapp.bases.interfaces.FragmentBindingSpecs;
import atlas.com.trainerapp.databinding.FragmentSelectGuildBinding;
import atlas.com.trainerapp.firstTimeLogin.presenters.interfaces.FragmentFormGroup;

/**
 * Created by paulo.losbanos on 01/09/2016.
 */
public class SelectGuildFragment extends BaseFragment<FragmentSelectGuildBinding> implements FragmentBindingSpecs{

    private FragmentFormGroup mFormGroup;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final ViewGroup rootview = (ViewGroup) inflater.inflate(getLayoutId(), container, false);
        mContainer = container;
        mInflater = inflater;
        setBindingSpecs(this);
        init();
        return getBinding().getRoot();
    }

    public SelectGuildFragment(){}

    public SelectGuildFragment(FragmentFormGroup mFormGroup,int position) {
        this.mFormGroup = mFormGroup;
    }

    private void init() {
    }

    @Override
    public LayoutInflater getLayoutInflater() {
        return mInflater;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_select_guild;
    }

    @Override
    public ViewGroup getViewGroup() {
        return mContainer;
    }
}