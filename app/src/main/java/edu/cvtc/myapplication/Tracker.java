package edu.cvtc.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class Tracker implements Parcelable {

        // Member Attributes
        private String mFighter;
        private int mWins;
        private int mLosses;
        private int mId;


        // Overloaded Constructors
        public Tracker(String fighter, int wins, int losses) {
                mFighter = fighter;
                mWins = wins;
                mLosses = losses;

        }

        public Tracker(int id, String fighter, int wins, int losses) {
                mId = id;
                mFighter = fighter;
                mWins = wins;
                mLosses = losses;
        }

        protected Tracker(Parcel parcel) {
                setFighter(parcel.readString());
                setWins(parcel.readInt());
                setLosses( parcel.readInt());
        }

        public static final Creator<Tracker> CREATOR = new Creator<Tracker>() {
                @Override
                public Tracker createFromParcel(Parcel parcel) {
                        return new Tracker(parcel);
                }

                @Override
                public Tracker[] newArray(int size) {
                        return new Tracker[size];
                }
        };

        // Getters and Setters
        public int getId() {
                return mId;
        }

        public String getFighter() {
                return mFighter;
        }

        public void setFighter(String fighter) {
                mFighter = fighter;
        }

        public int getWins() {
                return mWins;
        }

        public void setWins(int wins) {
                mWins = wins;
        }

        public int getLosses() {
                return mLosses;
        }

        public void setLosses(int losses) {
                mLosses = losses;
        }

        // Returns a concatenated string.
        private String getCompareKey() {
                return mFighter;
        }

        // Used to prevent duplicate trackers in the database
        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Tracker that = (Tracker) o;
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


        @Override
        public int describeContents() {
                return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int flags) {
                parcel.writeString(mFighter);
                parcel.writeInt(mWins);
                parcel.writeInt(mLosses);
                parcel.writeInt(mId);
        }
}
