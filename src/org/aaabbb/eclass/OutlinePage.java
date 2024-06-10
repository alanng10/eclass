package org.aaabbb.eclass;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;

public class OutlinePage extends ContentOutlinePage
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
    
    public boolean Update(Root a)
    {
        Log.This().Info("OutlinePage.Update 1111");

        TreeViewer viewer;
        viewer = this.getTreeViewer();

        Log.This().Info("OutlinePage.Update 2222");

        if (viewer == null)
        {
        	Log.This().Info("OutlinePage.Update 3333");
        	return true;
        }
        
        Log.This().Info("OutlinePage.Update 4444");
        
        viewer.setInput(a.Class());

        Log.This().Info("OutlinePage.Update 5555");
        return true;
    }

    public void createControl(Composite parent)
    {
        Log.This().Info("OutlinePage.createControl 1111");

        super.createControl(parent);

        Log.This().Info("OutlinePage.createControl 2222");

        TreeContentProvider aa;
        aa = new TreeContentProvider();

        Log.This().Info("OutlinePage.createControl 3333");

        TreeLabelProvider ab;
        ab = new TreeLabelProvider();

        Log.This().Info("OutlinePage.createControl 4444");

        TreeViewer viewer;
        viewer = this.getTreeViewer();

        Log.This().Info("OutlinePage.createControl 5555");

        viewer.setContentProvider(aa);

        Log.This().Info("OutlinePage.createControl 6666");

        viewer.setLabelProvider(ab);

        Log.This().Info("OutlinePage.createControl 7777");

        viewer.addSelectionChangedListener(this);

        Log.This().Info("OutlinePage.createControl 8888");

        viewer.setInput(null);
        
        Log.This().Info("OutlinePage.createControl 9999");
    }
}
