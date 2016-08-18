package atlas.com.trainerapp.bases;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import atlas.com.trainerapp.bases.interfaces.ActivityBindingSpecs;
import atlas.com.trainerapp.bases.interfaces.FragmentBindingSpecs;

/**
 * Created by paulo.losbanos on 17/08/2016.
 */
public class BaseFragment<BindingClass> extends Fragment {

    BindingClass mBinding;
    FragmentBindingSpecs mSpecs;

    protected LayoutInflater mInflater;
    protected ViewGroup mContainer;

    public void setBindingSpecs(FragmentBindingSpecs specs) {
        mSpecs = specs;
        mBinding = (BindingClass) DataBindingUtil.inflate(mSpecs.getLayoutInflater(), mSpecs.getLayoutId(), mSpecs.getViewGroup(), false);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    public BindingClass getBinding() {
        return mBinding;
    }


}
