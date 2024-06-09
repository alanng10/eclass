package org.aaabbb.eclass;

import org.eclipse.jface.text.IDocument;

public class Document extends Any
{
    public IDocument IDocument()
    {
    	return this.IDocument_D;
    }
    
    public boolean IDocumentSet(IDocument value)
    {
    	this.IDocument_D = value;
    	return true;
    }
    
    protected IDocument IDocument_D;
    
    public DocumentJob Job()
    {
    	return this.Job_D;
    }
    
    public boolean JobSet(DocumentJob value)
    {
    	this.Job_D = value;
    	return true;
    }
    
    protected DocumentJob Job_D;
    
    public DocumentListener Listener()
    {
    	return this.Listener_D;
    }
    
    public boolean ListenerSet(DocumentListener value)
    {
    	this.Listener_D = value;
    	return true;
    }
    
    protected DocumentListener Listener_D;
    
    public DocumentLoad Load()
    {
    	return this.Load_D;
    }
    
    public boolean LoadSet(DocumentLoad value)
    {
    	this.Load_D = value;
    	return true;
    }
    
    protected DocumentLoad Load_D;
    
    public OutlinePage OutlinePage()
    {
    	return this.OutlinePage_D;
    }
    
    public boolean OutlinePageSet(OutlinePage value)
    {
    	this.OutlinePage_D = value;
    	return true;
    }
    
    protected OutlinePage OutlinePage_D;
}