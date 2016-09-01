package atlas.com.trainerapp.firstTimeLogin.views.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import atlas.com.trainerapp.firstTimeLogin.views.FirstTimeLoginActivity;
import atlas.com.trainerapp.firstTimeLogin.views.fragments.InvitationFragment;
import atlas.com.trainerapp.firstTimeLogin.views.fragments.LoadingFragment;
import atlas.com.trainerapp.firstTimeLogin.views.fragments.SelectGuildFragment;
import atlas.com.trainerapp.firstTimeLogin.views.fragments.SelectTeamFragment;
import atlas.com.trainerapp.firstTimeLogin.views.fragments.SelectTrainerNameFragment;

/**
 * Created by paulo.losbanos on 01/09/2016.
 */
public class FirstTimeLoginAdapter extends FragmentStatePagerAdapter {
    public static final int NUM_PAGES = 5;

    Context context;
    public FirstTimeLoginAdapter(FragmentManager fm, FirstTimeLoginActivity activity) {
        super(fm);
        context = activity;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new LoadingFragment();
            case 1:
                return new InvitationFragment();
            case 2:
                return new SelectTrainerNameFragment();
            case 3:
                return new SelectGuildFragment();
            case 4:
                return new SelectTeamFragment();
            default:
                return new Fragment();
        }
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
