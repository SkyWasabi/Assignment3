package com.example.dakeh.assignment3;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by dakeh on 5/2/2016.
 */
public class Collection implements Parcelable {
    int id;
    String n;

    public Collection() {

    }

    public Collection(Parcel in) {
        super();
        this.id = in.readInt();
        this.n = in.readString();
    }

    public Collection(String name) {
        this.n = name;
    }

    public Collection(int id, String name) {
        this.id = id;
        this.n = name;
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }

    public void setName(String name) {
        this.n = name;
    }

    public String getName() {
        return n;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj)
            return true;
        if (obj==null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Collection other = (Collection) obj;
        if (id != other.id)
            return false;

        return true;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(getID());
        parcel.writeString(getName());
    }

    public static final Parcelable.Creator<Collection> CREATOR = new Parcelable.Creator<Collection>() {
        public Collection createFromParcel(Parcel in) {
            return new Collection(in);
        }

        public Collection[] newArray(int size) {
            return new Collection[size];
        }
    };

}