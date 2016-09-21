package atlas.com.trainerapp.main.views.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import atlas.com.trainerapp.R;
import atlas.com.trainerapp.main.views.MainActivity;
import atlas.com.trainerapp.main.views.fragments.BattleFragment;
import atlas.com.trainerapp.main.views.fragments.ChatFragment;
import atlas.com.trainerapp.main.views.fragments.TrainerFragment;
import atlas.com.trainerapp.widgets.TATextView;

/**
 * Created by paulo.losbanos on 24/08/2016.
 */
public class MainViewAdapter extends FragmentStatePagerAdapter {

    public static final int NUM_PAGES = 3;
    public static final int TRAINER = 0;
    public static final int BATTLE = 1;
    public static final int CHAT = 2;
    public static final int TRADE = 3;

    public static final String[] TITLE = {"TRAINER","BATTLE","CHAT","TRADE"};
    Context mContext;
    public MainViewAdapter(FragmentManager fm, MainActivity mainActivity) {
        super(fm);
        mContext = mainActivity;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TrainerFragment();
            case 1:
                return new BattleFragment();
            case 2:
                return new ChatFragment();
            default:
                return new Fragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return TITLE[TRAINER];
            case 1:
                return TITLE[BATTLE];
            case 2:
                return TITLE[CHAT];
            default:
                return TITLE[TRADE];
        }
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }

    public View getCustomView(int position) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.tab_main,null);
        TATextView tv = (TATextView) v.findViewById(R.id.tv_tab_title);
        tv.setText(TITLE[position]);
        return v;
    }
}
