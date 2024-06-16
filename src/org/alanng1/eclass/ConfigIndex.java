package org.alanng1.eclass;

public class ConfigIndex extends Any
{
    public boolean Init()
    {
        super.Init();
        
        this.OutlineSort_D = "Outline.Sort";
        
        this.OutlineKind_D = "Outline.Kind";
        return true;
    }
    
    
    public String OutlineSort()
    {
        return this.OutlineSort_D;
    }
    
    protected String OutlineSort_D;

    public String OutlineKind()
    {
        return this.OutlineKind_D;
    }
    
    protected String OutlineKind_D;
}