package edu.cvtc.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;



public class WinLoseTrackerActivity extends AppCompatActivity {

    ImageView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_lose_tracker);

        test = findViewById(R.id.imageview);

       Glide.with(this).load(R.drawable.mario_down_b).into(test);
    }
}