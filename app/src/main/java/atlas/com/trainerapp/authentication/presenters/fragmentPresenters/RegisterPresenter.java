package atlas.com.trainerapp.authentication.presenters.fragmentPresenters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import atlas.com.trainerapp.bases.BasePresenter;
import atlas.com.trainerapp.databinding.FragmentRegisterBinding;

/**
 * Created by paulo.losbanos on 18/08/2016.
 */
public class RegisterPresenter extends BasePresenter{

    String userName;
    String password;
    String email;
    Context mContext;

    public FirebaseAuth mAuth;

    public RegisterPresenter(FragmentActivity fa) {
        mContext = fa;
        mAuth = FirebaseAuth.getInstance();
    }

    public void setUsername(CharSequence uname) {
        this.userName = uname.toString();
    }

    public void setPassword(CharSequence pword) {
        this.password = pword.toString();
    }

    public void setEmail(CharSequence email) {
        this.email = email.toString();
    }

    public void clickRegister() {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener((Activity) mContext, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (task.isSuccessful()) {
                            Log.e(TAG,"success");
                        } else {
                            Log.e(TAG,"fail");
                        }
                    }
                });
    }

}
