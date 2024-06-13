package org.aaabbb.eclass;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.texteditor.AbstractTextEditor;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

public class OutlineAdapterFactory implements IAdapterFactory
{
    @SuppressWarnings("unchecked")
    public <T> T getAdapter(Object adaptableObject, java.lang.Class<T> required)
    {
        if (IContentOutlinePage.class.equals(required))
        {
            AbstractTextEditor editor;
            editor = (AbstractTextEditor)adaptableObject;

            IEditorPart ko;
            ko = editor;

            Infra infra;
            infra = Plugin.This().Infra();

            IDocument ka;
            ka = infra.EditorDocument(ko);

            if (!(ka == null))
            {
                Document aa;
                aa = Plugin.This().DocumentTable().get(ka);

                boolean b;
                b = (aa == null);
                
                if (b)
                {
                    aa = infra.DocumentCreate(ka);
                }
                
                if (!b)
                {                	
                	boolean ba;
                	ba = false;
                	
                	OutlinePage kkk;
                    kkk = aa.OutlinePage();
                    
                    if (!ba)
                    {
	                    if (kkk == null)
	                    {
	                    	ba = true;
	                    }
                    }
                    if (!ba)
                    {
                    	if (kkk.IsFinal())
                    	{
                    		ba = true;
                    	}
                    }
                    
                    if (ba)
                	{
                    	OutlinePage kk;
                    	kk = new OutlinePage();
                    	kk.Init();
                    	kk.Document(aa);
                        
                        aa.OutlinePage(kk);
                	}                    
                }
                
                infra.DocumentSchedule(aa);
                
                OutlinePage a;
            	a = aa.OutlinePage();
                
                a.Update();

                return (T)a;
            }
        }
        return null;
    }

    public java.lang.Class<?>[] getAdapterList()
    {
        return new java.lang.Class<?>[]
        { IContentOutlinePage.class };
    }
}