package atlas.com.trainerapp.authentication.presenters;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import atlas.com.trainerapp.authentication.presenters.interfaces.SignInListener;
import atlas.com.trainerapp.bases.BasePresenter;
import atlas.com.trainerapp.main.views.MainActivity;
import rx.Observable;

/**
 * Created by paulo.losbanos on 17/08/2016.
 */
public class AuthPresenter extends BasePresenter{

    public FirebaseAuth mAuth;
    public FirebaseAuth.AuthStateListener mAuthListener;

    FirebaseUser mUser;
    Activity mInstance;

    boolean isLoggedin = false;

    public AuthPresenter(Activity activity,View main) {
        super(activity,main);
        mInstance = activity;
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // Usera is signed in
                    mUser = user;
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // Usera is signed out
                    mUser = null;
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                ((SignInListener) activity).onSignIn(mUser);
            }
        };
    }

    public void onStartAuth() {
        mAuth.addAuthStateListener(mAuthListener);
    }

    public void onStopAuth() { if (mAuthListener != null) { mAuth.removeAuthStateListener(mAuthListener); } }

    public void goToHome() {
        if (!isLoggedin) {
            mInstance.finish();
            mInstance.startActivity(new Intent(mInstance, MainActivity.class));
            isLoggedin = true;
        }
    }
        //mAuth.signOut();
}
