package org.alanng1.eclass;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;

public class OutlinePage extends ContentOutlinePage
{
    public boolean Init()
    {
        ConfigIndex configIndex;
        configIndex = Plugin.This().ConfigIndex();
        
        ScopedPreferenceStore ka;
        ka = new ScopedPreferenceStore(InstanceScope.INSTANCE, Plugin.PLUGIN_ID);

        this.InitSort_D = ka.getBoolean(configIndex.OutlineSort());

        this.InitKind_D = ka.getBoolean(configIndex.OutlineKind());

        OutlineComparator aa;
        aa = new OutlineComparator();
        aa.Init();
        aa.Sort(this.InitSort());
        aa.Kind(this.InitKind());

        this.Comparator(aa);
        return true;
    }

    public boolean Final()
    {
        this.dispose();
        return true;
    }

    public void dispose()
    {
        super.dispose();

        this.IsFinal(true);
    }

    protected boolean InitSort()
    {
        return this.InitSort_D;
    }

    protected boolean InitSort_D;

    protected boolean InitKind()
    {
        return this.InitKind_D;
    }

    protected boolean InitKind_D;

    public boolean IsFinal()
    {
        return this.IsFinal_D;
    }

    public boolean IsFinal(boolean value)
    {
        this.IsFinal_D = value;
        return true;
    }

    protected boolean IsFinal_D;

    public Document Document()
    {
        return this.Document_D;
    }

    public boolean Document(Document value)
    {
        this.Document_D = value;
        return true;
    }

    protected Document Document_D;

    public OutlineComparator Comparator()
    {
        return this.Comparator_D;
    }

    public boolean Comparator(OutlineComparator value)
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
        aa.Page(this);
        aa.Init();
        aa.setChecked(this.InitSort());

        OutlineKindAction ab;
        ab = new OutlineKindAction();
        ab.Page(this);
        ab.Init();
        ab.setChecked(this.InitKind());

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

        viewer.setComparator(this.Comparator());
    }

    public void selectionChanged(SelectionChangedEvent event)
    {
        super.selectionChanged(event);

        IStructuredSelection k;
        k = event.getStructuredSelection();

        Object ka;
        ka = k.getFirstElement();

        if (ka == null)
        {
            return;
        }

//        String aa;
//        aa = ka.getClass().getCanonicalName();

//        Log.This().Info("OutlinePage.selectionChanged element class: " + aa);

        if (!(ka instanceof Node))
        {
            return;
        }

        Infra infra;
        infra = Plugin.This().Infra();

        Node node;
        node = (Node)ka;

        Range range;
        range = node.Range();

        if (range == null)
        {
            return;
        }

        int index;
        int count;
        index = range.Index();
        count = range.Count();

        int totalCount;
        totalCount = this.Document().IDocument().getLength();

        if (!infra.CheckRange(totalCount, index, count))
        {
            return;
        }

        this.Document().Editor().selectAndReveal(index, count);
    }
}
