package atlas.com.trainerapp.managers;

import atlas.com.trainerapp.authentication.models.Auth;
import atlas.com.trainerapp.authentication.models.User;

/**
 * Created by paulo.losbanos on 14/09/2016.
 */
public class UserDataManager {

    protected final String TAG = getClass().getSimpleName();
    private static UserDataManager mInstance;

    private User user;
    private Auth auth;

    public static UserDataManager getInstance() {
        if(mInstance == null) {
            mInstance = new UserDataManager();
        }
        return mInstance;
    }

    public UserDataManager() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Auth getAuth() {
        return auth;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }
}
