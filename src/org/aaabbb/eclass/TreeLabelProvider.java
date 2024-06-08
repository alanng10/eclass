package org.aaabbb.eclass;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

public class TreeLabelProvider implements ILabelProvider
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

    @Override
    public Image getImage(Object element)
    {
        Plugin plugin;
        plugin = Plugin.This();
        
        if (element instanceof ClassName)
        {
            return plugin.ImageIconClass();
        }
        if (element instanceof BaseName)
        {
            return plugin.ImageIconBaseName();
        }
        if (element instanceof Field)
        {
            return plugin.ImageIconField();
        }
        if (element instanceof Maide)
        {
            return plugin.ImageIconMaide();
        }
        return null;
    }

    @Override
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
        if (element instanceof Field)
        {
            Field ab;
            ab = (Field)element;
            return ab.Name();
        }
        if (element instanceof Maide)
        {
            Maide ac;
            ac = (Maide)element;
            return ac.Name();
        }
        return null;
    }

}
