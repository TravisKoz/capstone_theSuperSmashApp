package edu.cvtc.myapplication;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.Objects;

public class Pokemon implements Parcelable {

    // Member Attributes
    private String mName;
    private String mDescription;
    private String mBall;
    private int mId;

    // Overloaded Constructors
    public Pokemon(String name, String description, String ball) {
        mName = name;
        mDescription = description;
        mBall = ball;
    }

    public Pokemon(int id, String name, String description, String ball) {
        mId = id;
        mName = name;
        mDescription = description;
        mBall = ball;
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

    public String getBall() {
        return mBall;
    }

    public void setBall(String ball) {
        mBall = ball;
    }

    public int getId() {
        return mId;
    }

    // Returns a concatenated string.
    private String getCompareKey() {
        return mName + "|" + mDescription + "|" + mBall;
    }

    // Used to prevent duplicate Pokemon in the database
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon that = (Pokemon) o;
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

    protected Pokemon(Parcel parcel) {
        setName(parcel.readString());
        setDescription(parcel.readString());
        setBall(parcel.readString());
    }

    public static final Parcelable.Creator<Pokemon> CREATOR = new Parcelable.Creator<Pokemon>() {

        @Override
        public Pokemon createFromParcel(Parcel parcel) {
            return new Pokemon(parcel);
        }

        @Override
        public Pokemon[] newArray(int i) {
            return new Pokemon[i];
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
        parcel.writeString(mBall);
    }
}
