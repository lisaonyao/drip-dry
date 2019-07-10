package com.example.lisa.dripanddry;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;

public class SignUp extends AppCompatActivity {
    //Member variables
    EditText mUsername, mPass;
    Button mSignup;
    //sqlite instance
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mUsername = findViewById(R.id.edtName);
        mPass = findViewById(R.id.edtPassword);
        mSignup = findViewById(R.id.btnSignUp);

        // Configure sign-in to request the user's ID, email address, and basic
// profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
//        GoogleSignIn mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
//        GoogleSignInAccount mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        SignInButton signInButton = findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.sign_in_button:
                        signIn();
                        break;
                }
            }
        });

        //initialize db
        db = openOrCreateDatabase("register", MODE_PRIVATE, null);

        //create table
        db.execSQL("CREATE TABLE IF NOT EXISTS userReg(user VARCHAR, pass VARCHAR)");

        //setonclick on btn
        mSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //retrieve user details
                String userName = mUsername.getText().toString();
                String pass = mPass.getText().toString();

                if(userName.trim().length() == 0){
                    Toast.makeText(SignUp.this, "Enter Username", Toast.LENGTH_SHORT).show();
                } else if (pass.trim().length() == 0){
                    Toast.makeText(SignUp.this, "Enter Password", Toast.LENGTH_SHORT).show();
                } else {
                    //save user details to db
                    db.execSQL("INSERT INTO userReg VALUES ('"+mUsername.getText()+"', '"+mPass.getText()+"')");
                    Toast.makeText(SignUp.this, "USER registered succesfully!", Toast.LENGTH_SHORT).show();
                    //redirect to homepage
                    Intent homePage = new Intent(getApplicationContext(), Stores.class);
                    startActivity(homePage);
                }
            }
        });
    }

    private void signIn() {
        //Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        //startActivityForResult(signInIntent, RC_SIGN_IN);
    }
}
