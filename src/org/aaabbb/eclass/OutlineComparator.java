package org.aaabbb.eclass;

import org.eclipse.jface.viewers.ContentViewer;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
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
            String aa;
            String ab;
            
            aa = this.GetLabel(viewer, e1);
            ab = this.GetLabel(viewer, e2);
            
            return aa.compareTo(ab);
        }
        
        return 0;
    }
    
    protected String GetLabel(Viewer viewer, Object element)
    {
        ContentViewer aa;
        aa = (ContentViewer)viewer;
        
        IBaseLabelProvider ka;
        ka = aa.getLabelProvider();
        
        ILabelProvider kb;
        kb = (ILabelProvider)ka;
        
        String a;
        a = kb.getText(element);
        return a;
    }
}
