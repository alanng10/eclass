package org.aaabbb.eclass;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class TreeContentProvider extends Any implements ITreeContentProvider
{
    private Object[] ArrayEmpty = new Object[0];

    public Object[] getElements(Object inputElement)
    {
        return this.getChildren(inputElement);
    }

    public Object[] getChildren(Object parentElement)
    {
        if (parentElement instanceof Class)
        {
            Class a;
            a = (Class)parentElement;

            int countK;
            countK = 2;
            
            Comp[] compArray;
            compArray = a.Comp();
            
            int compCount;
            compCount = compArray.length;
            
            int arrayCount;
            arrayCount = countK + compCount;

            Object[] array;
            array = new Object[arrayCount];

            array[0] = a.Name();
            
            array[1] = a.Base();
            
            int start;
            start = countK;
            
            int count;
            count = compCount;
            
            int i;
            i = 0;
            while (i < count)
            {
                array[start + i] = compArray[i];

                i = i + 1;
            }

            return array;
        }

        return this.ArrayEmpty;
    }

    public Object getParent(Object element)
    {
        return null;
    }

    public boolean hasChildren(Object element)
    {
        return false;
    }

    public void inputChanged(Viewer viewer, Object oldInput, Object newInput)
    {
    }
}
