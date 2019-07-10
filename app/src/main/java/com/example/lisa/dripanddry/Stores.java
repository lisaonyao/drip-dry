package com.example.lisa.dripanddry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

public class Stores extends AppCompatActivity  {
    GridLayout mGrid;
    CardView mCard;
    ImageView mWhiterose, mFlush, mCleanpoint, mMicos, mTintoria, mRoyal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stores);

        mWhiterose = findViewById(R.id.imgWhiterose);
        mWhiterose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent white = new Intent(getApplicationContext(), WhiteRose.class);
                white.putExtra("whiteRose", "White Rose Dry Cleaners");
                startActivity(white);
            }
        });
        mFlush = findViewById(R.id.imgFlush);
//        mFlush.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent flush = new Intent(getApplicationContext(), Flush.class);
//                flush.putExtra("flush", "Flush Dry Cleaners");
//                startActivity(flush);
//            }
//        });
        mCleanpoint = findViewById(R.id.imgcleanPoint);
        mCleanpoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cpoint = new Intent(getApplicationContext(), Clean_point.class);
                cpoint.putExtra("cpoint", "Clean Dry Cleaners");
                startActivity(cpoint);
            }
        });
        mMicos = findViewById(R.id.imgMicos);
//        mMicos.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent micos = new Intent(getApplicationContext(), Micos.class);
//                micos.putExtra("Micos", "Micos Dry Cleaners");
//                startActivity(micos);
//            }
//        });
        mTintoria = findViewById(R.id.imgTintoria);
        mTintoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tintoria = new Intent(getApplicationContext(), Tintoria.class);
                tintoria.putExtra("tintoria", "Tintoria Dry Cleaners");
                startActivity(tintoria);
            }
        });
        mRoyal= findViewById(R.id.imgRoyal);
        mRoyal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent royal = new Intent(getApplicationContext(), Tintoria.class);
                royal.putExtra("royal", "Royal Dry Cleaners");
                startActivity(royal);
            }
        });
        mGrid = findViewById(R.id.gridView);
    }


    public void flush(View view) {
        Intent flush = new Intent(getApplicationContext(), Flush.class);
        flush.putExtra("flush", "Flush Dry Cleaners");
        startActivity(flush);
    }

    public void micos(View view) {
        Intent micos = new Intent(getApplicationContext(), Micos.class);
        micos.putExtra("Micos", "Micos Dry Cleaners");
        startActivity(micos);
    }
}
