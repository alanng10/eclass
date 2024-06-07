package org.aaabbb.eclass;

import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;

public class PartListener implements IPartListener2
{
    private IDocument ClassIDocument(IWorkbenchPartReference partRef)
    {
        IWorkbenchPart part = partRef.getPart(false);
        if (part instanceof IEditorPart)
        {
            IEditorPart editor;
            editor = (IEditorPart) part;

            IDocument a;
            a = Plugin.This().Infra().EditorDocument(editor);
            return a;
        }
        return null;
    }

    private boolean ClassDocumentNew(IWorkbenchPartReference partRef)
    {
        IDocument o;
        o = this.ClassIDocument(partRef);

        if (!(o == null))
        {
            Log.This().Info("Class Source Document Opened");

            Infra infra;
            infra = Plugin.This().Infra();

            Document a;
            a = infra.DocumentCreate(o);

            if (!(a == null))
            {
                infra.DocumentSchedule(a);
            }
        }

        return true;
    }

    @Override
    public void partOpened(IWorkbenchPartReference partRef)
    {
        Log.This().Info("Part Opened");

        this.ClassDocumentNew(partRef);
    }

    @Override
    public void partClosed(IWorkbenchPartReference partRef)
    {
        Log.This().Info("Part Closed");

        IDocument o;
        o = this.ClassIDocument(partRef);

        if (!(o == null))
        {
            Log.This().Info("Class Source Document Closed");

            Document a;
            a = Plugin.This().DocumentTable().get(o);
            
            OutlinePage aa;
            aa = a.OutlinePage;
            
            aa.Final();
            
            a.OutlinePage = null;
            
            Plugin.This().DocumentTable().remove(o);
        }
    }

    @Override
    public void partInputChanged(IWorkbenchPartReference partRef)
    {
        Log.This().Info("Part Input Changed");
    }

    @Override
    public void partVisible(IWorkbenchPartReference partRef)
    {
        Log.This().Info("Part Visible");
    }

    @Override
    public void partHidden(IWorkbenchPartReference partRef)
    {
        Log.This().Info("Part Hidden");
    }

    @Override
    public void partDeactivated(IWorkbenchPartReference partRef)
    {
        Log.This().Info("Part Deactivated");
    }

    @Override
    public void partBroughtToTop(IWorkbenchPartReference partRef)
    {
        Log.This().Info("Part Brought To Top");
    }

    @Override
    public void partActivated(IWorkbenchPartReference partRef)
    {
        Log.This().Info("Part Activated");
    }
}
