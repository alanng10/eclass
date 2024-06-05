package org.aaabbb.e;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.progress.UIJob;

public class DocumentJob extends UIJob 
{
	public DocumentJob()
	{
		super("DocumentJob");
	}
	
	public IDocument Document;
	public String Text;
	
	public IStatus runInUIThread(IProgressMonitor monitor)
	{
		
		DocumentLoad o;
		o = new DocumentLoad();
		o.SourceName = ;
		o.Text = this.Text;
		
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
