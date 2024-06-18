package org.alanng10.eclass;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.texteditor.AbstractTextEditor;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

public class OutlineAdapterFactory implements IAdapterFactory
{
    @SuppressWarnings("unchecked")
    public <T> T getAdapter(Object adaptableObject, java.lang.Class<T> required)
    {
        if (!(IContentOutlinePage.class.equals(required)))
        {
            return null;
        }

        Infra infra;
        infra = Plugin.This().Infra();

        AbstractTextEditor kkk;
        kkk = (AbstractTextEditor)adaptableObject;

        ITextEditor editor;
        editor = kkk;
        
        IDocument ka;
        ka = infra.EditorDocument(editor);

        if (ka == null)
        {
            return null;
        }
        
        Document aa;
        aa = Plugin.This().DocumentTable().get(ka);

        boolean b;
        b = (aa == null);
        
        if (b)
        {
            aa = infra.DocumentCreate(ka, editor);
        }
        
        if (!b)
        {
        	boolean ba;
        	ba = false;
        	
        	OutlinePage kaa;
            kaa = aa.OutlinePage();
            
            if (!ba)
            {
                if (kaa == null)
                {
                	ba = true;
                }
            }
            if (!ba)
            {
            	if (kaa.IsFinal())
            	{
            		ba = true;
            	}
            }
            
            if (ba)
        	{
            	OutlinePage kab;
            	kab = new OutlinePage();
            	kab.Init();
            	kab.Document(aa);
                
                aa.OutlinePage(kab);
        	}
        }
        
        infra.DocumentSchedule(aa);
        
        OutlinePage a;
    	a = aa.OutlinePage();
        
        a.Update();

        return (T)a;
    }

    public java.lang.Class<?>[] getAdapterList()
    {
        return new java.lang.Class<?>[]
        { IContentOutlinePage.class };
    }
}