package org.alanng1.eclass;

public class Comp extends Node
{
    public int Kind()
    {
        return this.Kind_D;
    }
    
    public boolean Kind(int value)
    {
        this.Kind_D = value;
        return true;
    }
    
    protected int Kind_D;
	
    public String Class()
    {
        return this.Class_D;
    }
    
    public boolean Class(String value)
    {
        this.Class_D = value;
        return true;
    }
    
    protected String Class_D;

    public String Name()
    {
        return this.Name_D;
    }
    
    public boolean Name(String value)
    {
        this.Name_D = value;
        return true;
    }
    
    protected String Name_D;

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

    public String Label()
    {
        return this.Label_D;
    }
    
    public boolean Label(String value)
    {
        this.Label_D = value;
        return true;
    }
    
    protected String Label_D;
}
