package org.alanng1.eclass;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;

public class OutlineComparator extends ViewerComparator
{
    public boolean Init()
    {
        return true;
    }
    
    public boolean Sort()
    {
        return this.Sort_D;
    }
    
    public boolean Sort(boolean value)
    {
        this.Sort_D = value;
        return true;
    }
    
    protected boolean Sort_D;
    
    public boolean Kind()
    {
        return this.Kind_D;
    }
    
    public boolean Kind(boolean value)
    {
        this.Kind_D = value;
        return true;
    }
    
    protected boolean Kind_D;
    
    public int category(Object element)
    {
        if (element instanceof ClassName)
        {
            return 0;
        }
        
        if (element instanceof BaseName)
        {
            return 1;
        }
        
        if (element instanceof Comp)
        {
            if (this.Kind())
            {
                Comp comp;
                comp = (Comp)element;
                
                int k;
                k = 2 + comp.Kind();
                return k;
            }
            
            return 2;
        }
        
        return 0;
    }
    
    public int compare(Viewer viewer, Object e1, Object e2)
    {
        Infra infra;
        infra = Plugin.This().Infra();
        
        int cat1;
        int cat2;
        
        cat1 = this.category(e1);
        cat2 = this.category(e2);
        
        int ka;
        ka = cat1 - cat2;
        
        if (!(ka == 0))
        {
            return ka;
        }

        if (this.Sort())
        {
            Comp aa;
            aa = (Comp)e1;
            Comp ab;
            ab = (Comp)e2;
     
            String kea;
            String keb;
            kea = infra.NameLabel(aa.Name());
            keb = infra.NameLabel(ab.Name());
            
            int k;
            k = kea.compareTo(keb);
            
            if (!(k == 0))
            {
                return k;
            }
            
            kea = infra.ClassLabel(aa.Class());
            keb = infra.ClassLabel(ab.Class());
            
            k = kea.compareTo(keb);
            
            return k;
        }
        
        return 0;
    }
}
