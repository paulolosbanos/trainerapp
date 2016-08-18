package atlas.com.trainerapp.authentication.presenters;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import atlas.com.trainerapp.authentication.presenters.interfaces.SignInListener;
import atlas.com.trainerapp.bases.BasePresenter;
import rx.Observable;

/**
 * Created by paulo.losbanos on 17/08/2016.
 */
public class AuthPresenter extends BasePresenter{

    public FirebaseAuth mAuth;
    public FirebaseAuth.AuthStateListener mAuthListener;

    FirebaseUser mUser;

    public AuthPresenter(SignInListener listener) {
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    mUser = user;
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    mUser = null;
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                listener.onSignIn(mUser);
            }
        };
    }

    public void onStartAuth() {
        mAuth.addAuthStateListener(mAuthListener);
    }

    public void onStopAuth() { if (mAuthListener != null) { mAuth.removeAuthStateListener(mAuthListener); } }

    public void goToHome() {
        Log.e(TAG,"user "+ mUser);
    }
}
