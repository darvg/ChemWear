package siddharth.com.chemforwear;

/**
 * Created by Siddharth on 1/24/15.
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PeriodicTable
{
    private ArrayList<Element> elements;
    Scanner scn;

    public PeriodicTable(ArrayList<Element> inp) throws IOException
    {
        elements = inp;
        process(elements);

    }

    private void process(ArrayList<Element> list)
    {
        try{
            scn = new Scanner(new File("PeriodicTable.txt"));
        } catch (Exception e){}

        while(scn.hasNextLine()) {
            int atomicNumber = scn.nextInt();
            String symbol = scn.next();
            String info = scn.nextLine();

            elements.add(new Element(atomicNumber, symbol, info));
        }

        System.out.println(elements);

        scn.close();
    }

    public Element getElementByNumber(int atomicNumber)
    {
        for(int i = 0; i < elements.size(); i++){
            if(elements.get(i).getAtomicNumber() == atomicNumber){
                return elements.get(i);
            }
        }
        return null;
    }

    public Element getElementBySymbol(String symbol)
    {
        for(int i = 0; i < elements.size(); i++){
            if(elements.get(i).getSymbol().equals(symbol)){
                return elements.get(i);
            }
        }

        return null;


    }
}
