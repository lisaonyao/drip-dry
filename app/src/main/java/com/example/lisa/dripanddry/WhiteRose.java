package com.example.lisa.dripanddry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

public class WhiteRose extends AppCompatActivity{
    androidx.appcompat.widget.Toolbar mToolbar;
    ImageView mMap;
    String laundryStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whiterose);
        mToolbar = findViewById(R.id.toolbar);
        mMap = findViewById(R.id.map);

        //GET INTENT
        Intent receive = getIntent();
         laundryStore = receive.getStringExtra("whiteRose");

        mToolbar.setTitle(laundryStore);

        mMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Parse the location and create the intent.
                Uri addressUri = Uri.parse("geo:0,0?q=" + laundryStore);
                Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

                // Find an activity to handle the intent, and start that activity.
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Toast.makeText(WhiteRose.this, "Can't handle this intent!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
