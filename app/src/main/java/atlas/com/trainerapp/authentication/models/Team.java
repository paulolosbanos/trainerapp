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

    @SerializedName("is-main-team")
    @Expose
    private Boolean isMainTeam;
    @SerializedName("members")
    @Expose
    private List<String> members = new ArrayList<String>();

    public Team(String uid) {
        super(uid);
    }

    @Override
    public String getNode() {
        return null;
    }

    @Override
    public String getUid() {
        return null;
    }

    /**
     * @return The isMainTeam
     */
    public Boolean getIsMainTeam() {
        return isMainTeam;
    }

    /**
     * @param isMainTeam The is-main-team
     */
    public void setIsMainTeam(Boolean isMainTeam) {
        this.isMainTeam = isMainTeam;
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
