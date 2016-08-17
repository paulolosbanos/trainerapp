package atlas.com.trainerapp.bases;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;

import atlas.com.trainerapp.bases.interfaces.ActivityBindingSpecs;

/**
 * Created by paulo.losbanos on 17/08/2016.
 */
public class BaseActivity<BindingClass> extends AppCompatActivity {

    BindingClass mBinding;
    ActivityBindingSpecs mSpecs;

    public void setBindingSpecs(ActivityBindingSpecs specs) {
        mSpecs = specs;
        mBinding = (BindingClass) DataBindingUtil.setContentView(mSpecs.getActivity(), mSpecs.getLayoutId());
    }

    public BindingClass getBinding() {
        return mBinding;
    }


}
