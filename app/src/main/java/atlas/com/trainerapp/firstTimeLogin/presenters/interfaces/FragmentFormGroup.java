package atlas.com.trainerapp.firstTimeLogin.presenters.interfaces;

import atlas.com.trainerapp.authentication.models.User;

/**
 * Created by paulo.losbanos on 02/09/2016.
 */
public interface FragmentFormGroup {

    void onAnswer(int position,Object answer);
    void isAnswerAccepted(boolean isAccepted);
    User getNewUserData();
}
