package atlas.com.trainerapp.authentication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import atlas.com.trainerapp.bases.BaseModel;

/**
 * Created by paulo.losbanos on 19/08/2016.
 */
public class Team extends BaseModel {


    private String mainTeam;
    @SerializedName("members")
    @Expose
    private List<String> members = new ArrayList<String>();

    public Team(String uid) {
        super(uid);
    }

    public Team() {

    }

    @Override
    public String getNode() {
        return null;
    }

    @Override
    public String getUid() {
        return null;
    }

    public String getMainTeam() {
        return mainTeam;
    }

    public void setMainTeam(String mainTeam) {
        this.mainTeam = mainTeam;
    }

    /**
     * @return The members
     */
    public List<String> getMembers() {
        return members;
    }

    /**
     * @param members The members
     */
    public void setMembers(List<String> members) {
        this.members = members;
    }

}
