package atlas.com.trainerapp.main.presenters.fragmentPresenters;

import android.content.Context;
import android.util.Log;
import android.widget.LinearLayout;

import org.json.JSONException;

import java.util.List;

import atlas.com.trainerapp.authentication.models.Team;
import atlas.com.trainerapp.bases.BasePresenter;
import atlas.com.trainerapp.firstTimeLogin.models.Pokemon;
import atlas.com.trainerapp.utils.GsonUtils;
import atlas.com.trainerapp.widgets.TATeamView;

/**
 * Created by paulo.losbanos on 24/08/2016.
 */
public class TrainerPresenter extends BasePresenter {

    public TrainerPresenter(Context context, LinearLayout layout) {
        super(context, layout);
    }

    public Team loadTeamView(List<Team> teams, TATeamView teamView) throws JSONException {
        Team temp = null;
        for (Team current : teams) {
            if(current.getMainTeam().equals("true")) {
                temp = current;
                for(int i = 0;i < current.getMembers().size();i++) {
                    Pokemon p = (Pokemon) GsonUtils.getObject(current.getMembers().get(i), Pokemon.class);
                    teamView.addPokemon(p);
                }
                break;
            }
        }
        return temp;
    }

}
