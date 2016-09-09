package atlas.com.trainerapp.firstTimeLogin.presenters;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import atlas.com.trainerapp.authentication.models.Team;
import atlas.com.trainerapp.bases.BasePresenter;
import atlas.com.trainerapp.firstTimeLogin.models.Pokemon;
import atlas.com.trainerapp.firstTimeLogin.presenters.interfaces.retrofit.FTLService;
import atlas.com.trainerapp.managers.RetrofitManager;
import atlas.com.trainerapp.widgets.TATeamView;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by paulo.losbanos on 06/09/2016.
 */
public class SelectTeamFragmentPresenter extends BasePresenter {
    private DatabaseReference mDatabase;
    private Team mTeam = new Team();
    private FTLService mFTLService;
    private RetrofitManager mRetrofitManager;

    public SelectTeamFragmentPresenter(Context context, View layout) {
        super(context, layout);
        mDatabase = FirebaseDatabase.getInstance().getReference("db_pkmn");
        mTeam.setMembers(new ArrayList<>());
        mRetrofitManager = RetrofitManager.getInstance();
        mFTLService = mRetrofitManager.getRetrofitInstance().create(FTLService.class);
    }

    public void addPokemon(String pkmnName, TATeamView teamView) {
        if (!mTeam.getMembers().contains(pkmnName)) {
            mTeam.getMembers().add(pkmnName);
            mFTLService.getPokemon(pkmnName)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread()).
                    subscribe(pokemon -> {
                        Log.e(TAG, pokemon.getName());
                        try {
                            teamView.addPokemon(pokemon);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    });
        }



    }

    public Team getNewTeam() {
        return mTeam;
    }

    private void getPokemon(String s, ValueEventListener listener) {
        if (s.isEmpty() || s.length() < 3) return;
        mDatabase.orderByChild("name")
                .startAt(s)
                .endAt(s + "\uf8ff")
                .limitToFirst(2)
                .addValueEventListener(listener);
    }

    public Observable<List<String>> getSuggestionObservable(String stringKey) {
        return Observable.create(new Observable.OnSubscribe<List<String>>() {

            @Override
            public void call(Subscriber<? super List<String>> subscriber) {
                getPokemon(stringKey, new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        List<String> pkmn = new ArrayList<String>();
                        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                            Pokemon pokemon = postSnapshot.getValue(Pokemon.class);
                            pkmn.add(pokemon.getName());
                        }
                        if (!subscriber.isUnsubscribed()) {
                            subscriber.onNext(pkmn);
                            subscriber.onCompleted();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        if (!subscriber.isUnsubscribed()) {
                            subscriber.onError(new Exception());
                        }
                    }
                });
            }
        });
    }
}
