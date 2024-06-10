package org.aaabbb.eclass;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

public class TreeLabelProvider extends Any implements ILabelProvider
{
    public void addListener(ILabelProviderListener listener)
    {
    }

    public void dispose()
    {
    }

    public boolean isLabelProperty(Object element, String property)
    {
        return false;
    }

    public void removeListener(ILabelProviderListener listener)
    {
    }

    public Image getImage(Object element)
    {
        Plugin plugin;
        plugin = Plugin.This();
        
        if (element instanceof ClassName)
        {
            return plugin.ImageIconClassName();
        }
        if (element instanceof BaseName)
        {
            return plugin.ImageIconBaseName();
        }
        if (element instanceof Comp)
        {
        	Comp comp;
        	comp = (Comp)element;
        	
        	int kind;
        	kind = comp.Kind();
        	
        	if (kind == 0)
        	{
        		return plugin.ImageIconField();
        	}
        	if (kind == 1)
        	{
        		return plugin.ImageIconMaide();
        	}
        }
        return null;
    }

    public String getText(Object element)
    {
        if (element instanceof ClassName)
        {
            ClassName aa;
            aa = (ClassName)element;
            return aa.Value();
        }
        if (element instanceof BaseName)
        {
            BaseName an;
            an = (BaseName)element;
            return an.Value();
        }
        if (element instanceof Comp)
        {
            Comp ab;
            ab = (Comp)element;
            return ab.Name();
        }
        return null;
    }

}
