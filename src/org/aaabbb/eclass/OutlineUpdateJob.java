package org.aaabbb.eclass;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

public class OutlineUpdateJob extends Job
{	
	public Document Document;
	
    public IStatus runInUIThread(IProgressMonitor monitor)
    {
        if (!(this.Document.OutlinePage == null))
        {
            this.Document.OutlinePage.Update(this.Document.Load.Root);
        }
    	
    	return Status.OK_STATUS;
    }
}