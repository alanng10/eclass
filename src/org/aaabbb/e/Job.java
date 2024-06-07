package org.aaabbb.e;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.ui.progress.UIJob;

public class Job extends UIJob
{
    public Job()
    {
        super("AaaBbb Class Job");
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
