package com.example.myframeworkapp.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mdehe on 06/09/2020
 */
public class Monobjects implements Parcelable {


    protected Monobjects(Parcel in) {
    }

    public static final Creator<Monobjects> CREATOR = new Creator<Monobjects>() {
        @Override
        public Monobjects createFromParcel(Parcel in) {
            return new Monobjects(in);
        }

        @Override
        public Monobjects[] newArray(int size) {
            return new Monobjects[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
