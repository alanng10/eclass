package org.alanng1.eclass;

import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.texteditor.ITextEditor;

public class PartListener extends Any implements IPartListener2
{
    private IEditorPart EditorPart(IWorkbenchPartReference partRef)
    {
        IWorkbenchPart part;
        part = partRef.getPart(false);
        
        if (part instanceof IEditorPart)
        {
            IEditorPart a;
            a = (IEditorPart)part;
            return a;
        }
        return null;
    }
    
    
	private IDocument ClassIDocument(IWorkbenchPartReference partRef)
	{
	    Infra infra;
	    infra = Plugin.This().Infra();
	    
	    IEditorPart ka;
	    ka = this.EditorPart(partRef);
	    
	    if (ka == null)
	    {
	        return null;
	    }
	    
	    ITextEditor editor;
	    editor = infra.Editor(ka);
		
	    if (editor == null)
	    {
	        return null;
	    }
	    
		IDocument a;
		a = infra.EditorDocument(editor);
		return a;
	}

	private boolean ClassDocumentNew(IWorkbenchPartReference partRef)
	{
		IDocument o;
		o = this.ClassIDocument(partRef);

		if (!(o == null))
		{
			Infra infra;
			infra = Plugin.This().Infra();

			Document a;
			a = Plugin.This().DocumentTable().get(o);

			if (a == null)
			{
			    IWorkbenchPart part;
		        part = partRef.getPart(false);
		        
		        IEditorPart aa;
		        aa = (IEditorPart)part;
		        
		        ITextEditor editor;
		        editor = (ITextEditor)aa;
		        
				a = infra.DocumentCreate(o, editor);
			}

			infra.DocumentSchedule(a);
		}

		return true;
	}

	public void partOpened(IWorkbenchPartReference partRef)
	{
		this.ClassDocumentNew(partRef);
	}

	public void partClosed(IWorkbenchPartReference partRef)
	{
		IDocument o;
		o = this.ClassIDocument(partRef);

		if (!(o == null))
		{
			Document a;
			a = Plugin.This().DocumentTable().get(o);

			if (!(a == null))
			{
			    OutlinePage aa;
	            aa = a.OutlinePage();

	            if (!aa.IsFinal())
	            {
	                aa.Final();
	            }

	            a.OutlinePage(null);

	            Plugin.This().DocumentTable().remove(o);
			}
		}
	}

	public void partInputChanged(IWorkbenchPartReference partRef)
	{
	}

	public void partVisible(IWorkbenchPartReference partRef)
	{
	}

	public void partHidden(IWorkbenchPartReference partRef)
	{
	}

	public void partDeactivated(IWorkbenchPartReference partRef)
	{
	}

	public void partBroughtToTop(IWorkbenchPartReference partRef)
	{
	}

	public void partActivated(IWorkbenchPartReference partRef)
	{
	}
}
