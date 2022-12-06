package edu.cvtc.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlaystyleFragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
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
        TextView selectedFightersText = getView().findViewById(R.id.selected_fighter_text);

//        // Populate selected fighters from user's choice in the activity
//        for(Fighter currentFighter : finalFighters) {
//
//            listFighterFinal += currentFighter.getName() + ", ";
//        }
//        selectedFightersText.setText("Final choices: \n\n" + listFighterFinal.replaceAll(", $", ""));

    }
}