package org.aaabbb.e;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.progress.UIJob;

public class DocumentJob extends UIJob 
{
	public DocumentJob()
	{
		super("DocumentJob");
	}
	
	public Document Document;
	
	public IStatus runInUIThread(IProgressMonitor monitor)
	{
		DocumentLoad o;
		o = this.Document.Load;
		
		DocumentThread thread;
		thread = Plugin.This().DocumentThread();
		
		Object lock;
		lock = thread.Lock;
		
		synchronized (lock)
		{
			thread.Queue.offer(o);
		}
		
		thread.Phore.release();
		
		return Status.OK_STATUS;
	}

}
