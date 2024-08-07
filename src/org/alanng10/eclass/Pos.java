package org.alanng10.eclass;

public class Pos extends Any
{
    public int Row()
    {
        return this.Row_D;
    }
    
    public boolean Row(int value)
    {
        this.Row_D = value;
        return true;
    }
    
    protected int Row_D;
    
    public int Col()
    {
        return this.Col_D;
    }
    
    public boolean Col(int value)
    {
        this.Col_D = value;
        return true;
    }
    
    protected int Col_D;
}
