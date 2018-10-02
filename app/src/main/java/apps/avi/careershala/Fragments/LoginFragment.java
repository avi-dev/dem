package apps.avi.careershala.Fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import apps.avi.careershala.Activities.Bottom;
import apps.avi.careershala.R;

public class LoginFragment extends Fragment {

    private View view;
    private FirebaseAuth firebaseAuth;
    private TextInputLayout textInputLayoutEmail,textInputLayoutPass;
    private EditText editTextEmail,editTextPass;
    private Button signIn;
    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.login, container, false);
        initViews();
        return view;
    }

    private void initViews() {
        firebaseAuth = FirebaseAuth.getInstance();

        editTextEmail = view.findViewById(R.id.name);
        editTextPass = view.findViewById(R.id.pass);

        signIn = view.findViewById(R.id.go);
        textView = view.findViewById(R.id.altext1);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new RegisterFragment());
            }
        });
    }

    private void  loginUser() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPass.getText().toString().trim();

        if (email.isEmpty()) {
            editTextEmail.setError(getString(R.string.input_error_email));
            editTextEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError(getString(R.string.input_error_email_invalid));
            editTextEmail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            editTextPass.setError(getString(R.string.input_error_password));
            editTextPass.requestFocus();
            return;
        }

        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful())
                        {
                          //  Toast.makeText(getActivity(),"Successfully Login",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getActivity(),Bottom.class);
                            startActivity(intent);
                            getActivity().finish();

                        }
                        else {
                            Toast.makeText(getActivity(), "Login Failed", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    private void loadFragment(Fragment fragment) {
// create a FragmentManager
        FragmentManager fm = getFragmentManager();
// create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
// replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit(); // save the changes
    }
}
