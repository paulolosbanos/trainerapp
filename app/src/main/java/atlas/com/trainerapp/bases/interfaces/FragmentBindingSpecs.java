package atlas.com.trainerapp.bases.interfaces;

import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by paulo.losbanos on 17/08/2016.
 */
public interface FragmentBindingSpecs {

    LayoutInflater getLayoutInflater();
    int getLayoutId();
    ViewGroup getViewGroup();

}
