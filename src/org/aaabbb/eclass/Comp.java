package org.aaabbb.eclass;

public class Comp extends Any
{
    public int Kind()
    {
        return this.Kind_D;
    }
    
    public boolean KindSet(int value)
    {
        this.Kind_D = value;
        return true;
    }
    
    protected int Kind_D;	
	
    public String Class()
    {
        return this.Class_D;
    }
    
    public boolean ClassSet(String value)
    {
        this.Class_D = value;
        return true;
    }
    
    protected String Class_D;

    public String Name()
    {
        return this.Name_D;
    }
    
    public boolean NameSet(String value)
    {
        this.Name_D = value;
        return true;
    }
    
    protected String Name_D;

    public int Count()
    {
        return this.Count_D;
    }
    
    public boolean CountSet(int value)
    {
        this.Count_D = value;
        return true;
    }
    
    protected int Count_D;
}
