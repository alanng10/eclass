package org.alanng10.eclass;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

public class OutlineUpdateJob extends Job
{	
    public Document Document()
    {
    	return this.Document_D;
    }
    
    public boolean Document(Document value)
    {
    	this.Document_D = value;
    	return true;
    }
   
    protected Document Document_D;
	
    public IStatus runInUIThread(IProgressMonitor monitor)
    {
    	Document a;
    	a = this.Document();
    	
    	OutlinePage ka;
    	ka = a.OutlinePage();
    	
        if (!(ka == null))
        {
        	if (!ka.IsFinal())
        	{
        		ka.Update();
        	}
        }
        
    	return Status.OK_STATUS;
    }
}