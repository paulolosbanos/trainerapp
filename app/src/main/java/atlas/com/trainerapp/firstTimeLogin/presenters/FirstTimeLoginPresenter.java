package atlas.com.trainerapp.firstTimeLogin.presenters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import java.util.concurrent.TimeUnit;

import atlas.com.trainerapp.authentication.models.User;
import atlas.com.trainerapp.bases.BasePresenter;
import atlas.com.trainerapp.main.views.MainActivity;
import atlas.com.trainerapp.managers.DataManager;
import atlas.com.trainerapp.managers.UserDataManager;

/**
 * Created by paulo.losbanos on 14/09/2016.
 */
public class FirstTimeLoginPresenter extends BasePresenter {

    private UserDataManager mUserDataManager;
    private DataManager mDataManager;
    private Context mInstance;
    public FirstTimeLoginPresenter(Context context, View layout) {
        super(context, layout);
        mInstance = context;
        mUserDataManager = UserDataManager.getInstance();
        mDataManager = DataManager.getInstance();
    }

    public void updateUser(User newUser) {
        newUser.setUniqueId(mUserDataManager.getUser().getUniqueId());
        mDataManager.updateData(newUser, mUserDataManager.getUser().getUniqueId())
                .delay(3, TimeUnit.SECONDS)
                .subscribe(aBoolean -> {
                    if(aBoolean) {
                        mUserDataManager.setUser(newUser);
                        Log.e(TAG,"user updated");
                        mInstance.startActivity(new Intent(mInstance, MainActivity.class));
                    } else {
                        Log.e(TAG,"update: fail");
                    }
                });
    }
}
