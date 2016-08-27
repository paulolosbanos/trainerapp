package atlas.com.trainerapp.authentication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import atlas.com.trainerapp.bases.BaseModel;

/**
 * Created by paulo.losbanos on 19/08/2016.
 */
public class User extends BaseModel {

    @SerializedName("group")
    @Expose
    private String group;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("teams")
    @Expose
    private List<Team> teams = new ArrayList<Team>();

    public User(String uid) {
        super(uid);
    }

    /**
     * @return The group
     */
    public String getGroup() {
        return group;
    }

    /**
     * @param group The group
     */
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * @return The username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return The teams
     */
    public List<Team> getTeams() {
        return teams;
    }

    /**
     * @param teams The teams
     */
    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    @Override
    public String getNode() {
        return "users";
    }
}
