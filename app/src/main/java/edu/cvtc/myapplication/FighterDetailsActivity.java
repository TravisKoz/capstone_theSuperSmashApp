package edu.cvtc.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import edu.cvtc.myapplication.SuperSmashDatabaseContract.FighterEntry;

public class FighterDetailsActivity extends AppCompatActivity {

    // Constants
    public static final String FIGHTER_ID =
            "edu.cvtc.myapplication.FIGHTER_ID";
    public static final int ID_NOT_SET = -1;

    // Initialize new Fighter to empty
    private Fighter mFighter = new Fighter(0, "", "", "",
            "", "", "", "", "", "", "");

    // Member Variables
    private int mFighterID;
    private int mFighterNamePosition;
    private int mFighterFranchisePosition;
    private int mFighterSpecialNeutralPosition;
    private int mFighterSpecialSidePosition;
    private int mFighterSpecialDownPosition;
    private int mFighterSpecialUpPosition;
    private int mFighterNeutralDescriptionPosition;
    private int mFighterSideDescriptionPosition;
    private int mFighterDownDescriptionPosition;
    private int mFighterUpDescriptionPosition;

    // Member objects
    private TextView mFighterName;
    private ImageView mFighterImage;
    private ImageView mFighterSeriesSymbol;
    private TextView mFighterSeries;
    private TextView mFighterNeutralSpecial;
    private TextView mFighterSideSpecial;
    private TextView mFighterDownSpecial;
    private TextView mFighterUpSpecial;
    private TextView mFighterNeutralDescription;
    private TextView mFighterSideDescription;
    private TextView mFighterDownDescription;
    private TextView mFighterUpDescription;
    private ImageView mFighterNeutralImage;
    private ImageView mFighterSideImage;
    private ImageView mFighterDownImage;
    private ImageView mFighterUpImage;
    private SuperSmashOpenHelper mDbOpenHelper;
    private Cursor mFighterCursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fighter_details);

        mDbOpenHelper = new SuperSmashOpenHelper(this);

        // Get the inter passed into the activity
        Intent intent = getIntent();
        mFighterID = intent.getIntExtra(FIGHTER_ID, ID_NOT_SET);

        // Set references to all layout controls
        mFighterName =
                findViewById(R.id.fighter_name);
        mFighterImage =
                findViewById(R.id.fighter_image);
        mFighterSeriesSymbol =
                findViewById(R.id.fighter_series_symbol);
        mFighterSeries =
                findViewById(R.id.fighter_series);
        mFighterNeutralSpecial =
                findViewById(R.id.neutral_b_move);
        mFighterSideSpecial =
                findViewById(R.id.side_b_move);
        mFighterDownSpecial =
                findViewById(R.id.down_b_move);
        mFighterUpSpecial =
                findViewById(R.id.up_b_move);
        mFighterNeutralDescription =
                findViewById(R.id.neutral_b_description);
        mFighterSideDescription =
                findViewById(R.id.side_b_description);
        mFighterDownDescription =
                findViewById(R.id.down_b_description);
        mFighterUpDescription =
                findViewById(R.id.up_b_description);
        mFighterNeutralImage =
                findViewById(R.id.neutral_b_image);
        mFighterSideImage =
                findViewById(R.id.side_b_image);
        mFighterDownImage =
                findViewById(R.id.down_b_image);
        mFighterUpImage =
                findViewById(R.id.up_b_image);
        loadFighterData();
    }

    private void loadFighterData() {
        // Open a connection to the database
        SQLiteDatabase db = mDbOpenHelper.getReadableDatabase();

        // Build the selection criteria. In this case, we want
        // to set the ID of the fighter to the passed-in
        // fighter id from the Intent.
        String selection = FighterEntry._ID + " = ?";
        String[] selectionArgs = {Integer.toString(mFighterID)};

        // Create a list of the columns we are pulling from
        // the database.
        String[] fighterColumns = {
                FighterEntry.COLUMN_NAME,
                FighterEntry.COLUMN_FRANCHISE,
                FighterEntry.COLUMN_SPECIAL_NEUTRAL,
                FighterEntry.COLUMN_SPECIAL_SIDE,
                FighterEntry.COLUMN_SPECIAL_DOWN,
                FighterEntry.COLUMN_SPECIAL_UP,
                FighterEntry.COLUMN_NEUTRAL_DESCRIPTION,
                FighterEntry.COLUMN_SIDE_DESCRIPTION,
                FighterEntry.COLUMN_DOWN_DESCRIPTION,
                FighterEntry.COLUMN_UP_DESCRIPTION
        };

        // Fill our cursor with the information we have provided
        mFighterCursor = db.query(FighterEntry.TABLE_NAME, fighterColumns,
                selection, selectionArgs, null, null, null);

        // Get the positions of the fields in the cursor so that
        // we are able to retrieve them into our layout.
        mFighterNamePosition =
                mFighterCursor.getColumnIndex(FighterEntry.COLUMN_NAME);
        mFighterFranchisePosition =
                mFighterCursor.getColumnIndex(FighterEntry.COLUMN_FRANCHISE);
        mFighterSpecialNeutralPosition =
                mFighterCursor.getColumnIndex(FighterEntry.COLUMN_SPECIAL_NEUTRAL);
        mFighterSpecialSidePosition =
                mFighterCursor.getColumnIndex(FighterEntry.COLUMN_SPECIAL_SIDE);
        mFighterSpecialDownPosition =
                mFighterCursor.getColumnIndex(FighterEntry.COLUMN_SPECIAL_DOWN);
        mFighterSpecialUpPosition =
                mFighterCursor.getColumnIndex(FighterEntry.COLUMN_SPECIAL_UP);
        mFighterNeutralDescriptionPosition =
                mFighterCursor.getColumnIndex(FighterEntry.COLUMN_NEUTRAL_DESCRIPTION);
        mFighterSideDescriptionPosition =
                mFighterCursor.getColumnIndex(FighterEntry.COLUMN_SIDE_DESCRIPTION);
        mFighterDownDescriptionPosition =
                mFighterCursor.getColumnIndex(FighterEntry.COLUMN_DOWN_DESCRIPTION);
        mFighterUpDescriptionPosition =
                mFighterCursor.getColumnIndex(FighterEntry.COLUMN_UP_DESCRIPTION);

        // Make sure that we have moved to the correct record.
        // The cursor will not have populate any of the
        // fields until we move it.
        mFighterCursor.moveToNext();

        // Call the method to display the fighter
        displayFighter();
    }

    private void displayFighter() {
        // Retrieve the values from the cursor based upon
        // the position of the columns.
        String fighterName = mFighterCursor.getString(mFighterNamePosition);
        String fighterSeries = mFighterCursor.getString(mFighterFranchisePosition);
        String fighterNeutralSpecial = mFighterCursor.getString(mFighterSpecialNeutralPosition);
        String fighterSideSpecial = mFighterCursor.getString(mFighterSpecialSidePosition);
        String fighterDownSpecial = mFighterCursor.getString(mFighterSpecialDownPosition);
        String fighterUpSpecial = mFighterCursor.getString(mFighterSpecialUpPosition);
        String fighterNeutralDescription = mFighterCursor.getString(mFighterNeutralDescriptionPosition);
        String fighterSideDescription = mFighterCursor.getString(mFighterSideDescriptionPosition);
        String fighterDownDescription = mFighterCursor.getString(mFighterDownDescriptionPosition);
        String fighterUpDescription = mFighterCursor.getString(mFighterUpDescriptionPosition);

        // Use information to populate layout TextViews
        mFighterName.setText(fighterName);
        mFighterSeries.setText(fighterSeries);
        mFighterNeutralSpecial.setText(fighterNeutralSpecial + ":");
        mFighterSideSpecial.setText(fighterSideSpecial + ":");
        mFighterDownSpecial.setText(fighterDownSpecial + ":");
        mFighterUpSpecial.setText(fighterUpSpecial + ":");
        mFighterNeutralDescription.setText(fighterNeutralDescription);
        mFighterSideDescription.setText(fighterSideDescription);
        mFighterDownDescription.setText(fighterDownDescription);
        mFighterUpDescription.setText(fighterUpDescription);

        // Use information to populate layoutImageViews
        setFighterImage(fighterName);
        setFighterSeriesSymbol(fighterSeries);
    }

    private void setFighterSeriesSymbol(String fighterSeries) {

        switch (fighterSeries) {

            case ("Super Mario"):
                mFighterSeriesSymbol.setImageResource(R.drawable.mario_series);
                break;
            case ("Donkey Kong"):
                mFighterSeriesSymbol.setImageResource(R.drawable.donkey_kong_series);
                break;
            case ("The Legend of Zelda"):
                mFighterSeriesSymbol.setImageResource(R.drawable.zelda_series);
                break;
            case ("Metroid"):
                mFighterSeriesSymbol.setImageResource(R.drawable.metroid_series);
                break;
            case ("Yoshi"):
                mFighterSeriesSymbol.setImageResource(R.drawable.yoshi_series);
                break;
            case ("Kirby"):
                mFighterSeriesSymbol.setImageResource(R.drawable.kirby_series);
                break;
            case ("Star Fox"):
                mFighterSeriesSymbol.setImageResource(R.drawable.star_fox_series);
                break;
            case ("Pokemon"):
                mFighterSeriesSymbol.setImageResource(R.drawable.pokemon_series);
                break;
            case ("EarthBound"):
                mFighterSeriesSymbol.setImageResource(R.drawable.earth_bound_series);
                break;
            case ("F-Zero"):
                mFighterSeriesSymbol.setImageResource(R.drawable.f_zero_series);
                break;
            case ("Ice Climbers"):
                mFighterSeriesSymbol.setImageResource(R.drawable.ice_climbers_series);
                break;
            case ("Fire Emblem"):
                mFighterSeriesSymbol.setImageResource(R.drawable.fire_emblem_series);
                break;
            case ("Game & Watch"):
                mFighterSeriesSymbol.setImageResource(R.drawable.game_watch_series);
                break;
            case ("Kid Icarus"):
                mFighterSeriesSymbol.setImageResource(R.drawable.kid_icarus_series);
                break;
            case ("Wario"):
                mFighterSeriesSymbol.setImageResource(R.drawable.wario_series);
                break;
            case ("Metal Gear"):
                mFighterSeriesSymbol.setImageResource(R.drawable.metal_gear_series);
                break;
            case ("Sonic"):
                mFighterSeriesSymbol.setImageResource(R.drawable.sonic_series);
                break;
            case ("Pikmin"):
                mFighterSeriesSymbol.setImageResource(R.drawable.pikmin_series);
                break;
            case ("R.O.B."):
                mFighterSeriesSymbol.setImageResource(R.drawable.rob_series);
                break;
            case ("Animal Crossing"):
                mFighterSeriesSymbol.setImageResource(R.drawable.animal_crossing_series);
                break;
            case ("Mega Man"):
                mFighterSeriesSymbol.setImageResource(R.drawable.mega_man_series);
                break;
            case ("Wii Fit"):
                mFighterSeriesSymbol.setImageResource(R.drawable.wii_fit_series);
                break;
            case ("Punch-Out!!"):
                mFighterSeriesSymbol.setImageResource(R.drawable.punchout_series);
                break;
            case ("PAC-MAN"):
                mFighterSeriesSymbol.setImageResource(R.drawable.pac_man_series);
                break;
            case ("Xenoblade Chronicles"):
                mFighterSeriesSymbol.setImageResource(R.drawable.xenoblade_chronicles_series);
                break;
            case ("Duck Hunt"):
                mFighterSeriesSymbol.setImageResource(R.drawable.duck_hunt_series);
                break;
            case ("Street Fighter"):
                mFighterSeriesSymbol.setImageResource(R.drawable.street_fighter_series);
                break;
            case ("Final Fantasy"):
                mFighterSeriesSymbol.setImageResource(R.drawable.final_fantasy_series);
                break;
            case ("Bayonetta"):
                mFighterSeriesSymbol.setImageResource(R.drawable.bayonetta_series);
                break;
            case ("Splatoon"):
                mFighterSeriesSymbol.setImageResource(R.drawable.splatoon_series);
                break;
            case ("Castlevania"):
                mFighterSeriesSymbol.setImageResource(R.drawable.castlevania_series);
                break;
            case ("Persona"):
                mFighterSeriesSymbol.setImageResource(R.drawable.persona_series);
                break;
            case ("Dragon Quest"):
                mFighterSeriesSymbol.setImageResource(R.drawable.dragon_quest_series);
                break;
            case ("Banjo-Kazooie"):
                mFighterSeriesSymbol.setImageResource(R.drawable.banjo_kazooie_series);
                break;
            case ("Fatal Fury"):
                mFighterSeriesSymbol.setImageResource(R.drawable.fatal_fury_series);
                break;
            case ("ARMS"):
                mFighterSeriesSymbol.setImageResource(R.drawable.arms_series);
                break;
            case ("Minecraft"):
                mFighterSeriesSymbol.setImageResource(R.drawable.minecraft_series);
                break;
            case ("Tekken"):
                mFighterSeriesSymbol.setImageResource(R.drawable.tekken_series);
                break;
            case ("Kingdom Hearts"):
                mFighterSeriesSymbol.setImageResource(R.drawable.kingdom_hearts_series);
                break;

            default:
                mFighterSeriesSymbol.setImageResource(R.drawable.super_smash);
        }
    }

    private void setFighterImage(String name) {
        switch (name) {
            case ("Mario"):
                mFighterImage.setImageResource(R.drawable.mario);
                break;
            case ("Donkey Kong"):
                mFighterImage.setImageResource(R.drawable.donkey_kong);
                break;
            case ("Link"):
                mFighterImage.setImageResource(R.drawable.link);
                break;
            case ("Samus"):
                mFighterImage.setImageResource(R.drawable.samus);
                break;
            case ("Dark Samus"):
                mFighterImage.setImageResource(R.drawable.dark_samus);
                break;
            case ("Yoshi"):
                mFighterImage.setImageResource(R.drawable.yoshi);
                break;
            case ("Kirby"):
                mFighterImage.setImageResource(R.drawable.kirby);
                break;
            case ("Fox"):
                mFighterImage.setImageResource(R.drawable.fox);
                break;
            case ("Pikachu"):
                mFighterImage.setImageResource(R.drawable.pikachu);
                break;
            case ("Luigi"):
                mFighterImage.setImageResource(R.drawable.luigi);
                break;
            case ("Ness"):
                mFighterImage.setImageResource(R.drawable.ness);
                break;
            case ("Captain Falcon"):
                mFighterImage.setImageResource(R.drawable.captain_falcon);
                break;
            case ("Jigglypuff"):
                mFighterImage.setImageResource(R.drawable.jigglypuff);
                break;
            case ("Peach"):
                mFighterImage.setImageResource(R.drawable.peach);
                break;
            case ("Daisy"):
                mFighterImage.setImageResource(R.drawable.daisy);
                break;
            case ("Bowser"):
                mFighterImage.setImageResource(R.drawable.bowser);
                break;
            case ("Ice Climbers"):
                mFighterImage.setImageResource(R.drawable.ice_climbers);
                break;
            case ("Sheik"):
                mFighterImage.setImageResource(R.drawable.sheik);
                break;
            case ("Zelda"):
                mFighterImage.setImageResource(R.drawable.zelda);
                break;
            case ("Dr. Mario"):
                mFighterImage.setImageResource(R.drawable.dr_mario);
                break;
            case ("Pichu"):
                mFighterImage.setImageResource(R.drawable.pichu);
                break;
            case ("Falco"):
                mFighterImage.setImageResource(R.drawable.falco);
                break;
            case ("Marth"):
                mFighterImage.setImageResource(R.drawable.marth);
                break;
            case ("Lucina"):
                mFighterImage.setImageResource(R.drawable.lucina);
                break;
            case ("Young Link"):
                mFighterImage.setImageResource(R.drawable.young_link);
                break;
            case ("Ganondorf"):
                mFighterImage.setImageResource(R.drawable.ganondorf);
                break;
            case ("Mewtwo"):
                mFighterImage.setImageResource(R.drawable.mewtwo);
                break;
            case ("Roy"):
                mFighterImage.setImageResource(R.drawable.roy);
                break;
            case ("Chrome"):
                mFighterImage.setImageResource(R.drawable.chrome);
                break;
            case ("Mr. Game & Watch"):
                mFighterImage.setImageResource(R.drawable.mr_game_and_watch);
                break;
            case ("Meta Knight"):
                mFighterImage.setImageResource(R.drawable.meta_knight);
                break;
            case ("Pit"):
                mFighterImage.setImageResource(R.drawable.pit);
                break;
            case ("Dark Pit"):
                mFighterImage.setImageResource(R.drawable.dark_pit);
                break;
            case ("Zero Suit Samus"):
                mFighterImage.setImageResource(R.drawable.zero_suit_samus);
                break;
            case ("Wario"):
                mFighterImage.setImageResource(R.drawable.wario);
                break;
            case ("Snake"):
                mFighterImage.setImageResource(R.drawable.snake);
                break;
            case ("Ike"):
                mFighterImage.setImageResource(R.drawable.ike);
                break;
            case ("Diddy Kong"):
                mFighterImage.setImageResource(R.drawable.diddy_kong);
                break;
            case ("Lucas"):
                mFighterImage.setImageResource(R.drawable.lucas);
                break;
            case ("Sonic"):
                mFighterImage.setImageResource(R.drawable.sonic);
                break;
            case ("King Dedede"):
                mFighterImage.setImageResource(R.drawable.king_dedede);
                break;
            case ("Olimar"):
                mFighterImage.setImageResource(R.drawable.olimar);
                break;
            case ("Lucario"):
                mFighterImage.setImageResource(R.drawable.lucario);
                break;
            case ("R.O.B."):
                mFighterImage.setImageResource(R.drawable.rob);
                break;
            case ("Toon Link"):
                mFighterImage.setImageResource(R.drawable.toon_link);
                break;
            case ("Wolf"):
                mFighterImage.setImageResource(R.drawable.wolf);
                break;
            case ("Villager"):
                mFighterImage.setImageResource(R.drawable.villager);
                break;
            case ("Mega Man"):
                mFighterImage.setImageResource(R.drawable.mega_man);
                break;
            case ("Wii Fit Trainer"):
                mFighterImage.setImageResource(R.drawable.wii_fit_trainer);
                break;
            case ("Rosalina & Luma"):
                mFighterImage.setImageResource(R.drawable.rosalina_and_luma);
                break;
            case ("Little Mac"):
                mFighterImage.setImageResource(R.drawable.little_mac);
                break;
            case ("Greninja"):
                mFighterImage.setImageResource(R.drawable.greninja);
                break;
            case ("Palutena"):
                mFighterImage.setImageResource(R.drawable.palutena);
                break;
            case ("PAC-MAN"):
                mFighterImage.setImageResource(R.drawable.pac_man);
                break;
            case ("Robin"):
                mFighterImage.setImageResource(R.drawable.robin);
                break;
            case ("Shulk"):
                mFighterImage.setImageResource(R.drawable.shulk);
                break;
            case ("Bowser Jr."):
                mFighterImage.setImageResource(R.drawable.bowser_jr);
                break;
            case ("Duck Hunt"):
                mFighterImage.setImageResource(R.drawable.duck_hunt);
                break;
            case ("Ryu"):
                mFighterImage.setImageResource(R.drawable.ryu);
                break;
            case ("Ken"):
                mFighterImage.setImageResource(R.drawable.ken);
                break;
            case ("Cloud"):
                mFighterImage.setImageResource(R.drawable.cloud);
                break;
            case ("Corrin"):
                mFighterImage.setImageResource(R.drawable.corrin);
                break;
            case ("Bayonetta"):
                mFighterImage.setImageResource(R.drawable.bayonetta);
                break;
            case ("Inkling"):
                mFighterImage.setImageResource(R.drawable.inkling);
                break;
            case ("Ridley"):
                mFighterImage.setImageResource(R.drawable.ridley);
                break;
            case ("Simon"):
                mFighterImage.setImageResource(R.drawable.simon);
                break;
            case ("Richter"):
                mFighterImage.setImageResource(R.drawable.richter);
                break;
            case ("King K. Rool"):
                mFighterImage.setImageResource(R.drawable.king_k_rool);
                break;
            case ("Isabelle"):
                mFighterImage.setImageResource(R.drawable.isabelle);
                break;
            case ("Incineroar"):
                mFighterImage.setImageResource(R.drawable.incineroar);
                break;
            case ("Piranha Plant"):
                mFighterImage.setImageResource(R.drawable.piranha_plant);
                break;
            case ("Joker"):
                mFighterImage.setImageResource(R.drawable.joker);
                break;
            case ("Hero"):
                mFighterImage.setImageResource(R.drawable.hero);
                break;
            case ("Banjo & Kazooie"):
                mFighterImage.setImageResource(R.drawable.banjo_kazooie);
                break;
            case ("Terry"):
                mFighterImage.setImageResource(R.drawable.terry);
                break;
            case ("Byleth"):
                mFighterImage.setImageResource(R.drawable.byleth);
                break;
            case ("Min Min"):
                mFighterImage.setImageResource(R.drawable.min_min);
                break;
            case ("Ivysaur"):
                mFighterImage.setImageResource(R.drawable.ivysaur);
                break;
            case ("Charizard"):
                mFighterImage.setImageResource(R.drawable.charizard);
                break;
            case ("Squirtle"):
                mFighterImage.setImageResource(R.drawable.squirtle);
                break;
            case ("Steve"):
                mFighterImage.setImageResource(R.drawable.steve);
                break;
            case ("Sephiroth"):
                mFighterImage.setImageResource(R.drawable.sephiroth);
                break;
            case ("Pyra"):
                mFighterImage.setImageResource(R.drawable.pyra);
                break;
            case ("Mythra"):
                mFighterImage.setImageResource(R.drawable.mythra);
                break;
            case ("Kazuya"):
                mFighterImage.setImageResource(R.drawable.kazuya);
                break;
            case ("Sora"):
                mFighterImage.setImageResource(R.drawable.sora);
                break;
            default:
                mFighterImage.setImageResource(R.drawable.super_smash);
        }
    }

    @Override
    protected void onDestroy() {
        mDbOpenHelper.close();
        super.onDestroy();
    }
}
