package io.left.core.digitalshop.data.model;


import android.databinding.BaseObservable;
import android.os.Parcel;
import android.os.Parcelable;


public class User extends BaseObservable implements Parcelable {


    protected User(Parcel in) {
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
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

