package atlas.com.trainerapp.main.presenters;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

import atlas.com.trainerapp.authentication.views.AuthActivity;
import atlas.com.trainerapp.bases.BasePresenter;

/**
 * Created by paulo.losbanos on 24/08/2016.
 */
public class MainPresenter extends BasePresenter {

    public FirebaseAuth mAuth;

    public MainPresenter(FragmentActivity fa, View main) {
        super(fa,main);
        mAuth = FirebaseAuth.getInstance();

    }

    public void signOut() {
        mAuth.signOut();
        mContext.startActivity(new Intent(mContext, AuthActivity.class));
    }
}
