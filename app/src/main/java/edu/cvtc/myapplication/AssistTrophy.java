package edu.cvtc.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

// Blueprint for creating objects that represent different fighters.
// Implements Parcelable to allow objects to be sent as Extra in intents.
public class AssistTrophy implements Parcelable {

    // Member Attributes
    private String mName;
    private String mDescription;
    private int mId;


    // Overloaded Constructors
    public AssistTrophy(String name, String description) {
        mName = name;
        mDescription = description;
    }

    public AssistTrophy(int id, String name, String description) {
        mId = id;
        mName = name;
        mDescription = description;
    }

    // Getters and Setters
    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    // Returns a concatenated string.
    private String getCompareKey() {
        return mName + "|" + mDescription;
    }

    // Used to prevent duplicate assist trophies in the database
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssistTrophy that = (AssistTrophy) o;
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

    protected AssistTrophy(Parcel parcel) {
        setName(parcel.readString());
        setDescription(parcel.readString());
    }

    public static final Parcelable.Creator<AssistTrophy> CREATOR = new Parcelable.Creator<AssistTrophy>() {
        @Override
        public AssistTrophy createFromParcel(Parcel parcel) {
            return new AssistTrophy(parcel);
        }

        @Override
        public AssistTrophy[] newArray(int size) {
            return new AssistTrophy[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(mName);
        parcel.writeString(mDescription);
    }
}
