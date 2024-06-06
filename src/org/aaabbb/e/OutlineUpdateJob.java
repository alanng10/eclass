package org.aaabbb.e;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.UIJob;

class OutlineUpdateJob extends UIJob
{
	public OutlineUpdateJob()
	{
		super("OutlineUpdateJob");
	}
	
	public Document Document;
	
    public IStatus runInUIThread(IProgressMonitor monitor)
    {
    	this.Document.OutlinePage.Update(this.Document.Load.Root);
    	
    	return Status.OK_STATUS;
    }
	
    private IStatus runInUIThreadA(IProgressMonitor monitor)
	{
    	Log.This.Info("OutlineUpdateJob.runInUIThread 1111");
    	
    	IWorkbench workbench;
    	workbench = PlatformUI.getWorkbench();
    	
    	Log.This.Info("OutlineUpdateJob.runInUIThread 2222");
    	
    	IWorkbenchWindow window;
    	window = workbench.getActiveWorkbenchWindow();
        
    	Log.This.Info("OutlineUpdateJob.runInUIThread 3333");
    	
    	IWorkbenchPage activePage;
        activePage = window.getActivePage(); 
        
        Log.This.Info("OutlineUpdateJob.runInUIThread 4444");
        
    	IViewReference view;
        view = activePage.findViewReference("org.eclipse.ui.views.ContentOutline");
        
        Log.This.Info("OutlineUpdateJob.runInUIThread 5555");
        
        if (!(view == null))
        {
        	Log.This.Info("OutlineUpdateJob.runInUIThread 6666");
        	
            view.getPart(true);
            
            Log.This.Info("OutlineUpdateJob.runInUIThread 7777");
        }

        Log.This.Info("OutlineUpdateJob.runInUIThread 8888");
    	return Status.OK_STATUS;
	}
}
