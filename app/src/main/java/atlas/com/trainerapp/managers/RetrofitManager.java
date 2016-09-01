package atlas.com.trainerapp.managers;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by paulo.losbanos on 01/09/2016.
 */
public class RetrofitManager {

    public static final String AUTHKEY = "DuTB57gN0OXFLtwiICqeLTCWCiGXG2cb9pglXMa6";
    public static final String BASE_URL = "https://trainer-app-2edb7.firebaseio.com";
    protected final String TAG = getClass().getSimpleName();
    private static RetrofitManager mInstance;
    private Retrofit mRetrofit;

    public static RetrofitManager getInstance() {
        if(mInstance == null) {
            mInstance = new RetrofitManager();
        }
        return mInstance;
    }

    public RetrofitManager() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Retrofit getRetrofitInstance() {
        return mRetrofit;
    }

}
