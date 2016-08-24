package atlas.com.trainerapp.main.presenters;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;

import com.google.firebase.auth.FirebaseAuth;

import atlas.com.trainerapp.authentication.views.AuthActivity;
import atlas.com.trainerapp.bases.BasePresenter;

/**
 * Created by paulo.losbanos on 24/08/2016.
 */
public class MainPresenter extends BasePresenter {

    public FirebaseAuth mAuth;
    FragmentActivity mFragmentActivity;
    Context mContext;

    public MainPresenter(FragmentActivity fa) {
        mAuth = FirebaseAuth.getInstance();
        mContext = fa;
        mFragmentActivity = fa;
    }

    public void signOut() {
        mAuth.signOut();
        mFragmentActivity.startActivity(new Intent(mContext, AuthActivity.class));
    }
}
