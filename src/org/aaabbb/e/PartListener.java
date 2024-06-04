package org.aaabbb.e;

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
    private int checkPart(IWorkbenchPartReference partRef) 
    {
    	IWorkbenchPart part = partRef.getPart(false);
        if (part instanceof IEditorPart)
        {
            IEditorPart editor = (IEditorPart) part;
            IEditorInput input = editor.getEditorInput();
            if (editor instanceof ITextEditor && input instanceof FileEditorInput)  //double check.  Error Editors can also bring up this call
            {
            	ITextEditor ee;
            	ee = (ITextEditor)editor;
            	
                IDocument document;
                document = ee.getDocumentProvider().getDocument(input);
                
                DocumentListener aa;
                aa = new DocumentListener();
                
                document.addDocumentListener(aa);
            }
        }
        return 0;
    }

    @Override
    public void partOpened(IWorkbenchPartReference partRef) {
    	Log.This.Info("Part Opened");

        checkPart(partRef);
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
    public void partClosed(IWorkbenchPartReference partRef) {}

    @Override
    public void partBroughtToTop(IWorkbenchPartReference partRef) {}

    @Override
    public void partActivated(IWorkbenchPartReference partRef) {}
}