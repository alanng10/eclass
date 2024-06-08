package org.aaabbb.eclass;

public class Var extends Any
{
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
}