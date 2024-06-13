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
    
    
    public boolean Alphabetical()
    {
        return this.Alphabetical_D;
    }
    
    public boolean AlphabeticalSet(boolean value)
    {
        this.Alphabetical_D = value;
        return true;
    }
    
    protected boolean Alphabetical_D;
    
    public int category(Object element) {
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
            return 2;
        }
        
        return 0;
    }
    
    public int compare(Viewer viewer, Object e1, Object e2) {
        int cat1;
        int cat2;

        cat1 = this.category(e1);
        cat2 = this.category(e2);
        
        if (!(cat1 == cat2)) {
            return cat1 - cat2;
        }

        if (this.Alphabetical())
        {
            String name1;
            String name2;
            
            name1 = this.GetLabel(viewer, e1);
            name2 = this.GetLabel(viewer, e2);
            
            return name1.compareTo(name2);
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
