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
	
	public IStatus runInUIThread(IProgressMonitor monitor)
	{
		
		
		return Status.OK_STATUS;
	}

}
