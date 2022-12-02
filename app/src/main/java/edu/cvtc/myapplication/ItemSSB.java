package edu.cvtc.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ItemSSB implements Parcelable {

    // Items attributes
    private String mName;
    private String mCategory;
    private String mDescription;
    private int mId;

    public ItemSSB(String name, String category, String description, int id) {
        this.mName = name;
        this.mCategory = category;
        this.mDescription = description;
        this.mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getCategory() {
        return mCategory;
    }

    public void setCategory(String category) {
        this.mCategory = category;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public int getId() {
        return mId;
    }


    //  Returns a concatenated string
    private String getCompareKey(){
        return mName + "|" + mCategory + "|" + mDescription;
    }

    // Prevents duplicated items in DB
    @Override
    public boolean equals(@Nullable Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ItemSSB item = (ItemSSB) obj;
        return getCompareKey().equals(item.getCompareKey());
    }

    // Allows us to pull out rows of data for comparison
    @Override
    public int hashCode() {
        return getCompareKey().hashCode();
    }

    @NonNull
    @Override
    public String toString() {
        return getCompareKey();
    }

    protected ItemSSB(Parcel in) {
        setName(in.readString());
        setCategory(in.readString());
        setDescription(in.readString());
    }

    public static final Creator<ItemSSB> CREATOR = new Creator<ItemSSB>() {
        @Override
        public ItemSSB createFromParcel(Parcel in) {
            return new ItemSSB(in);
        }

        @Override
        public ItemSSB[] newArray(int size) {
            return new ItemSSB[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mName);
        parcel.writeString(mCategory);
        parcel.writeString(mDescription);
    }
}
