package atlas.com.trainerapp.authentication.views.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import atlas.com.trainerapp.authentication.views.fragments.LoginFragment;
import atlas.com.trainerapp.authentication.views.fragments.SplashFragment;

/**
 * Created by paulo.losbanos on 17/08/2016.
 */
public class AuthPagerAdapter extends FragmentStatePagerAdapter {

    public static final int NUM_PAGES = 3;
    public static final int ORIGIN = 1;

    public AuthPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new LoginFragment(); //login
            case 1:
                return new SplashFragment(); //splash
            case 2:
                return new Fragment(); //register
            default:
                return new Fragment();
        }
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
