package atlas.com.trainerapp.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import atlas.com.trainerapp.R;
import atlas.com.trainerapp.firstTimeLogin.models.Pokemon;
import rx.Observable;

/**
 * Created by paulo.losbanos on 05/09/2016.
 */
public class TATeamView extends RelativeLayout {

    Context mContext;
    private View mView;
    List<Pokemon> roster = new ArrayList<>();
    SlotClick mListener;
    RosterCount mListenerRosterCount;
    int[] slotId = {R.id.slot_1, R.id.slot_2, R.id.slot_3, R.id.slot_4, R.id.slot_5, R.id.slot_6};

    public TATeamView(Context context) {
        super(context);
        init(context);
    }

    public TATeamView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TATeamView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context context) {
        mContext = context;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.view_layout_ta_teamview, this, true);
    }

    public void addPokemon(Pokemon pkmn) throws JSONException {
        roster.add(pkmn);
        updateView();
//        TAHexagonView view = (TAHexagonView) mView.findViewById(R.id.slot_1);
//        view.setVisibility(INVISIBLE);
//        view.setVisibility(VISIBLE);
        mListenerRosterCount.OnRosterCountUpdate(roster.size());
    }

    public void removePokemon(Pokemon pokemon) throws JSONException {
        remove(pokemon.getName());
        updateView();
        mListenerRosterCount.OnRosterCountUpdate(roster.size());
    }

    private void remove(String name) {
        for(int i = 0;i < roster.size();i++) {
            Pokemon p = roster.get(i);
            if(p.getName().equals(name)) {
                roster.remove(p);
                TAHexagonView view = (TAHexagonView) mView.findViewById(slotId[i]);
                view.setColor(TAHexagonView.GREY);
            }
        }
    }


    public void slotClick(SlotClick listener) {
        mListener = listener;
        for(int i = 0;i < slotId.length;i++) {
            TAHexagonView view = (TAHexagonView) mView.findViewById(slotId[i]);
            final int id = i;
            view.clickObservable().subscribe(aVoid -> {
                if(mListener != null) mListener.OnSlotClick(roster.get(id).getName());
            });
        }
    }

    public void rosterCountUpdate(RosterCount listener) {
        mListenerRosterCount = listener;
    }

    private void updateView() throws JSONException {
        for (int i = 0; i < slotId.length; i++) {
            if(roster.size() > i) {
                TAHexagonView view = (TAHexagonView) mView.findViewById(slotId[i]);
                String type = roster.get(i).getJSONTyping().getJSONObject("slot-1").getString("type");
                view.setColor(type);
            } else {
                TAHexagonView view = (TAHexagonView) mView.findViewById(slotId[i]);
                view.setColor(TAHexagonView.GREY);
            }
        }
    }

    public static final int SLOT_ONE = 0;
    public static final int SLOT_TWO = 1;
    public static final int SLOT_THREE = 2;
    public static final int SLOT_FOUR = 3;
    public static final int SLOT_FIVE = 4;
    public static final int SLOT_SIX = 5;


    public interface SlotClick {
        void OnSlotClick(String name);
    }

    public interface RosterCount {
        void OnRosterCountUpdate(int count);
    }

}
