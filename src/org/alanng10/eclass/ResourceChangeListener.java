package org.alanng10.eclass;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.runtime.CoreException;

public class ResourceChangeListener extends Any implements IResourceChangeListener
{
    @Override
    public void resourceChanged(IResourceChangeEvent event)
    {
        DeltaVisitor visitor;
        visitor = new DeltaVisitor();
        visitor.Init();
        
        try
        {
            event.getDelta().accept(visitor);
        } catch (CoreException e)
        {
        }
    }

}
