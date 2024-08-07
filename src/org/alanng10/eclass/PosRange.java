package org.alanng10.eclass;

public class PosRange extends Any
{    
    public Pos Start()
    {
        return this.Start_D;
    }
    
    public boolean Start(Pos value)
    {
        this.Start_D = value;
        return true;
    }
    
    protected Pos Start_D;

    public Pos End()
    {
        return this.End_D;
    }
    
    public boolean End(Pos value)
    {
        this.End_D = value;
        return true;
    }
    
    protected Pos End_D;
}