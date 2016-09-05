package atlas.com.trainerapp.firstTimeLogin.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
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
    private int mFragmentPosition;

    public static final String RED = "red";
    public static final String BLUE = "blue";
    public static final String YELLOW = "yellow";
    public static final String TAG = "SelectGuildFragment";
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
        this.mFragmentPosition = position;
    }

    private void init() {
        updateView(mFormGroup.getNewUserData().getGroup());
        getBinding().rlGuildBlue.clickObservable().subscribe(aVoid -> {
            updateView(BLUE);
        });
        getBinding().rlGuildRed.clickObservable().subscribe(aVoid -> {
            updateView(RED);
        });
        getBinding().rlGuildYellow.clickObservable().subscribe(aVoid -> {
            updateView(YELLOW);
        });
    }

    private void updateView(String guild) {
        if (guild == null) return;
        hideAll();
        switch (guild) {
            case RED:
                getBinding().bgRed.setVisibility(View.VISIBLE);
                break;
            case YELLOW:
                getBinding().bgYellow.setVisibility(View.VISIBLE);
                break;
            case BLUE:
                getBinding().bgBlue.setVisibility(View.VISIBLE);
                break;
        }
        mFormGroup.isAnswerAccepted(true);
        mFormGroup.onAnswer(mFragmentPosition,guild);
    }

    private void hideAll() {
        getBinding().bgBlue.setVisibility(View.INVISIBLE);
        getBinding().bgYellow.setVisibility(View.INVISIBLE);
        getBinding().bgRed.setVisibility(View.INVISIBLE);
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
