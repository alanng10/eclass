package org.alanng10.eclass;

public class Error extends Any
{
    public String Text()
    {
        return this.Text_D;
    }
    
    public boolean Text(String value)
    {
        this.Text_D = value;
        return true;
    }
    
    protected String Text_D;
    
    public PosRange Range()
    {
        return this.Range_D;
    }
    
    public boolean Range(PosRange value)
    {
        this.Range_D = value;
        return true;
    }
    
    protected PosRange Range_D;
}
