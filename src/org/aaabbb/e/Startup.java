package org.aaabbb.e;

import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public class Startup implements IStartup {

	public void earlyStartup()
	{
		Log.This.Info("Startup AaaBbb Class");
		
	    IWorkbench wb;
	    wb = PlatformUI.getWorkbench();
	    
	    IWorkbenchWindow window;
	    window = wb.getWorkbenchWindows()[0];
	    
    	PartListener aa;
    	aa = new PartListener();
    	
        IWorkbenchPage activePage;
        activePage = window.getActivePage(); 
        //activePage.addPartListener(aa);
	}
}
