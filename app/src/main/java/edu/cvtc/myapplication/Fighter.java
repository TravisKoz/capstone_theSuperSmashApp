package edu.cvtc.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

// Blueprint for creating objects that represent different fighters.
// Implements Parcelable to allow objects to be sent as Extra in intents.
public class Fighter implements Parcelable {

    // Member Attributes
    private String mName;
    private String mFranchise;
    private String mSpecialNeutral;
    private String mSpecialSide;
    private String mSpecialDown;
    private String mSpecialUp;
    private String mNeutralDescription;
    private String mSideDescription;
    private String mDownDescription;
    private String mUpDescription;
    private String mFinalSmash;
    private String mFinalSmashDescription;
    private String mCategory;
    private String mArchetype;
    private int mId;


    // Overloaded Constructors
    public Fighter(String name, String franchise, String specialNeutral,
                   String specialSide, String specialDown, String specialUp,
                   String neutralDescription, String sideDescription, String downDescription,
                   String upDescription, String finalSmash, String finalSmashDescription,
                   String category, String archetype) {
        mName = name;
        mFranchise = franchise;
        mSpecialNeutral = specialNeutral;
        mSpecialSide = specialSide;
        mSpecialDown = specialDown;
        mSpecialUp = specialUp;
        mNeutralDescription = neutralDescription;
        mSideDescription = sideDescription;
        mDownDescription = downDescription;
        mUpDescription = upDescription;
        mFinalSmash = finalSmash;
        mFinalSmashDescription = finalSmashDescription;
        mCategory = category;
        mArchetype = archetype;
    }

    public Fighter(int id, String name, String franchise, String specialNeutral,
                   String specialSide, String specialDown, String specialUp,
                   String neutralDescription, String sideDescription, String downDescription,
                   String upDescription, String finalSmash, String finalSmashDescription,
                   String category, String archetype) {
        mId = id;
        mName = name;
        mFranchise = franchise;
        mSpecialNeutral = specialNeutral;
        mSpecialSide = specialSide;
        mSpecialDown = specialDown;
        mSpecialUp = specialUp;
        mNeutralDescription = neutralDescription;
        mSideDescription = sideDescription;
        mDownDescription = downDescription;
        mUpDescription = upDescription;
        mFinalSmash = finalSmash;
        mFinalSmashDescription = finalSmashDescription;
        mCategory = category;
        mArchetype = archetype;
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

    public String getFranchise() {
        return mFranchise;
    }

    public void setFranchise(String franchise) {
        mFranchise = franchise;
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
        mSpecialUp = specialUp;
    }

    public String getNeutralDescription() {
        return mNeutralDescription;
    }

    public void setNeutralDescription(String neutralDescription) {
        mNeutralDescription = neutralDescription;
    }

    public String getSideDescription() {
        return mSideDescription;
    }

    public void setSideDescription(String sideDescription) {
        mSideDescription = sideDescription;
    }

    public String getDownDescription() {
        return mDownDescription;
    }

    public void setDownDescription(String downDescription) {
        mDownDescription = downDescription;
    }

    public String getUpDescription() {
        return mUpDescription;
    }

    public void setUpDescription(String upDescription) {
        mUpDescription = upDescription;
    }

    public void setFinalSmash(String finalSmash) {
        mFinalSmash = finalSmash;
    }

    public String getFinalSmash() {
        return mFinalSmash;
    }

    public void setFinalSmashDescription(String finalSmashDescription) {
        mFinalSmashDescription = finalSmashDescription;
    }

    public String getFinalSmashDescription() {
        return mFinalSmashDescription;
    }

    public String getCategory() {
        return mCategory;
    }

    public void setCategory(String category) {
        mCategory = category;
    }

    public String getArchetype() {
        return mArchetype;
    }

    public void setArchetype(String archetype) {
        mCategory = archetype;
    }




    // Returns a concatenated string.
    private String getCompareKey() {
        return mName + "|" + mFranchise + "|" +
                mSpecialNeutral + "|" + mSpecialSide + "|" +
                mSpecialDown + "|" + mSpecialUp + "|" + mNeutralDescription +
                "|" + mSideDescription + "|" + mDownDescription +
                "|" + mUpDescription + "|" + mFinalSmash + "|" + mFinalSmashDescription +
                "|" + mCategory + "|" + mArchetype;
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
        setFranchise(parcel.readString());
        setSpecialNeutral(parcel.readString());
        setSpecialSide(parcel.readString());
        setSpecialDown(parcel.readString());
        setSpecialUp(parcel.readString());
        setNeutralDescription(parcel.readString());
        setSideDescription(parcel.readString());
        setDownDescription(parcel.readString());
        setUpDescription(parcel.readString());
        setFinalSmash(parcel.readString());
        setFinalSmashDescription(parcel.readString());
        setCategory(parcel.readString());
        setArchetype(parcel.readString());
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
        parcel.writeString(mFranchise);
        parcel.writeString(mSpecialNeutral);
        parcel.writeString(mSpecialSide);
        parcel.writeString(mSpecialDown);
        parcel.writeString(mSpecialUp);
        parcel.writeString(mNeutralDescription);
        parcel.writeString(mSideDescription);
        parcel.writeString(mDownDescription);
        parcel.writeString(mUpDescription);
        parcel.writeString(mFinalSmash);
        parcel.writeString(mFinalSmashDescription);
        parcel.writeString(mCategory);
        parcel.writeString(mArchetype);
    }
}
