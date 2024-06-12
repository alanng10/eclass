package org.aaabbb.eclass;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.List;

public class OutlineViewer extends Viewer
{
    public boolean Init()
    {
        this.List = new List(this.Parent(), this.ListStyle());
        return true;
    }
    
    public boolean Final()
    {
        this.List.dispose();
        return true;
    }
    
    private List List;
    
    private Root Root;
    
    public Composite Parent()
    {
        return this.Parent_D;
    }
    
    public boolean ParentSet(Composite value)
    {
        this.Parent_D = value;
        return true;
    }
    
    protected Composite Parent_D;
    
    protected int ListStyle()
    {
        return SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL;
    }
    
    public Control getControl()
    {
        return this.List;
    }

    @Override
    public Object getInput()
    {
        return this.Root;
    }

    @Override
    public ISelection getSelection()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void refresh()
    {
        this.List.removeAll();
        
        
    }

    @Override
    public void setInput(Object input)
    {
        this.Root = (Root)input;
    }

    @Override
    public void setSelection(ISelection selection, boolean reveal)
    {
        // TODO Auto-generated method stub
        
    }
}