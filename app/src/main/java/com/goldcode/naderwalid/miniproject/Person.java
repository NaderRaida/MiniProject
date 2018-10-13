package com.goldcode.naderwalid.miniproject;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable{
    private int image;
    private String name;
    private int index;
    public Person() {

    }
    public Person(int image, String name) {
        this.image = image;
        this.name = name;

    }
    public Person(int image, String name,int index) {
        this.image = image;
        this.name = name;
        this.index =index;

    }

    protected Person(Parcel in) {
        image = in.readInt();
        name = in.readString();
        index = in.readInt();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(image);
        dest.writeString(name);
        dest.writeInt(index);
    }
}
