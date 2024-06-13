package org.aaabbb.eclass;

import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;

public class OutlinePage extends ContentOutlinePage
{
    public boolean Init()
    {
        OutlineComparator aa;
        aa = new OutlineComparator();
        aa.Init();
        
        this.ComparatorSet(aa);
        return true;
    }
    
    public boolean Final()
    {
        this.dispose();
        return true;
    }
    
    public void dispose() {
        super.dispose();
    
        this.IsFinalSet(true);
    }
    
    public boolean IsFinal()
    {
        return this.IsFinal_D;
    }
    
    public boolean IsFinalSet(boolean value)
    {
        this.IsFinal_D = value;
        return true;
    }
   
    protected boolean IsFinal_D;
    
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
    
    public OutlineComparator Comparator()
    {
        return this.Comparator_D;
    }
    
    public boolean ComparatorSet(OutlineComparator value)
    {
        this.Comparator_D = value;
        return true;
    }
    
    protected OutlineComparator Comparator_D;
    
    public boolean Update()
    {
        TreeViewer viewer;
        viewer = this.getTreeViewer();

        if (viewer == null)
        {
            return true;
        }
        
        Root a;
        a = this.Document().Load().Root();

        Object k;
        k = this.Data(a);
        
        viewer.setInput(k);
        return true;
    }
    
    protected Object Data(Root root)
    {
        Object k;
        k = null;
        if (!(root == null))
        {
            k = root.Class();
        }
        Object a;
        a = k;
        return a;
    }
    
    public void init(IPageSite pageSite)
    {
        super.init(pageSite);
        
        IActionBars ka;
        ka = pageSite.getActionBars();
        
        IToolBarManager k;
        k = ka.getToolBarManager();
        
        OutlineSortAction aa;
        aa = new OutlineSortAction();
        aa.PageSet(this);
        aa.Init();
        
        OutlineKindAction ab;
        ab = new OutlineKindAction();
        ab.PageSet(this);
        ab.Init();
        
        k.add(aa);
        k.add(ab);
    }

    public void createControl(Composite parent)
    {
        super.createControl(parent);

        TreeContentProvider aa;
        aa = new TreeContentProvider();
        aa.Init();

        TreeLabelProvider ab;
        ab = new TreeLabelProvider();
        ab.Init();
        
        TreeViewer viewer;
        viewer = this.getTreeViewer();

        viewer.setContentProvider(aa);

        viewer.setLabelProvider(ab);

        viewer.addSelectionChangedListener(this);

        viewer.setComparator(this.Comparator());
    }
}
