package atlas.com.trainerapp.main.views.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONException;

import atlas.com.trainerapp.R;
import atlas.com.trainerapp.authentication.models.Team;
import atlas.com.trainerapp.bases.BaseFragment;
import atlas.com.trainerapp.bases.interfaces.FragmentBindingSpecs;
import atlas.com.trainerapp.databinding.FragmentTrainerBinding;
import atlas.com.trainerapp.firstTimeLogin.models.Pokemon;
import atlas.com.trainerapp.main.presenters.fragmentPresenters.TrainerPresenter;
import atlas.com.trainerapp.managers.UserDataManager;
import atlas.com.trainerapp.utils.ColorUtils;
import atlas.com.trainerapp.utils.GsonUtils;
import atlas.com.trainerapp.widgets.TAHexagonView;
import atlas.com.trainerapp.widgets.TATeamView;
import atlas.com.trainerapp.widgets.TATextView;

/**
 * Created by paulo.losbanos on 24/08/2016.
 */
public class TrainerFragment extends BaseFragment<FragmentTrainerBinding> implements FragmentBindingSpecs {

    TrainerPresenter mPresenter;
    UserDataManager mUserDataManager;
    ViewGroup mView;
    int[] id = {R.id.tv_slot_1, R.id.tv_slot_2, R.id.tv_slot_3, R.id.tv_slot_4, R.id.tv_slot_5, R.id.tv_slot_6};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.fragment_trainer, container, false);
        mContainer = container;
        mInflater = inflater;
        setBindingSpecs(this);
        mUserDataManager = UserDataManager.getInstance();
        mPresenter = new TrainerPresenter(getActivity(), getBinding().llMainBodyTrainer);
        mView = rootview;
        init();
        return getBinding().getRoot();
    }

    private void init() {
        getBinding().tvTrainerCode.setText(mUserDataManager.getUser().getFriendCode());
        getBinding().tvTrainerIgn.setText(mUserDataManager.getUser().getUsername());
        getBinding().hvGuildIcon.setColor(mUserDataManager.getUser().getGroup());

        getBinding().llPokemonLogo.setVisibility(View.GONE);
        getBinding().llPokemonPrimary.setVisibility(View.GONE);
        getBinding().llPokemonMoves.setVisibility(View.GONE);
        getBinding().llControls.setVisibility(View.GONE);

        getBinding().back.clickObservable().subscribe(aVoid -> {
            getBinding().rlTrainerLogo.setVisibility(View.VISIBLE);
            getBinding().teamView.setVisibility(View.VISIBLE);
            getBinding().teamNames.setVisibility(View.VISIBLE);

            getBinding().llPokemonLogo.setVisibility(View.GONE);
            getBinding().llPokemonPrimary.setVisibility(View.GONE);
            getBinding().llPokemonMoves.setVisibility(View.GONE);
            getBinding().llControls.setVisibility(View.GONE);

        });
        getBinding().teamView.slotClick(name -> {
            getBinding().rlTrainerLogo.setVisibility(View.GONE);
            getBinding().teamView.setVisibility(View.GONE);
            getBinding().teamNames.setVisibility(View.GONE);

            getBinding().llPokemonLogo.setVisibility(View.VISIBLE);
            getBinding().llPokemonPrimary.setVisibility(View.VISIBLE);
            getBinding().llPokemonMoves.setVisibility(View.VISIBLE);
            getBinding().llControls.setVisibility(View.VISIBLE);
            getBinding().save.setEnabled(false);
            Pokemon current = mPresenter.updateSlot(name);
            loadEditableData(current);
        });
        Team currentTeam = null;
        try {
            currentTeam = mPresenter.loadTeamView(mUserDataManager.getUser().getTeams(), getBinding().teamView);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        loadNames(currentTeam);
    }

    private void loadEditableData(Pokemon current) {
        //getBinding().llPokemonLogo
        //getBinding().llPokemonPrimary
        //getBinding().llPokemonMoves
        Log.e("TrainerFragment",GsonUtils.toJSONString(current));
        getBinding().hvLeftTyping2.setColor(TAHexagonView.GREY);
        getBinding().hvRightTyping2.setColor(TAHexagonView.GREY);
        getBinding().hvMidTyping1.setColor(TAHexagonView.BLACK);

        if(current.getTyping().get("slot-2") != null) {
            getBinding().hvLeftTyping2.setColor(current.getTyping().get("slot-2").getType());
            getBinding().hvRightTyping2.setColor(current.getTyping().get("slot-2").getType());
            getBinding().hvMidTyping1.setColor(current.getTyping().get("slot-1").getType());
        } else {
            getBinding().hvLeftTyping2.setColor(current.getTyping().get("slot-1").getType());
            getBinding().hvRightTyping2.setColor(current.getTyping().get("slot-1").getType());
            getBinding().hvMidTyping1.setColor(current.getTyping().get("slot-1").getType());
        }




    }

    private void loadNames(Team currentTeam) {
        for (int i = 0; i < currentTeam.getMembers().size(); i++) {
            Pokemon p = (Pokemon) GsonUtils.getObject(currentTeam.getMembers().get(i), Pokemon.class);
            TATextView slot = (TATextView) getBinding().getRoot().findViewById(id[i]);
            slot.setText(p.getName());
            try {
                slot.setBackgroundColor(ColorUtils.getColor(getActivity(), p.getJSONTyping().getJSONObject("slot-1").getString("type")));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public LayoutInflater getLayoutInflater() {
        return mInflater;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_trainer;
    }

    @Override
    public ViewGroup getViewGroup() {
        return mContainer;
    }
}
