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
        Log.This().Info("OutlineAdapterFactory.getAdapter 1111");

        if (IContentOutlinePage.class.equals(required))
        {
            Log.This().Info("OutlineAdapterFactory.getAdapter 2222");

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
                Log.This().Info("OutlineAdapterFactory.getAdapter 6666");

                Document aa;
                aa = Plugin.This().DocumentTable().get(ka);

                boolean b;
                b = (aa == null);
                
                if (b)
                {
                    Log.This().Info("OutlineAdapterFactory.getAdapter 8888");
                    aa = infra.DocumentCreate(ka);
                }
                
                if (!b)
                {
                	Log.This().Info("OutlineAdapterFactory.getAdapter AAAA");
                	
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
                    	kk.DocumentSet(aa);
                        
                        aa.OutlinePageSet(kk);
                	}                    
                }
                
                infra.DocumentSchedule(aa);
                
                OutlinePage a;
            	a = aa.OutlinePage();
                
                a.Update();
                
                Log.This().Info("OutlineAdapterFactory.getAdapter EEEE");

                return (T)a;
            }
        }

        Log.This().Info("OutlineAdapterFactory.getAdapter FFFF");
        return null;
    }

    public java.lang.Class<?>[] getAdapterList()
    {
        return new java.lang.Class<?>[]
        { IContentOutlinePage.class };
    }
}