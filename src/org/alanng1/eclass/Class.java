package org.alanng1.eclass;

public class Class extends Node
{
    public ClassName Name()
    {
        return this.Name_D;
    }
    
    public boolean Name(ClassName value)
    {
        this.Name_D = value;
        return true;
    }
    
    protected ClassName Name_D;
    
    public BaseName Base()
    {
        return this.Base_D;
    }
    
    public boolean Base(BaseName value)
    {
        this.Base_D = value;
        return true;
    }
    
    protected BaseName Base_D;

    public Comp[] Comp()
    {
        return this.Comp_D;
    }
    
    public boolean Comp(Comp[] value)
    {
        this.Comp_D = value;
        return true;
    }
    
    protected Comp[] Comp_D;
}