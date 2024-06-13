package org.aaabbb.eclass;

public class BaseName extends Any
{
    public String Value()
    {
        return this.Value_D;
    }
    
    public boolean Value(String value)
    {
        this.Value_D = value;
        return true;
    }
    
    protected String Value_D;
}
