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
            
            int count;
            count = countK + a.Field().length + a.Maide().length;

            Object[] array;
            array = new Object[count];

            array[0] = a.Name();
            
            array[1] = a.Base();
            
            int start;
            start = countK;
            
            int countA;
            countA = a.Field().length;

            int i;
            i = 0;
            while (i < countA)
            {
                array[start + i] = a.Field()[i];

                i = i + 1;
            }

            start = start + countA;

            countA = a.Maide().length;

            i = 0;
            while (i < countA)
            {
                array[start + i] = a.Maide()[i];

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
