package atlas.com.trainerapp.authentication.models;

import java.util.ArrayList;
import java.util.List;

import atlas.com.trainerapp.bases.BaseModel;

/**
 * Created by paulo.losbanos on 19/08/2016.
 */
public class User extends BaseModel {

    public static final String USER = "users";

    private String firstTimeLogin = "false";
    private String group;
    private String username;
    private String friendCode;
    private List<Team> teams = new ArrayList<Team>();
    private String uniqueId;

    public User(String uid) {
        super(uid);
    }

    public User() {}

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

    public String getFirstTimeLogin() {
        return firstTimeLogin;
    }

    public void setFirstTimeLogin(String firstTimeLogin) {
        this.firstTimeLogin = firstTimeLogin;
    }

    public String getFriendCode() {
        return friendCode;
    }

    public void setFriendCode(String friendCode) {
        this.friendCode = friendCode;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public Team getMainTeam() {
        for (Team t : teams) {
            if(t.getMainTeam().equals("true")) {
                return t;
            }
        }
        return null;
    }

    @Override
    public String getNode() {
        return USER;
    }
}
