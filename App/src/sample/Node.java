package sample;

import java.io.Serializable ;
import java.text.DecimalFormat;

public class Node <K , V> implements Serializable
{
    private static final long serialVersionUID = 1L ;

    private K k = null ;
    private V v = null ;
    private String cd = "" ;
    private double possibs = 0d ;
    DecimalFormat doTreh = new DecimalFormat("#.###");
    public Node (K key , V value)
    {
        this.k = key ;
        this.v = value ;
    }

    public K getKey ()
    {
        return this.k ;
    }

    public V getValue ()
    {
        return this.v ;
    }

    public void setValue (V value)
    {
        this.v = value ;
    }

    public String getCode ()
    {
        return this.cd ;
    }

    public void setCode (String code)
    {
        this.cd = code ;
    }

    public double getPossibility ()
    {
        return this.possibs ;
    }

    public void setPossibility (double possibility)
    {
        this.possibs = possibility ;
    }

    @Override
    public String toString ()
    {
        float val = (float)possibs;
        String ihPossib = doTreh.format(val);
        return this.k + " -";
    }
}
