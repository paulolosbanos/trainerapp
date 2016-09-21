package atlas.com.trainerapp.firstTimeLogin.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import atlas.com.trainerapp.R;
import atlas.com.trainerapp.authentication.models.Team;
import atlas.com.trainerapp.bases.BaseFragment;
import atlas.com.trainerapp.bases.interfaces.FragmentBindingSpecs;
import atlas.com.trainerapp.databinding.FragmentSelectTeamBinding;
import atlas.com.trainerapp.firstTimeLogin.presenters.SelectTeamFragmentPresenter;
import atlas.com.trainerapp.firstTimeLogin.presenters.interfaces.FragmentFormGroup;
import atlas.com.trainerapp.widgets.TAEditText;
import atlas.com.trainerapp.widgets.TATeamView;
import atlas.com.trainerapp.widgets.TATextView;
import rx.Observable;
import rx.functions.Action1;

/**
 * Created by paulo.losbanos on 01/09/2016.
 */
public class SelectTeamFragment extends BaseFragment<FragmentSelectTeamBinding> implements FragmentBindingSpecs {
    public static final String TAG = "SelectTeamFragment";
    private FragmentFormGroup mFormGroup;
    SelectTeamFragmentPresenter mPresenter;
    TATextView[] tvSuggestion = new TATextView[2];
    int mFragmentPosition;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final ViewGroup rootview = (ViewGroup) inflater.inflate(getLayoutId(), container, false);
        mContainer = container;
        mInflater = inflater;
        setBindingSpecs(this);
        mPresenter = new SelectTeamFragmentPresenter(getContext(), getBinding().rlMainBody);
        tvSuggestion[0] = getBinding().tvSuggest1;
        tvSuggestion[1] = getBinding().tvSuggest2;
        init();
        return getBinding().getRoot();
    }

    public SelectTeamFragment() {
    }

    public SelectTeamFragment(FragmentFormGroup mFormGroup, int position) {
        this.mFormGroup = mFormGroup;
        this.mFragmentPosition = position;
    }

    private void init() {
//        String defaultText = getBinding().tvSuggest1.getText().toString();
        hideSuggestion(true);
        mPresenter.addPokemon("pikachu",getBinding().teamView);
        mPresenter.addPokemon("squirtle",getBinding().teamView);
        mPresenter.addPokemon("bulbasaur",getBinding().teamView);
        mPresenter.addPokemon("zubat",getBinding().teamView);
        mPresenter.addPokemon("caterpie",getBinding().teamView);
        mPresenter.addPokemon("pidgey",getBinding().teamView);

        getBinding().etSetupTeam.setButtonListener(isCheck -> {
            if(isCheck) {
                mPresenter.addPokemon(getBinding().etSetupTeam.getText().toString(),getBinding().teamView);
                getBinding().etSetupTeam.setText("");
            } else {
                mPresenter.deletePokemon(getBinding().etSetupTeam.getText().toString(),getBinding().teamView);
                getBinding().etSetupTeam.setText("");
            }
        });

        getBinding().teamView.slotClick(name -> {
            if (name != null)
                getBinding().etSetupTeam.setText(name);
        });

        getBinding().teamView.rosterCountUpdate(count -> {
            if(count == 6) {
                Log.e(TAG,count+"");
                ArrayList<Team> teams = new ArrayList<>();
                teams.add(mPresenter.getNewTeam());
                mFormGroup.onAnswer(mFragmentPosition, teams);
                mFormGroup.isAnswerAccepted(true);
            }
        });

        getBinding().tvSuggest1.clickObservable().subscribe(aVoid -> {
            hideSuggestion(true);
            getBinding().etSetupTeam.setText(getBinding().tvSuggest1.getText().toString());
        });
        getBinding().tvSuggest2.clickObservable().subscribe(aVoid -> {
            hideSuggestion(true);
            getBinding().etSetupTeam.setText(getBinding().tvSuggest2.getText().toString());
        });
    }

    private void hideSuggestion(boolean b) {
        if(b) {
            getBinding().tvSuggestionLabel.setVisibility(View.INVISIBLE);
            getBinding().tvSuggest1.setVisibility(View.INVISIBLE);
            getBinding().tvSuggest2.setVisibility(View.INVISIBLE);
            getBinding().tvSuggest1.setClickable(false);
            getBinding().tvSuggest2.setClickable(false);
        } else {
            getBinding().tvSuggestionLabel.setVisibility(View.VISIBLE);
            getBinding().tvSuggest1.setVisibility(View.VISIBLE);
            getBinding().tvSuggest2.setVisibility(View.VISIBLE);
            getBinding().tvSuggest1.setClickable(true);
            getBinding().tvSuggest2.setClickable(true);
        }
    }

    @Override
    public LayoutInflater getLayoutInflater() {
        return mInflater;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_select_team;
    }

    @Override
    public ViewGroup getViewGroup() {
        return mContainer;
    }
}
