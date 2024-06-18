package org.alanng10.eclass;

public class Node extends Any
{
    public Range Range()
    {
        return this.Range_D;
    }

    public boolean Range(Range value)
    {
        this.Range_D = value;
        return true;
    }
    
    protected Range Range_D;
}