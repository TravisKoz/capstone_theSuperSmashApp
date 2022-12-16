package edu.cvtc.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaystyleFragment2 extends Fragment {

    String listFighterFinal = "";

    public PlaystyleFragment2() {
        // Required empty public constructor
    }

    public static PlaystyleFragment2 newInstance(String param1, String param2) {
        PlaystyleFragment2 fragment = new PlaystyleFragment2();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_playstyle2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Unpack bundles from activity
        ArrayList<Fighter> finalFighters = requireArguments().getParcelableArrayList("filteredKey");
        TextView filteredFightersText = getView().findViewById(R.id.final_selected_fighter_text);

        // Populate selected fighters from user's choice in the activity
        for(Fighter lastFighter : finalFighters) {

            listFighterFinal += lastFighter.getName() + ", ";
        }
        filteredFightersText.setText("Final choices: \n\n" + listFighterFinal.replaceAll(", $", ""));


        // Create restart button
        Button restart = getView().findViewById(R.id.btn_restart);

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), PlayStyleActivity.class);
                startActivity(intent);
            }
        });
    }
}