package org.alanng10.eclass;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;

public class OutlineSortAction extends Action
{
    public OutlineSortAction()
    {
        super("Sort Comps", IAction.AS_CHECK_BOX);
    }
    
    public boolean Init()
    {
        this.setImageDescriptor(Plugin.This().ImageIconDescriptorSort());
        
        return true;
    }
    
    public OutlinePage Page()
    {
        return this.Page_D;
    }
    
    public boolean Page(OutlinePage value)
    {
        this.Page_D = value;
        return true;
    }
    
    protected OutlinePage Page_D;
    
    public void run()
    {
        boolean b;
        b = this.isChecked();
        
        this.Page().Comparator().Sort(b);
        
        this.Page().Update();
    }
}
