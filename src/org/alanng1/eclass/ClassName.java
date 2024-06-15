package org.alanng1.eclass;

public class ClassName extends Node
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
