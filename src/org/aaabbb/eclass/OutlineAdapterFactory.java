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

            Log.This().Info("OutlineAdapterFactory.getAdapter 3333");

            IEditorPart ko;
            ko = editor;

            Infra infra;
            infra = Plugin.This().Infra();

            Log.This().Info("OutlineAdapterFactory.getAdapter 4444");

            IDocument ka;
            ka = infra.EditorDocument(ko);

            Log.This().Info("OutlineAdapterFactory.getAdapter 5555");

            if (!(ka == null))
            {
                Log.This().Info("OutlineAdapterFactory.getAdapter 6666");

                Document aa;
                aa = Plugin.This().DocumentTable().get(ka);

                Log.This().Info("OutlineAdapterFactory.getAdapter 7777");

                boolean b;
                b = (aa == null);
                
                if (b)
                {
                    Log.This().Info("OutlineAdapterFactory.getAdapter 8888");

                    aa = infra.DocumentCreate(ka);

                    Log.This().Info("OutlineAdapterFactory.getAdapter 9999");
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
                    
                    Log.This().Info("OutlineAdapterFactory.getAdapter BBBB");
                }
                
                Log.This().Info("OutlineAdapterFactory.getAdapter CCCC");
                
                infra.DocumentSchedule(aa);
                
                Log.This().Info("OutlineAdapterFactory.getAdapter DDDD");
                
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