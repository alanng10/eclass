package org.alanng1.eclass;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;

public class OutlineKindAction extends Action
{
    public OutlineKindAction()
    {
        super("Group Comps", IAction.AS_CHECK_BOX);
    }
    
    public boolean Init()
    {
        this.setImageDescriptor(Plugin.This().ImageIconDescriptorKind());
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
        
        this.Page().Comparator().Kind(b);
        
        this.Page().Update();
    }
}
