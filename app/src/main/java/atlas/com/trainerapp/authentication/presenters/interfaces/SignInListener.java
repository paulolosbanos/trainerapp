package atlas.com.trainerapp.authentication.presenters.interfaces;

import com.google.firebase.auth.FirebaseUser;

import rx.Observable;

/**
 * Created by paulo.losbanos on 18/08/2016.
 */
public interface SignInListener {

    void onSignIn(FirebaseUser user);
}
