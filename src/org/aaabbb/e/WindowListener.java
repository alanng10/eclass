package org.aaabbb.e;

import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;

public class WindowListener implements IWindowListener 
{
    @Override
    public void windowOpened(IWorkbenchWindow window) 
    {
    	PartListener aa;
    	aa = new PartListener();
    	
        IWorkbenchPage activePage = window.getActivePage(); 
        activePage.addPartListener(aa);
    }
	
    @Override
    public void windowDeactivated(IWorkbenchWindow window) {}

    @Override
    public void windowClosed(IWorkbenchWindow window) {}

    @Override
    public void windowActivated(IWorkbenchWindow window) {}
}
