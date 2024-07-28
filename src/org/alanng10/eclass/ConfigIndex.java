package org.alanng10.eclass;

public class ConfigIndex extends Any
{
    public boolean Init()
    {
        super.Init();
        
        this.ClassServerFilePath_D = "ClassServer.FilePath";
        
        this.NetworkPortHost_D = "Network.PortHost";
        
        this.OutlineSort_D = "Outline.Sort";
        
        this.OutlineKind_D = "Outline.Kind";
        return true;
    }

    public String ClassServerFilePath()
    {
        return this.ClassServerFilePath_D;
    }
    
    protected String ClassServerFilePath_D;

    public String NetworkPortHost()
    {
        return this.NetworkPortHost_D;
    }
    
    protected String NetworkPortHost_D;
    
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