package org.aaabbb.e;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

public class TreeLabelProvider implements ILabelProvider
{

	@Override
	public void addListener(ILabelProviderListener listener)
	{
	}

	@Override
	public void dispose()
	{
	}

	@Override
	public boolean isLabelProperty(Object element, String property)
	{
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener)
	{
	}

	@Override
	public Image getImage(Object element)
	{
		if (element instanceof Class)
		{
			return Plugin.This().ImageIconClass();
		}
		return null;
	}

	@Override
	public String getText(Object element)
	{
		if (element instanceof Class)
		{
			Class aa;
			aa = (Class)element;
			return aa.Name;
		}
		if (element instanceof Field)
		{
			Field ab;
			ab = (Field)element;
			return ab.Name;
		}
		if (element instanceof Maide)
		{
			Maide ac;
			ac = (Maide)element;
			return ac.Name;
		}
		return null;
	}

}
