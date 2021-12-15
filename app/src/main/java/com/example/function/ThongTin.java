package com.example.function;

import android.os.Parcel;
import android.os.Parcelable;

public class ThongTin implements Parcelable {
    private String info;
    private int iconID;
    private String result;

    public ThongTin(String info, int iconID, String result) {
        this.info = info;
        this.iconID = iconID;
        this.result = result;
    }

    protected ThongTin(Parcel in) {
        info = in.readString();
        iconID = in.readInt();
        result = in.readString();
    }

    public static final Creator<ThongTin> CREATOR = new Creator<ThongTin>() {
        @Override
        public ThongTin createFromParcel(Parcel in) {
            return new ThongTin(in);
        }

        @Override
        public ThongTin[] newArray(int size) {
            return new ThongTin[size];
        }
    };

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getIconID() {
        return iconID;
    }

    public void setIconID(int iconID) {
        this.iconID = iconID;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(info);
        parcel.writeInt(iconID);
        parcel.writeString(result);
    }
}
