package org.aaabbb.eclass;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

public class OutlineUpdateJob extends Job
{	
    public Document Document()
    {
    	return this.Document_D;
    }
    
    public boolean DocumentSet(Document value)
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
            ka.Update(a.Load().Root);
        }
    	
    	return Status.OK_STATUS;
    }
}