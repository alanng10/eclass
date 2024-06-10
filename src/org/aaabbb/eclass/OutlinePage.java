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
    
    public Document Document()
    {
    	return this.Document_D;
    }
    
    public boolean DocumentSet(Document value)
    {
    	this.Document_D = value;
    	return true;
    }
   
    protected Document Document_D;
    
    public boolean Update()
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
        
        Root a;
        a = this.Document().Load().Root();
        Object k;
        k = null;
        if (!(a == null))
        {
        	Log.This().Info("OutlinePage.Update 5555");
        	k = a.Class();
        }
        
        Log.This().Info("OutlinePage.Update 6666");
        viewer.setInput(k);

        Log.This().Info("OutlinePage.Update 7777");
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

        Root a;
        a = this.Document().Load().Root();
        Object k;
        k = null;
        if (!(a == null))
        {
        	Log.This().Info("OutlinePage.createControl 9999");
        	k = a.Class();
        }
        viewer.setInput(k);
        
        Log.This().Info("OutlinePage.createControl AAAA");
    }
}
