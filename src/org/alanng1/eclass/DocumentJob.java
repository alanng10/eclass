package org.alanng1.eclass;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

public class DocumentJob extends Job
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
        Document o;
        o = this.Document();

        DocumentThread thread;
        thread = Plugin.This().DocumentThread();

        Object lock;
        lock = thread.Lock();

        synchronized (lock)
        {
            thread.Queue().offer(o);
        }

        thread.Phore().release();

        return Status.OK_STATUS;
    }

}
