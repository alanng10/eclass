package org.alanng10.eclass;

import java.io.File;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.IPath;

class DeltaVisitor extends Any implements IResourceDeltaVisitor
{
    public boolean visit(IResourceDelta delta)
    {
        IResource res;
        res = delta.getResource();
        
        IPath path;
        path = res.getLocation();
        
        String ka;
        ka = path.makeAbsolute().toString();

        switch (delta.getKind())
        {
        case IResourceDelta.ADDED:
            //Log.This().Info("Resource add: " + ka);
            break;
        case IResourceDelta.REMOVED:
            //Log.This().Info("Resource remove: " + ka);
            break;
        case IResourceDelta.CHANGED:
            int flag;
            flag = delta.getFlags();
            
            boolean b;
            b = false;
            b = b | this.HasFlag(flag, IResourceDelta.CONTENT);
            b = b | this.HasFlag(flag, IResourceDelta.REPLACED);
            b = b | this.HasFlag(flag, IResourceDelta.MOVED_TO);
            b = b | this.HasFlag(flag, IResourceDelta.MOVED_FROM);
            b = b | this.HasFlag(flag, IResourceDelta.COPIED_FROM);
            
            if (b)
            {
                //Log.This().Info("Resource change: " + ka);                
            }
         break;
        }
        return true;
    }
    
    private boolean HasFlag(int value, int flag)
    {
        return !((value & flag) == 0);
    }
 }