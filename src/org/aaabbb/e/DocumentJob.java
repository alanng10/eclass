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
	
	public boolean Schedule(long delay)
	{
        this.schedule(delay);
        
        this.wakeUp(delay);
 
        return true;
	}
	
	public IStatus runInUIThread(IProgressMonitor monitor)
	{
		Log.This.Info("DocumentJob.runInUIThread 1111");
		
		Document o;
		o = this.Document;
		
		Log.This.Info("DocumentJob.runInUIThread 2222");
		
		DocumentThread thread;
		thread = Plugin.This().DocumentThread();
		
		Log.This.Info("DocumentJob.runInUIThread 3333");
		
		Object lock;
		lock = thread.Lock;
		
		Log.This.Info("DocumentJob.runInUIThread 4444");
		
		synchronized (lock)
		{
			Log.This.Info("DocumentJob.runInUIThread 5555");
		
			thread.Queue.offer(o);
			
			Log.This.Info("DocumentJob.runInUIThread 6666");
		}
		
		Log.This.Info("DocumentJob.runInUIThread 7777");
		
		thread.Phore.release();
		
		Log.This.Info("DocumentJob.runInUIThread 8888");
		
		return Status.OK_STATUS;
	}

}
