package org.aaabbb.e;

import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

public class Startup implements IStartup {

	public void earlyStartup()
	{
		Log.Info("Startup AaaBbb Class");
		
		WindowListener aa;
		aa = new WindowListener();
		
	    IWorkbench wb = PlatformUI.getWorkbench();
	    wb.addWindowListener(aa);
	}
}
