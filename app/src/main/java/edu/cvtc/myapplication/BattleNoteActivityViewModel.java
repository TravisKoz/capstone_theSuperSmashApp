package edu.cvtc.myapplication;

import android.os.Bundle;

import androidx.lifecycle.ViewModel;

public class BattleNoteActivityViewModel extends ViewModel {

    // Constants
    public static final String ORIGINAL_NOTE_HEADING =
            "edu.cvtc.myapplication.ORIGINAL_NOTE_HEADING";
    public static final String ORIGINAL_NOTE_BODY =
            "edu.cvtc.myapplication.ORIGINAL_NOTE_HEADING";

    // Variables
    public String mOriginalNoteHeading;
    public String mOriginalNoteBody;
    public boolean mIsNewlyCreated = true;

    public void saveState(Bundle outState) {
        outState.putString(ORIGINAL_NOTE_HEADING,
                mOriginalNoteHeading);
        outState.putString(ORIGINAL_NOTE_BODY,
                mOriginalNoteBody);
    }

    public void restoreState(Bundle inState) {
        mOriginalNoteHeading =
                inState.getString(ORIGINAL_NOTE_HEADING);
        mOriginalNoteBody =
                inState.getString(ORIGINAL_NOTE_BODY);
    }
}
