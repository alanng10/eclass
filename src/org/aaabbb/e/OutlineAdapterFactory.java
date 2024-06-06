package org.aaabbb.e;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.AbstractTextEditor;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

public class OutlineAdapterFactory implements IAdapterFactory
{
	@Override
	public <T> T getAdapter(Object adaptableObject, java.lang.Class<T> required)
	{
		if (IContentOutlinePage.class.equals(required))
		{
			AbstractTextEditor editor;
            editor = (AbstractTextEditor)adaptableObject;
            
            IEditorInput input;
            input = editor.getEditorInput();
            if (input instanceof FileEditorInput)  //double check.  Error Editors can also bring up this call
            {
            	IDocument document;
                document = editor.getDocumentProvider().getDocument(input);
                
                Document aa;
                aa = Plugin.This().DocumentTable().get(document);
                
                if (!(aa == null))
                {
                	Class o;
                    o = aa.Load.Class;

            	  	OutlinePage a;
            	  	a = new OutlinePage();
            	  	a.Class = o;
                    return (T) a;
                }   
            }
		}
		return null;
   	}
 
	@Override
	public java.lang.Class<?>[] getAdapterList()
	{
		return new java.lang.Class<?>[] { IContentOutlinePage.class };
	}
}