package org.alanng10.eclass;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

public class ProblemUpdateJob extends Job
{	
    public Document Document()
    {
    	return this.Document_D;
    }
    
    public boolean Document(Document value)
    {
    	this.Document_D = value;
    	return true;
    }
   
    protected Document Document_D;
	
    public IStatus runInUIThread(IProgressMonitor monitor)
    {
        Infra infra;
        infra = Infra.This();
        
    	Document a;
    	a = this.Document();
    	
    	IFile file;
    	file = a.File();
    	
    	try
        {
            file.deleteMarkers(null, false, 0);
        } catch (CoreException e)
        {
            Log.This().Error("Delete problem marker error", e);
            return Status.OK_STATUS;
        }
    	
    	Error[] array;
    	array = a.Load().Error();
    	
    	int count;
    	count = array.length;
    	int i;
    	i = 0;
    	while (i < count)
    	{
    	    Error error;
    	    error = array[i];
    	    
    	    infra.CreateMarker(file, error);
    	    
    	    i = i + 1;
    	}
        
    	return Status.OK_STATUS;
    }
}