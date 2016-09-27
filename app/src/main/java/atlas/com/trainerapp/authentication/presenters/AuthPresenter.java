package atlas.com.trainerapp.authentication.presenters;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.TimeUnit;

import atlas.com.trainerapp.R;
import atlas.com.trainerapp.authentication.models.Auth;
import atlas.com.trainerapp.authentication.models.User;
import atlas.com.trainerapp.authentication.presenters.interfaces.SignInListener;
import atlas.com.trainerapp.authentication.presenters.interfaces.retrofit.AuthService;
import atlas.com.trainerapp.bases.BasePresenter;
import atlas.com.trainerapp.firstTimeLogin.views.FirstTimeLoginActivity;
import atlas.com.trainerapp.main.views.MainActivity;
import atlas.com.trainerapp.managers.RetrofitManager;
import atlas.com.trainerapp.managers.UserDataManager;
import atlas.com.trainerapp.utils.DeviceUtils;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by paulo.losbanos on 17/08/2016.
 */
public class AuthPresenter extends BasePresenter {

    public FirebaseAuth mAuth;
    public FirebaseAuth.AuthStateListener mAuthListener;

    FirebaseUser mUser;
    Activity mInstance;
    AuthService mAuthService;
    RetrofitManager mRetrofitManager;
    UserDataManager mUserDataManager;

    boolean isLoggedin = false;

    public AuthPresenter(Activity activity, View main) {
        super(activity, main);
        mInstance = activity;
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = createAuthStateListener();
        mRetrofitManager = RetrofitManager.getInstance();
        mAuthService = mRetrofitManager.getRetrofitInstance().create(AuthService.class);
        mUserDataManager = UserDataManager.getInstance();

    }

    public void onStartAuth() {
        mAuth.addAuthStateListener(mAuthListener);
    }

    public void onStopAuth() {
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    public void routeUser() {
        if (!isLoggedin) {
            FirebaseDatabase.getInstance().getReference("auth").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Auth auth = dataSnapshot.getValue(Auth.class);
                    mAuthService.getUserByUid(mUser.getUid(),auth.getKey())
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(user -> {
                                boolean isNull = user == null;
                                if(isNull) {
                                    routeUser();
                                    return;
                                }
                                if (user.getFirstTimeLogin().equals("true") && !isLoggedin) {
                                    mInstance.startActivity(new Intent(mInstance, FirstTimeLoginActivity.class));
                                } else if (!isLoggedin){
                                    mInstance.startActivity(new Intent(mInstance, MainActivity.class));
                                }
                                mUserDataManager.setUser(user);
                                mUserDataManager.setAuth(auth);
                                mInstance.finish();
                                mInstance.overridePendingTransition(R.anim.slide_out,R.anim.slide_in);
                                isLoggedin = true;
                            });
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }

    public FirebaseAuth.AuthStateListener createAuthStateListener() {
        return new FirebaseAuth.AuthStateListener() {
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
                ((SignInListener) mInstance).onSignIn(mUser);
            }
        };
    }
}
