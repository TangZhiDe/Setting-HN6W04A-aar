package com.adayo.component.settings.model.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author damanz
 * @className DialogItem
 * @date 2018-08-08.
 */
public class DialogItem implements Parcelable {
    private boolean checked;
    private String name;
    private int itemMode;

    public int getItemMode() {
        return itemMode;
    }

    public DialogItem(String name, int itemMode) {
        this.name = name;
        this.itemMode = itemMode;
    }

    public void setItemMode(int itemMode) {
        this.itemMode = itemMode;
    }

    public DialogItem(String name) {
        this(false,name);
    }

    public DialogItem(boolean checked, String name) {
        this.checked = checked;
        this.name = name;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DialogItem() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.checked ? (byte) 1 : (byte) 0);
        dest.writeString(this.name);
        dest.writeInt(this.itemMode);
    }

    protected DialogItem(Parcel in) {
        this.checked = in.readByte() != 0;
        this.name = in.readString();
        this.itemMode = in.readInt();
    }

    public static final Creator<DialogItem> CREATOR = new Creator<DialogItem>() {
        @Override
        public DialogItem createFromParcel(Parcel source) {
            return new DialogItem(source);
        }

        @Override
        public DialogItem[] newArray(int size) {
            return new DialogItem[size];
        }
    };

    @Override
    public String toString() {
        return "DialogItem{" +
                "checked=" + checked +
                ", name='" + name + '\'' +
                ", itemMode=" + itemMode +
                '}';
    }
}
