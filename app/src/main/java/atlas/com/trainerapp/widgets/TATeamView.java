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

/**
 * Created by paulo.losbanos on 05/09/2016.
 */
public class TATeamView extends RelativeLayout {

    Context mContext;
    private View mView;
    List<Pokemon> roster = new ArrayList<>();
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

    }

    private void updateView() throws JSONException  {
        for (int i = 0; i < roster.size(); i++) {
            TAHexagonView view = (TAHexagonView) mView.findViewById(slotId[i]);
            String type = roster.get(i).getJSONTyping().getJSONObject("slot-1").getString("type");
            view.setColor(type);
        }
    }

}
