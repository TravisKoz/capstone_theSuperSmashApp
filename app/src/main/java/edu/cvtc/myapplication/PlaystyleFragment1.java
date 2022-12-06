package edu.cvtc.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PlaystyleFragment1 extends Fragment {

    // Member objects
    private SuperSmashOpenHelper mDbOpenHelper;
    String listFighter = "";

    public PlaystyleFragment1() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            mDbOpenHelper = new SuperSmashOpenHelper(getActivity().getApplicationContext());

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_playstyle1, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Unpack bundles from activity
        ArrayList<Fighter> selectedFighters = requireArguments().getParcelableArrayList("fighterKey");
        boolean closeRangeClick = requireArguments().getBoolean("closeRangeKey");
        boolean longRangeClick = requireArguments().getBoolean("longRangeKey");
        boolean hybridClick = requireArguments().getBoolean("hybridKey");

        // Create views from layout
        Button rushdown = getView().findViewById(R.id.btn_rushdown);
        Button grappler = getView().findViewById(R.id.btn_grappler);
        Button spacing = getView().findViewById(R.id.btn_spacing);
        Button balance = getView().findViewById(R.id.btn_balance);
        Button zoner = getView().findViewById(R.id.btn_zoner);
        TextView selectedFightersText = getView().findViewById(R.id.selected_fighter_text);

        // Populate selected fighters from user's choice in the activity
                for(Fighter currentFighter : selectedFighters) {

                    listFighter += currentFighter.getName() + ", ";
        }
        selectedFightersText.setText("Current choices: \n\n" + listFighter.replaceAll(", $", ""));

        rushdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ArrayList<Fighter> fightersCategoryArchetype;

                if (closeRangeClick) {
                    fightersCategoryArchetype = loadFinalChoices("Close-range", "Rushdown");

                    // Send bundle to next fragment
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("filteredKey", fightersCategoryArchetype);

                    // set PlaystyleFragment1 arguments and add fragment
                    if (savedInstanceState == null) {
                        getParentFragmentManager().beginTransaction()
                                .setReorderingAllowed(true)
                                .replace(R.id.fragment_playstyle_container, PlaystyleFragment2.class, bundle)
                                .commit();
                    }

                } else if(longRangeClick) {
                    fightersCategoryArchetype = loadFinalChoices("Long-range", "Rushdown");

                    // Send bundle to next fragment
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("filteredKey", fightersCategoryArchetype);

                    // set PlaystyleFragment1 arguments and add fragment
                    if (savedInstanceState == null) {
                        getParentFragmentManager().beginTransaction()
                                .setReorderingAllowed(true)
                                .replace(R.id.fragment_playstyle_container, PlaystyleFragment2.class, bundle)
                                .commit();
                    }


                } else if(hybridClick) {
                    fightersCategoryArchetype = loadFinalChoices("Hybrid", "Rushdown");

                    // Send bundle to next fragment
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("filteredKey", fightersCategoryArchetype);

                    // set PlaystyleFragment1 arguments and add fragment
                    if (savedInstanceState == null) {
                        getParentFragmentManager().beginTransaction()
                                .setReorderingAllowed(true)
                                .replace(R.id.fragment_playstyle_container, PlaystyleFragment2.class, bundle)
                                .commit();
                    }
                }
            }
        });

        grappler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ArrayList<Fighter> fightersCategoryArchetype;

                if (closeRangeClick) {
                    fightersCategoryArchetype = loadFinalChoices("Close-range", "Grappler");

                    // Send bundle to next fragment
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("filteredKey", fightersCategoryArchetype);

                    // set PlaystyleFragment1 arguments and add fragment
                    if (savedInstanceState == null) {
                        getParentFragmentManager().beginTransaction()
                                .setReorderingAllowed(true)
                                .replace(R.id.fragment_playstyle_container, PlaystyleFragment2.class, bundle)
                                .commit();
                    }

                } else if(longRangeClick) {
                    fightersCategoryArchetype = loadFinalChoices("Long-range", "Grappler");

                    // Send bundle to next fragment
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("filteredKey", fightersCategoryArchetype);

                    // set PlaystyleFragment1 arguments and add fragment
                    if (savedInstanceState == null) {
                        getParentFragmentManager().beginTransaction()
                                .setReorderingAllowed(true)
                                .replace(R.id.fragment_playstyle_container, PlaystyleFragment2.class, bundle)
                                .commit();
                    }


                } else if(hybridClick) {
                    fightersCategoryArchetype = loadFinalChoices("Hybrid", "Grappler");

                    // Send bundle to next fragment
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("filteredKey", fightersCategoryArchetype);

                    // set PlaystyleFragment1 arguments and add fragment
                    if (savedInstanceState == null) {
                        getParentFragmentManager().beginTransaction()
                                .setReorderingAllowed(true)
                                .replace(R.id.fragment_playstyle_container, PlaystyleFragment2.class, bundle)
                                .commit();
                    }
                }
            }
        });

        spacing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ArrayList<Fighter> fightersCategoryArchetype;

                if (closeRangeClick) {
                    fightersCategoryArchetype = loadFinalChoices("Close-range", "Spacing");

                    // Send bundle to next fragment
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("filteredKey", fightersCategoryArchetype);

                    // set PlaystyleFragment1 arguments and add fragment
                    if (savedInstanceState == null) {
                        getParentFragmentManager().beginTransaction()
                                .setReorderingAllowed(true)
                                .replace(R.id.fragment_playstyle_container, PlaystyleFragment2.class, bundle)
                                .commit();
                    }

                } else if(longRangeClick) {
                    fightersCategoryArchetype = loadFinalChoices("Long-range", "Spacing");

                    // Send bundle to next fragment
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("filteredKey", fightersCategoryArchetype);

                    // set PlaystyleFragment1 arguments and add fragment
                    if (savedInstanceState == null) {
                        getParentFragmentManager().beginTransaction()
                                .setReorderingAllowed(true)
                                .replace(R.id.fragment_playstyle_container, PlaystyleFragment2.class, bundle)
                                .commit();
                    }


                } else if(hybridClick) {
                    fightersCategoryArchetype = loadFinalChoices("Hybrid", "Spacing");

                    // Send bundle to next fragment
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("filteredKey", fightersCategoryArchetype);

                    // set PlaystyleFragment1 arguments and add fragment
                    if (savedInstanceState == null) {
                        getParentFragmentManager().beginTransaction()
                                .setReorderingAllowed(true)
                                .replace(R.id.fragment_playstyle_container, PlaystyleFragment2.class, bundle)
                                .commit();
                    }
                }
            }
        });

        balance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ArrayList<Fighter> fightersCategoryArchetype;

                if (closeRangeClick) {
                    fightersCategoryArchetype = loadFinalChoices("Close-range", "Balance");

                    // Send bundle to next fragment
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("filteredKey", fightersCategoryArchetype);

                    // set PlaystyleFragment1 arguments and add fragment
                    if (savedInstanceState == null) {
                        getParentFragmentManager().beginTransaction()
                                .setReorderingAllowed(true)
                                .replace(R.id.fragment_playstyle_container, PlaystyleFragment2.class, bundle)
                                .commit();
                    }

                } else if(longRangeClick) {
                    fightersCategoryArchetype = loadFinalChoices("Long-range", "Balance");

                    // Send bundle to next fragment
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("filteredKey", fightersCategoryArchetype);

                    // set PlaystyleFragment1 arguments and add fragment
                    if (savedInstanceState == null) {
                        getParentFragmentManager().beginTransaction()
                                .setReorderingAllowed(true)
                                .replace(R.id.fragment_playstyle_container, PlaystyleFragment2.class, bundle)
                                .commit();
                    }


                } else if(hybridClick) {
                    fightersCategoryArchetype = loadFinalChoices("Hybrid", "Balance");

                    // Send bundle to next fragment
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("filteredKey", fightersCategoryArchetype);

                    // set PlaystyleFragment1 arguments and add fragment
                    if (savedInstanceState == null) {
                        getParentFragmentManager().beginTransaction()
                                .setReorderingAllowed(true)
                                .replace(R.id.fragment_playstyle_container, PlaystyleFragment2.class, bundle)
                                .commit();
                    }
                }
            }
        });

        spacing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ArrayList<Fighter> fightersCategoryArchetype;

                if (closeRangeClick) {
                    fightersCategoryArchetype = loadFinalChoices("Close-range", "Spacing");

                    // Send bundle to next fragment
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("filteredKey", fightersCategoryArchetype);

                    // set PlaystyleFragment1 arguments and add fragment
                    if (savedInstanceState == null) {
                        getParentFragmentManager().beginTransaction()
                                .setReorderingAllowed(true)
                                .replace(R.id.fragment_playstyle_container, PlaystyleFragment2.class, bundle)
                                .commit();
                    }

                } else if(longRangeClick) {
                    fightersCategoryArchetype = loadFinalChoices("Long-range", "Spacing");

                    // Send bundle to next fragment
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("filteredKey", fightersCategoryArchetype);

                    // set PlaystyleFragment1 arguments and add fragment
                    if (savedInstanceState == null) {
                        getParentFragmentManager().beginTransaction()
                                .setReorderingAllowed(true)
                                .replace(R.id.fragment_playstyle_container, PlaystyleFragment2.class, bundle)
                                .commit();
                    }


                } else if(hybridClick) {
                    fightersCategoryArchetype = loadFinalChoices("Hybrid", "Spacing");

                    // Send bundle to next fragment
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("filteredKey", fightersCategoryArchetype);

                    // set PlaystyleFragment1 arguments and add fragment
                    if (savedInstanceState == null) {
                        getParentFragmentManager().beginTransaction()
                                .setReorderingAllowed(true)
                                .replace(R.id.fragment_playstyle_container, PlaystyleFragment2.class, bundle)
                                .commit();
                    }
                }
            }
        });

        zoner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ArrayList<Fighter> fightersCategoryArchetype;

                if (closeRangeClick) {

                    fightersCategoryArchetype = loadFinalChoices("Close-range", "Zoner");

                    // Send bundle to next fragment
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("filteredKey", fightersCategoryArchetype);

                    // set PlaystyleFragment1 arguments and add fragment
                    if (savedInstanceState == null) {
                        getParentFragmentManager().beginTransaction()
                                .setReorderingAllowed(true)
                                .replace(R.id.fragment_playstyle_container, PlaystyleFragment2.class, bundle)
                                .commit();
                    }

                } else if(longRangeClick) {

                    fightersCategoryArchetype = loadFinalChoices("Long-range", "Zoner");

                    // Send bundle to next fragment
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("filteredKey", fightersCategoryArchetype);

                    // set PlaystyleFragment1 arguments and add fragment
                    if (savedInstanceState == null) {
                        getParentFragmentManager().beginTransaction()
                                .setReorderingAllowed(true)
                                .replace(R.id.fragment_playstyle_container, PlaystyleFragment2.class, bundle)
                                .commit();
                    }


                } else if(hybridClick) {

                    fightersCategoryArchetype = loadFinalChoices("Hybrid", "Zoner");

                    // Send bundle to next fragment
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("filteredKey", fightersCategoryArchetype);

                    // set PlaystyleFragment1 arguments and add fragment
                    if (savedInstanceState == null) {
                        getParentFragmentManager().beginTransaction()
                                .setReorderingAllowed(true)
                                .replace(R.id.fragment_playstyle_container, PlaystyleFragment2.class, bundle)
                                .commit();
                    }
                }
            }
        });
    }

    private ArrayList<Fighter> loadFinalChoices(String selectedCategory, String selectedArchetype) {

        // Open database connection for reading
        SQLiteDatabase db = mDbOpenHelper.getReadableDatabase();

        // Gets the currently selected fighter's name.
        Cursor playstyleCursor = db.rawQuery("select * from " + SuperSmashDatabaseContract.FighterEntry.TABLE_NAME + " where "
                + SuperSmashDatabaseContract.FighterEntry.COLUMN_CATEGORY + " = ? AND " + SuperSmashDatabaseContract.FighterEntry.COLUMN_ARCHETYPE + " = ?" , new String[]{selectedCategory, selectedArchetype});

        int namePosition = playstyleCursor.getColumnIndex(SuperSmashDatabaseContract.FighterEntry.COLUMN_NAME);

        // Create list of Fighter objects
        ArrayList<Fighter> fightersCategory = new ArrayList<Fighter>();

        // While there is still a record from the result set that matches our cursor
        while(playstyleCursor.moveToNext()) {

            // Create a new Fighter object.
            Fighter fighter = new Fighter(0,null, null, null, null, null,
                    null, null, null, null,
                    null, null, null, null, null);

            // Set name value for created fighter object to match the fighter currently selected by cursor
            fighter.setName(playstyleCursor.getString(namePosition));

            // Add new fighter data to fightersCategory list
            fightersCategory.add(fighter);
        }

        for (Fighter currentFighter : fightersCategory) {
            Toast.makeText(getContext().getApplicationContext(), currentFighter.getName(),Toast.LENGTH_SHORT).show();
        }

        return fightersCategory;

    }

}