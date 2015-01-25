package siddharth.com.chemforwear;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Siddharth on 1/24/15.
 */
public class Element implements Parcelable
{
    private String info;
    private int atomicNumber;
    private String symbol;
    private String name;

    public Element(int atomicNumber, String symbol, String name, String info)
    {
        this.atomicNumber = atomicNumber;
        this.symbol = symbol;
        this.info = info;
        this.name = name;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(atomicNumber);
        out.writeString(info);
        out.writeString(name);
        out.writeString(symbol);

    }

    public static final Parcelable.Creator<Element> CREATOR = new Parcelable.Creator<Element>() {
        public Element createFromParcel(Parcel in) {
            return new Element(in);
        }

        public Element[] newArray(int size) {
            return new Element[size];
        }
    };

    private Element(Parcel in) {
        atomicNumber = in.readInt();
        info = in.readString();
        name = in.readString();
        symbol = in.readString();
    }

    public String toString()
    {
        return "[ " + atomicNumber + " " + symbol + " " + info + " ]";
    }

    public int getAtomicNumber(){
        return atomicNumber;
    }

    public String getInfo(){
        return info;
    }

    public String getSymbol(){
        return symbol;
    }

    public String getName(){
        return name;
    }

}
