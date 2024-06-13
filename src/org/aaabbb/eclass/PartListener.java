package org.aaabbb.eclass;

import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;

public class PartListener extends Any implements IPartListener2
{
	private IDocument ClassIDocument(IWorkbenchPartReference partRef)
	{
		IWorkbenchPart part;
		part = partRef.getPart(false);
		if (part instanceof IEditorPart)
		{
			IEditorPart editor;
			editor = (IEditorPart)part;

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
			Infra infra;
			infra = Plugin.This().Infra();

			Document a;
			a = Plugin.This().DocumentTable().get(o);

			if (a == null)
			{
				a = infra.DocumentCreate(o);
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
