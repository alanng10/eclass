package org.aaabbb.eclass;

public class DocumentLoad extends Any
{
    public String Text()
    {
    	return this.Text_D;
    }
    
    public boolean TextSet(String value)
    {
    	this.Text_D = value;
    	return true;
    }
   
    protected String Text_D;

    public Root Root()
    {
    	return this.Root_D;
    }
    
    public boolean RootSet(Root value)
    {
    	this.Root_D = value;
    	return true;
    }
   
    protected Root Root_D;
}
