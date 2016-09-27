package atlas.com.trainerapp.main.presenters;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import atlas.com.trainerapp.R;
import atlas.com.trainerapp.authentication.models.Auth;
import atlas.com.trainerapp.authentication.views.AuthActivity;
import atlas.com.trainerapp.bases.BasePresenter;

/**
 * Created by paulo.losbanos on 24/08/2016.
 */
public class MainPresenter extends BasePresenter {

    public FirebaseAuth mAuth;
    FragmentActivity mFragmentActivity;
    View main;
    LayoutInflater mInflater;


    public MainPresenter(FragmentActivity fa, View main) {
        super(fa,main);
        mAuth = FirebaseAuth.getInstance();
        mFragmentActivity = fa;
        mInflater = fa.getLayoutInflater();
        this.main = main;

    }

    public void showTrainerHelpSnackBar() {
       Snackbar snackbar = Snackbar.make(main,"",Snackbar.LENGTH_INDEFINITE).setAction("DONT SHOW", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) snackbar.getView();
        TextView textView = (TextView) layout.findViewById(android.support.design.R.id.snackbar_text);
        textView.setVisibility(View.INVISIBLE);

        View snackView = mInflater.inflate(R.layout.snackbar_trainer_help,null);

        layout.addView(snackView,0);
        snackbar.show();
    }

    public void signOut() {
        mAuth.signOut();
        mContext.startActivity(new Intent(mContext, AuthActivity.class));
    }
}
