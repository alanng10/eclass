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
		Log.This.Info("OutlineAdapterFactory.getAdapter 1111");
		
		if (IContentOutlinePage.class.equals(required))
		{
			Log.This.Info("OutlineAdapterFactory.getAdapter 2222");
			
			AbstractTextEditor editor;
            editor = (AbstractTextEditor)adaptableObject;
            
            Log.This.Info("OutlineAdapterFactory.getAdapter 3333");
            
            IEditorInput input;
            input = editor.getEditorInput();
            
            Log.This.Info("OutlineAdapterFactory.getAdapter 4444");
            
            if (input instanceof FileEditorInput)
            {
            	Log.This.Info("OutlineAdapterFactory.getAdapter 5555");
        		
            	IDocument document;
                document = editor.getDocumentProvider().getDocument(input);
                
                Log.This.Info("OutlineAdapterFactory.getAdapter 6666");
                
                Document aa;
                aa = Plugin.This().DocumentTable().get(document);
                
                Log.This.Info("OutlineAdapterFactory.getAdapter 7777");
        		
                if (!(aa == null))
                {
                	Log.This.Info("OutlineAdapterFactory.getAdapter 8888");
            		
                    Log.This.Info("OutlineAdapterFactory.getAdapter 9999");
            		
            	  	OutlinePage a;
            	  	a = new OutlinePage();
            	  	
            	  	Log.This.Info("OutlineAdapterFactory.getAdapter AAAA");
            		
            	  	aa.OutlinePage = a;
            	  	
            	  	return (T) a;
                }
            }
		}
		
		Log.This.Info("OutlineAdapterFactory.getAdapter BBBB");
		return null;
   	}
 
	@Override
	public java.lang.Class<?>[] getAdapterList()
	{
		return new java.lang.Class<?>[] { IContentOutlinePage.class };
	}
}