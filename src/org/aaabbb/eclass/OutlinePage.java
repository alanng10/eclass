package org.aaabbb.eclass;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

public class OutlinePage implements IContentOutlinePage
{
    public boolean Init()
    {
        return true;
    }
    
    public boolean Final()
    {
        this.dispose();
        return true;
    }

    protected OutlineViewer Viewer;
    
    @Override
    public void createControl(Composite parent)
    {
        this.Viewer = new OutlineViewer();
        this.Viewer.ParentSet(parent);
        this.Viewer.Init();
    }

    @Override
    public void dispose()
    {
        if (this.Viewer == null)
        {
            return;
        }
        this.Viewer.Final();
    }

    @Override
    public Control getControl()
    {
        if (this.Viewer == null)
        {
            return null;
        }
        return this.Viewer.getControl();
    }

    @Override
    public void setActionBars(IActionBars actionBars)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setFocus()
    {
        return;
    }

    @Override
    public void addSelectionChangedListener(ISelectionChangedListener listener)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public ISelection getSelection()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void removeSelectionChangedListener(ISelectionChangedListener listener)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setSelection(ISelection selection)
    {
        // TODO Auto-generated method stub
        
    }
    
}
