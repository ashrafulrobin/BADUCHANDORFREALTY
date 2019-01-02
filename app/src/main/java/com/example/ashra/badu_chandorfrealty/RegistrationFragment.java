package com.example.ashra.badu_chandorfrealty;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by ashra on 12/27/2018.
 */

@SuppressLint("ValidFragment")
public  class RegistrationFragment extends Fragment implements View.OnClickListener {


   private Button buttonRegistration;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignin;

    private ProgressDialog progressDialog;

    //defining firebaseauth object
    private FirebaseAuth firebaseAuth;



    public RegistrationFragment(Button buttonRegistration) {
        this.buttonRegistration = buttonRegistration;
    }

    public RegistrationFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        buttonRegistration = (Button) getView().findViewById(R.id.buttonSignup);
        editTextEmail = (EditText) getView().findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) getView().findViewById(R.id.editTextPassword);

        textViewSignin =(TextView) getView().findViewById(R.id.textViewSignin);

        //initializing firebase auth object
        firebaseAuth = FirebaseAuth.getInstance();

       // progressDialog = new ProgressDialog(this);

        buttonRegistration.setOnClickListener(this);
        textViewSignin.setOnClickListener(this);


        return inflater.inflate(R.layout.fragment_registration,container,false);

    }

    private void registerUser() {

//getting email and password from edit texts
        String email = editTextEmail.getText().toString().trim();
        String password  = editTextPassword.getText().toString().trim();

        //checking if email and passwords are empty
        /*
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please enter email", LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter password", LENGTH_LONG).show();
            return;
        }

*/
    }
    @Override
    public void onClick(View view) {


        if(view == buttonRegistration){
           //  registerUser();
        }
        if(view == textViewSignin){
            //will open login activity here
        }

    }



}
