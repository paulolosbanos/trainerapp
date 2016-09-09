package atlas.com.trainerapp.bases;

/**
 * Created by paulo.losbanos on 27/08/2016.
 */
public abstract class BaseModel {

    public String uid;

    public BaseModel(String uid) {
        super();
        this.uid = uid;
    }

    public BaseModel() {

    }


    public abstract String getNode();

    public String getUid() {
        return uid;
    }
}
