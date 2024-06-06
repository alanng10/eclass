package org.aaabbb.e;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.ITextEditor;

public class PartListener implements IPartListener2
{
    private IDocument PartDocument(IWorkbenchPartReference partRef) 
    {
    	IWorkbenchPart part = partRef.getPart(false);
        if (part instanceof IEditorPart)
        {
            IEditorPart editor = (IEditorPart) part;
            IEditorInput input = editor.getEditorInput();
            if (editor instanceof ITextEditor & input instanceof FileEditorInput)
            {
            	ITextEditor ee;
            	ee = (ITextEditor)editor;
            	
            	FileEditorInput eo;
            	eo = (FileEditorInput)input;
            	
            	IPath path;
            	path = eo.getPath();
            	
            	String eu;
            	eu = path.getFileExtension();

            	eu = eu.toLowerCase();
            	
            	if (eu.equals("cla"))
            	{
                	Log.This.Info("Class Source File");
                	
                    IDocument document;
                    document = ee.getDocumentProvider().getDocument(input);
                    return document;
            	}
            	
            }
        }
        return null;
    }

    @Override
    public void partOpened(IWorkbenchPartReference partRef) {
    	Log.This.Info("Part Opened");

        IDocument o;
        o = this.PartDocument(partRef);
        
        if (!(o == null))
        {
        	Log.This.Info("Class Source Document Opened");
        	
        	Document a;
        	a = new Document();
        	a.Init();
        	
        	DocumentJob job;
        	job = new DocumentJob();
        	job.Document = a;
        	
            DocumentListener listener;
            listener = new DocumentListener();
            listener.Document = a;
        	
        	DocumentLoad load;
        	load = new DocumentLoad();
        	load.Init();
        	
        	a.IDocument = o;
        	a.Job = job;
        	a.Listener = listener;
        	a.Load = load;
        	
        	Plugin.This().DocumentTable().put(a.IDocument, a);
        	
            a.IDocument.addDocumentListener(listener);
        }
    }
    

    @Override
    public void partClosed(IWorkbenchPartReference partRef)
    {
    	Log.This.Info("Part Closed");
    	
        IDocument a;
        a = this.PartDocument(partRef);
        
        if (!(a == null))
        {
        	Log.This.Info("Class Source Document Closed");
        	
        	Plugin.This().DocumentTable().remove(a);
        }
    }

    @Override
    public void partInputChanged(IWorkbenchPartReference partRef) 
    {
    	Log.This.Info("Part Input Changed");
    }           

    @Override
    public void partVisible(IWorkbenchPartReference partRef){}

    @Override
    public void partHidden(IWorkbenchPartReference partRef) {}

    @Override
    public void partDeactivated(IWorkbenchPartReference partRef)  {}


    @Override
    public void partBroughtToTop(IWorkbenchPartReference partRef) {}

    @Override
    public void partActivated(IWorkbenchPartReference partRef) {}
}
