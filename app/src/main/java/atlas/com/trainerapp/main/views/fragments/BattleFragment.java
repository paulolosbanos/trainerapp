package atlas.com.trainerapp.main.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import atlas.com.trainerapp.R;
import atlas.com.trainerapp.bases.BaseFragment;
import atlas.com.trainerapp.bases.interfaces.FragmentBindingSpecs;
import atlas.com.trainerapp.databinding.FragmentBattleBinding;
import atlas.com.trainerapp.main.presenters.fragmentPresenters.BattlePresenter;

/**
 * Created by paulo.losbanos on 24/08/2016.
 */
public class BattleFragment extends BaseFragment<FragmentBattleBinding> implements FragmentBindingSpecs{

    BattlePresenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.fragment_battle, container, false);
        mContainer = container;
        mInflater = inflater;
        setBindingSpecs(this);

        mPresenter = new BattlePresenter(getActivity(),getBinding().llMainBodyBattle);
        init();
        return getBinding().getRoot();
    }

    private void init() {

    }

    @Override
    public LayoutInflater getLayoutInflater() {
        return mInflater;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_battle;
    }

    @Override
    public ViewGroup getViewGroup() {
        return mContainer;
    }
}
