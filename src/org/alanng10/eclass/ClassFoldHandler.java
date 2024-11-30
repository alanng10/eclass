package org.alanng10.eclass;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

public class ClassFoldHandler extends AbstractHandler
{
    public Object execute(ExecutionEvent event) throws ExecutionException
    {
        ISelection selection;
        selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
        
        if (!(selection == null))
        {
            if (selection instanceof IStructuredSelection)
            {
                IStructuredSelection ka;
                ka = (IStructuredSelection)selection;

                Object obj;
                obj = ka.getFirstElement();
                
                if (obj instanceof IAdaptable) {
                  IResource res;
                  res = (IResource) (((IAdaptable) obj).getAdapter(IResource.class));
                  
                  String kk;
                  kk = res.getLocation().makeAbsolute().toString();
                  
                  Log.This().Info("Resource selected, path: " + kk);
                }
            }   
        }
        return null;
    }

}