package apps.avi.careershala.Activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import apps.avi.careershala.Fragments.HomeFragment;
import apps.avi.careershala.Fragments.LoginFragment;
import apps.avi.careershala.R;

public class Bottom extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);

        loadFragment(new HomeFragment());
        BottomNavigationView navigation =  findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.home:
                fragment = new HomeFragment();
                break;

            case R.id.career:
                fragment = new LoginFragment();
                break;

            case R.id.colleges:
                fragment = new LoginFragment();
                break;

            case R.id.jobs:
                fragment = new LoginFragment();
                break;

            case R.id.exams:
                fragment = new LoginFragment();
                break;
        }

        return loadFragment(fragment);
    }


    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            FragmentManager fm = getFragmentManager();
// create a FragmentTransaction to begin the transaction and replace the Fragment
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
// replace the FrameLayout with new Fragment
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit(); // save the changes
            return true;
        }
        return false;
    }

}
