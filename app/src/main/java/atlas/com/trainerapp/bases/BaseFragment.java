package atlas.com.trainerapp.bases;

import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;

import atlas.com.trainerapp.bases.interfaces.ActivityBindingSpecs;
import atlas.com.trainerapp.bases.interfaces.FragmentBindingSpecs;

/**
 * Created by paulo.losbanos on 17/08/2016.
 */
public class BaseFragment<BindingClass> extends Fragment {

    BindingClass mBinding;
    FragmentBindingSpecs mSpecs;

    public void setBindingSpecs(FragmentBindingSpecs specs) {
        mSpecs = specs;
        mBinding = (BindingClass) DataBindingUtil.inflate(mSpecs.getLayoutInflater(), mSpecs.getLayoutId(),mSpecs.getViewGroup(),false);
    }

    public BindingClass getBinding() {
        return mBinding;
    }

}
