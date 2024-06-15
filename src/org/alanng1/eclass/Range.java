package org.alanng1.eclass;

public class Range extends Any
{
    public int Index()
    {
        return this.Index_D;
    }
 
    public boolean Index(int value)
    {
        this.Index_D = value;
        return true;
    }
    
    protected int Index_D;

    public int Count()
    {
        return this.Count_D;
    }
 
    public boolean Count(int value)
    {
        this.Count_D = value;
        return true;
    }
    
    protected int Count_D;    
}
