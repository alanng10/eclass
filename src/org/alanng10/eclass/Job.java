package org.alanng10.eclass;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.ui.progress.UIJob;

public class Job extends UIJob
{
    public Job()
    {
        super("EClass Job");
    }
    
    public boolean Init()
    {
        return true;
    }

    public boolean Schedule(long delay)
    {
        this.schedule(delay);

        this.wakeUp(delay);

        return true;
    }

    public IStatus runInUIThread(IProgressMonitor monitor)
    {
        return null;
    }
}
