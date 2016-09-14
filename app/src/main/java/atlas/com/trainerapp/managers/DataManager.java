package atlas.com.trainerapp.managers;

import android.util.Log;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import atlas.com.trainerapp.bases.BaseModel;
import rx.Observable;

/**
 * Created by paulo.losbanos on 27/08/2016.
 */
public class DataManager {

    protected final String TAG = getClass().getSimpleName();
    private static DataManager mInstance;

    private static DatabaseReference mDatabase;
    public static DataManager getInstance() {
        if(mInstance == null) {
            mInstance = new DataManager();
        }
        return mInstance;
    }

    public DataManager() {
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public Observable<Boolean> addData(BaseModel object) {
        if(mDatabase != null) {
            Task add =  mDatabase.child(object.getNode()).child(object.getUid()).setValue(object);

            if(add.isSuccessful()) {
                return Observable.just(true);
            } else {
                return Observable.just(false);
            }

        } else {
            Log.e(TAG,"mDatabase is null");
        }
        return Observable.just(false);
    }

    public Observable<Boolean> updateData(BaseModel object,String uid) {
        if(mDatabase != null) {
            mDatabase.child(object.getNode()).child(uid).setValue(object);
        }
        return Observable.just(true);
    }
}
