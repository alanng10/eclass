package org.aaabbb.eclass;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;

public class OutlineSortAction extends Action
{
    public OutlineSortAction()
    {
        super("Sort", IAction.AS_CHECK_BOX);
        
        this.setImageDescriptor(Plugin.This().ImageIconDescriptorSort());
    }
    
    public void run()
    {
    }
}
