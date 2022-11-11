package edu.cvtc.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

// Blueprint for creating objects that represent different battle notes.
// Implements Parcelable to allow objects to be sent as Extra in intents.
public class BattleNote implements Parcelable {
    // Member Attributes
    private String mHeading;
    private String mBody;
    private int mId;

    // Overloaded Constructors
    public BattleNote(String heading, String body) {
        mHeading = heading;
        mBody = body;
    }

    public BattleNote(int id, String heading, String body) {
        mId = id;
        mHeading = heading;
        mBody = body;
    }

    // Getters and Setters
    public int getId() {
        return mId;
    }

    public String getHeading() {
        return mHeading;
    }

    public void setHeading(String heading) {
        mHeading = heading;
    }

    public String getBody() {
        return mBody;
    }

    public void setBody(String body) {
        mBody = body;
    }

    // Returns a concatenated heading and body.
    private String getCompareKey() {
        return mHeading + "|" + mBody;
    }

    // Used to prevent duplicate battle notes in the database
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BattleNote that = (BattleNote) o;
        return getCompareKey().equals(that.getCompareKey());
    }

    // Allows us to pull out rows of data for comparison.
    @Override
    public int hashCode() {
        return getCompareKey().hashCode();
    }

    @Override
    public String toString() {
        return getCompareKey();
    }

    protected BattleNote(Parcel parcel) {
        setHeading(parcel.readString());
        setBody(parcel.readString());
    }

    public static final Creator<BattleNote> CREATOR = new Creator<BattleNote>() {
        @Override
        public BattleNote createFromParcel(Parcel parcel) {
            return new BattleNote(parcel);
        }

        @Override
        public BattleNote[] newArray(int size) {
            return new BattleNote[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flag) {
        parcel.writeString(mHeading);
        parcel.writeString(mBody);
    }
}
