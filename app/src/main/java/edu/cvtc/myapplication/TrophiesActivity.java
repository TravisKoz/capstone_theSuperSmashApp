package edu.cvtc.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import edu.cvtc.myapplication.databinding.ActivityTrophiesBinding;

public class TrophiesActivity extends AppCompatActivity {

    private ActivityTrophiesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTrophiesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

    }
}