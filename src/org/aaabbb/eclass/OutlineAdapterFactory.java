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

                if (aa == null)
                {
                    Log.This().Info("OutlineAdapterFactory.getAdapter 8888");

                    aa = infra.DocumentCreate(ka);

                    Log.This().Info("OutlineAdapterFactory.getAdapter 9999");

                    infra.DocumentSchedule(aa);

                    Log.This().Info("OutlineAdapterFactory.getAdapter AAAA");
                }
                
                OutlinePage kkk;
                kkk = aa.OutlinePage();
                if (!(kkk == null))
                {
                	if (!kkk.IsFinal())
                	{
                		kkk.Final();
                	}
                }
                
                OutlinePage a;
                a = new OutlinePage();
                a.Init();
                a.DocumentSet(aa);
                
                aa.OutlinePageSet(a);
                
                a.Update();
                
                Log.This().Info("OutlineAdapterFactory.getAdapter BBBB");

                return (T)a;
            }
        }

        Log.This().Info("OutlineAdapterFactory.getAdapter BBBB");
        return null;
    }

    public java.lang.Class<?>[] getAdapterList()
    {
        return new java.lang.Class<?>[]
        { IContentOutlinePage.class };
    }
}