package siddharth.com.chemforwear;

/**
 * Created by Siddharth on 1/24/15.
 */
public class Element
{
    private String info;
    private int atomicNumber;
    private String symbol;

    public Element(int atomicNumber, String symbol, String info)
    {
        this.atomicNumber = atomicNumber;
        this.symbol = symbol;
        this.info = info;
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
}
