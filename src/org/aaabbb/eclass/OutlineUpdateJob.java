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
    	Log.This().Info("OutlineUpdateJob.runInUIThread 1111");
    	
    	Document a;
    	a = this.Document();
    	
    	OutlinePage ka;
    	ka = a.OutlinePage();
    	
        if (!(ka == null))
        {
        	if (!ka.IsFinal())
        	{
            	Log.This().Info("OutlineUpdateJob.runInUIThread 2222");
        		ka.Update();
        	}
        }
        
    	Log.This().Info("OutlineUpdateJob.runInUIThread 3333");    	
    	return Status.OK_STATUS;
    }
}