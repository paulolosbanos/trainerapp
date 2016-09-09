package atlas.com.trainerapp.firstTimeLogin.presenters.interfaces.retrofit;

import atlas.com.trainerapp.authentication.models.User;
import atlas.com.trainerapp.firstTimeLogin.models.Pokemon;
import atlas.com.trainerapp.managers.RetrofitManager;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by paulo.losbanos on 07/09/2016.
 */
public interface FTLService {

    @GET("db_pkmn/{name}.json?auth="+ RetrofitManager.AUTHKEY)
    Observable<Pokemon> getPokemon(@Path("name") String name);
}
