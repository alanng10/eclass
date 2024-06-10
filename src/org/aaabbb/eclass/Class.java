package org.aaabbb.eclass;

public class Class extends Any
{
    public ClassName Name()
    {
        return this.Name_D;
    }
    
    public boolean NameSet(ClassName value)
    {
        this.Name_D = value;
        return true;
    }
    
    protected ClassName Name_D;
    
    public BaseName Base()
    {
        return this.Base_D;
    }
    
    public boolean BaseSet(BaseName value)
    {
        this.Base_D = value;
        return true;
    }
    
    protected BaseName Base_D;

    public Comp[] Comp()
    {
        return this.Comp_D;
    }
    
    public boolean CompSet(Comp[] value)
    {
        this.Comp_D = value;
        return true;
    }
    
    protected Comp[] Comp_D;
}