package edu.cvtc.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

// Blueprint for creating objects that represent different fighters.
// Implements Parcelable to allow objects to be sent as Extra in intents.
public class Fighter implements Parcelable {

    // Member Attributes
    private String mName;
    private String mImage;
    private String mFranchise;
    private String mFranchiseSymbol;
    private String mSpecialNeutral;
    private String mSpecialSide;
    private String mSpecialDown;
    private String mSpecialUp;
    private int mId;


    // Overloaded Constructors
    public Fighter (String name, String image, String franchise, String franchiseSymbol,
                    String specialNeutral, String specialSide, String specialDown, String specialUp) {
        mName = name;
        mImage = image;
        mFranchise = franchise;
        mFranchiseSymbol = franchiseSymbol;
        mSpecialNeutral = specialNeutral;
        mSpecialSide = specialSide;
        mSpecialDown = specialDown;
        mSpecialUp = specialUp;
    }

    public Fighter (int id, String name, String image, String franchise, String franchiseSymbol,
                    String specialNeutral, String specialSide, String specialDown, String specialUp) {
        mId = id;
        mName = name;
        mImage = image;
        mFranchise = franchise;
        mFranchiseSymbol = franchiseSymbol;
        mSpecialNeutral = specialNeutral;
        mSpecialSide = specialSide;
        mSpecialDown = specialDown;
        mSpecialUp = specialUp;
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


    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }

    public String getFranchise() {
        return mFranchise;
    }

    public void setFranchise(String franchise) {
        mFranchise = franchise;
    }

    public String getFranchiseSymbol() {
        return mFranchiseSymbol;
    }

    public void setFranchiseSymbol(String franchiseSymbol) {
        mFranchiseSymbol = franchiseSymbol;
    }

    public String getSpecialNeutral() {
        return mSpecialNeutral;
    }

    public void setSpecialNeutral(String specialNeutral) {
        mSpecialNeutral = specialNeutral;
    }

    public String getSpecialSide() {
        return mSpecialSide;
    }

    public void setSpecialSide(String specialSide) {
        mSpecialSide = specialSide;
    }

    public String getSpecialDown() {
        return mSpecialDown;
    }

    public void setSpecialDown(String specialDown) {
        mSpecialDown = specialDown;
    }

    public String getSpecialUp() {
        return mSpecialUp;
    }

    public void setSpecialUp(String specialUp) {
        mSpecialUp =  specialUp;
    }

    // Returns a concatenated heading and body.
    private String getCompareKey() {
        return mName + "|" + mImage + "|" + mFranchise + "|" +
                mFranchiseSymbol + "|" + mSpecialNeutral + "|" + mSpecialSide + "|" +
                mSpecialDown + "|" + mSpecialUp;
    }

    // Used to prevent duplicate fighters in the database
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fighter that = (Fighter) o;
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

    protected Fighter(Parcel parcel) {
        setName(parcel.readString());
        setImage(parcel.readString());
        setFranchise(parcel.readString());
        setFranchiseSymbol(parcel.readString());
        setSpecialNeutral(parcel.readString());
        setSpecialSide(parcel.readString());
        setSpecialDown(parcel.readString());
        setSpecialUp(parcel.readString());
    }

    public static final Creator<Fighter> CREATOR = new Creator<Fighter>() {
        @Override
        public Fighter createFromParcel(Parcel parcel) {
            return new Fighter(parcel);
        }

        @Override
        public Fighter[] newArray(int size) {
            return new Fighter[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(mName);
        parcel.writeString(mImage);
        parcel.writeString(mFranchise);
        parcel.writeString(mFranchiseSymbol);
        parcel.writeString(mSpecialNeutral);
        parcel.writeString(mSpecialSide);
        parcel.writeString(mSpecialDown);
        parcel.writeString(mSpecialUp);
    }
}
