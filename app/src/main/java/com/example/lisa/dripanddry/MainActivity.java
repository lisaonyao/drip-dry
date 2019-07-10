package com.example.lisa.dripanddry;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText mUser, mPass;
    Button mLogin;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUser = findViewById(R.id.edtName);
        mLogin = findViewById(R.id.btnLogin);
        mPass = findViewById(R.id.edtPassword);

        db = openOrCreateDatabase("register", MODE_PRIVATE, null);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = db.rawQuery("SELECT * FROM userReg WHERE user = '"+mUser.getText()+"' AND pass = '"+mPass.getText()+"'",null);



                //check for any record
                if (c.getCount()==0)
                {
                    Toast.makeText(MainActivity.this, "Wrong username or password", Toast.LENGTH_SHORT).show();
                } else {
                    Intent stores = new Intent(getApplicationContext(), Stores.class);
                    startActivity(stores);
                }
            }
        });

    }

    public void regUser(View view) {
        //Register user
        Intent registerUser = new Intent(getApplicationContext(), SignUp.class);
        startActivity(registerUser);
    }
}
