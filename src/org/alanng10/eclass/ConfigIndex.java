package org.alanng10.eclass;

public class ConfigIndex extends Any
{
    public boolean Init()
    {
        super.Init();
        
        this.ServerFilePath_D = "Server.FilePath";
        
        this.NetworkPortServer_D = "Network.PortServer";
        
        this.OutlineSort_D = "Outline.Sort";
        
        this.OutlineKind_D = "Outline.Kind";
        return true;
    }

    public String ServerFilePath()
    {
        return this.ServerFilePath_D;
    }
    
    protected String ServerFilePath_D;

    public String NetworkPortServer()
    {
        return this.NetworkPortServer_D;
    }
    
    protected String NetworkPortServer_D;
    
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