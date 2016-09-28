package atlas.com.trainerapp.firstTimeLogin.models;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import atlas.com.trainerapp.utils.GsonUtils;

/**
 * Created by paulo.losbanos on 06/09/2016.
 */
public class Pokemon {
    private Long id;
    private String name;
    private HashMap<String, Abilities> abilities;
    private HashMap<String, Moves> moves;
    private HashMap<String, Stats> stats;
    private HashMap<String, Typing> typing;

    private HashMap<String, Moves> selectedMoves;
    private List<String> efforValues;
    private String ability;
    private String item;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Abilities> getAbilities() {
        return abilities;
    }

    public void setAbilities(HashMap<String, Abilities> abilities) {
        this.abilities = abilities;
    }

    public HashMap<String, Moves> getMoves() {
        return moves;
    }

    public void setMoves(HashMap<String, Moves> moves) {
        this.moves = moves;
    }

    public HashMap<String, Stats> getStats() {
        return stats;
    }

    public void setStats(HashMap<String, Stats> stats) {
        this.stats = stats;
    }

    public HashMap<String, Typing> getTyping() {
        return typing;
    }

    public void setTyping(HashMap<String, Typing> typing) {
        this.typing = typing;
    }

    public JSONObject getJSONTyping() throws JSONException {
        return GsonUtils.toJSONObject(GsonUtils.toJSONString(typing));
    }

    public HashMap<String, Moves> getSelectedMoves() {
        return selectedMoves;
    }

    public void setSelectedMoves(HashMap<String, Moves> selectedMoves) {
        this.selectedMoves = selectedMoves;
    }

    public List<String> getEfforValues() {
        return efforValues;
    }

    public void setEfforValues(List<String> efforValues) {
        this.efforValues = efforValues;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public List<String> getListMoves() {
        List<String> temp = new ArrayList<>();
        for (String key : moves.keySet()) {
            temp.add(moves.get(key).getMove());
        }
        return temp;
    }

    public List<String> getListAbilities() {
        List<String> temp = new ArrayList<>();
        for (String key : abilities.keySet()) {
            temp.add(abilities.get(key).getName());
        }
        return temp;
    }
}
