package org.aaabbb.e;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class TreeContentProvider implements ITreeContentProvider
{
	private Class Class;

	private Object[] ArrayEmpty = new Object[0];
	
	@Override
	public Object[] getElements(Object inputElement)
	{
		if (inputElement instanceof Class)
		{
			Class a;
			a = (Class)inputElement;
			
			Object[] array;
			array = new Object[1];
			array[0] = a;

			return array;
		}
		
		return this.ArrayEmpty;
	}

	@Override
	public Object[] getChildren(Object parentElement)
	{
		if (parentElement instanceof Class)
		{
			Class a;
			a = (Class)parentElement;
			
			int count;
			count = a.Field.length + a.Maide.length;
			
			Object[] array;
			array = new Object[count];
			
			int countA;
			countA = a.Field.length;
			
			int i;
			i = 0;
			while (i < countA)
			{
				array[i] = a.Field[i];
				
				i = i + 1;
			}
			
			int start;
			start = countA;
			
			countA = a.Maide.length;
			
			i = 0;
			while (i < countA)
			{
				array[start + i] = a.Maide[i];
				
				i = i + 1;
			}
			
			return array;
		}
		
		return this.ArrayEmpty;
	}

	@Override
	public Object getParent(Object element)
	{
		if (element instanceof Field)
		{
			Field aa;
			aa = (Field)element;
			return aa.Parent;
		}
		if (element instanceof Maide)
		{
			Maide aa;
			aa = (Maide)element;
			return aa.Parent;
		}
		
		return null;
	}

	@Override
	public boolean hasChildren(Object element)
	{
		if (element instanceof Class)
		{
			return true;
		}
		return false;
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput)
	{
		this.Class = null;
		if (newInput instanceof Class)
		{
			this.Class = (Class)newInput;
		}
	}
}
