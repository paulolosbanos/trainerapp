package atlas.com.trainerapp.firstTimeLogin.views.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

import atlas.com.trainerapp.authentication.models.Team;
import atlas.com.trainerapp.authentication.models.User;
import atlas.com.trainerapp.firstTimeLogin.presenters.interfaces.FragmentFormGroup;
import atlas.com.trainerapp.firstTimeLogin.views.FirstTimeLoginActivity;
import atlas.com.trainerapp.firstTimeLogin.views.fragments.InvitationFragment;
import atlas.com.trainerapp.firstTimeLogin.views.fragments.LoadingFragment;
import atlas.com.trainerapp.firstTimeLogin.views.fragments.SelectGuildFragment;
import atlas.com.trainerapp.firstTimeLogin.views.fragments.SelectTeamFragment;
import atlas.com.trainerapp.firstTimeLogin.views.fragments.SelectTrainerNameFragment;

/**
 * Created by paulo.losbanos on 01/09/2016.
 */
public class FirstTimeLoginAdapter extends FragmentStatePagerAdapter implements FragmentFormGroup {
    public static final int NUM_PAGES = 6;
    private User userUpdated;
    private ImageView mIndicator;
    Boolean[] mAnswered = {true, false, false, false, false, true};
    Context context;

    public FirstTimeLoginAdapter(FragmentManager fm, FirstTimeLoginActivity activity, String uid, ImageView ivInputAcceptIndicator) {
        super(fm);
        context = activity;
        userUpdated = new User(uid);
        mIndicator = ivInputAcceptIndicator;
    }

    public User getUpdatedUser() {
        return userUpdated;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new LoadingFragment(this, position);
            case 1:
                return new InvitationFragment(this, position);
            case 2:
                return new SelectTrainerNameFragment(this, position);
            case 3:
                return new SelectGuildFragment(this, position);
            case 4:
                return new SelectTeamFragment(this, position);
            case 5:
                return new LoadingFragment(this, position);
            default:
                return new Fragment();
        }
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }

    @Override
    public void onAnswer(int position, Object answer) {
        switch (position) {
            case 1:
                userUpdated.setFriendCode(answer.toString());
                break;
            case 2:
                userUpdated.setUsername(answer.toString());
                break;
            case 3:
                userUpdated.setGroup(answer.toString());
                break;
            case 4:
                userUpdated.setTeams((List<Team>) answer);
                break;
            default:

        }
        if (answer instanceof String) {
            if (!answer.toString().isEmpty()) {
                mAnswered[position] = true;
            } else {
                mAnswered[position] = false;
            }
        } else if (answer instanceof List) {
            if (answer != null) {
                mAnswered[position] = true;
            } else {
                mAnswered[position] = false;
            }
        } else {
            mAnswered[position] = false;
        }
    }

    @Override
    public void isAnswerAccepted(boolean isAccepted) {
        mIndicator.setVisibility(isAccepted ? View.VISIBLE : View.INVISIBLE);
    }

    public Boolean isAnswered(int position) {
        return mAnswered[position];
    }

    @Override
    public User getNewUserData() {
        return userUpdated;
    }
}
