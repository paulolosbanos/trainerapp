package atlas.com.trainerapp.main.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paulo.losbanos on 19/08/2016.
 */
public class User {

    @SerializedName("team")
    @Expose
    private String team;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("teams")
    @Expose
    private List<Team> teams = new ArrayList<Team>();

    /**
     * @return The team
     */
    public String getTeam() {
        return team;
    }

    /**
     * @param team The team
     */
    public void setTeam(String team) {
        this.team = team;
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

}
