package org.alanng10.eclass;

import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.texteditor.ITextEditor;

public class Startup implements IStartup
{
    public void earlyStartup()
    {
        IWorkbench k;
        k = PlatformUI.getWorkbench();

        IWorkbenchWindow window;
        window = k.getWorkbenchWindows()[0];

        IWorkbenchPage activePage;
        activePage = window.getActivePage();

        PartListener aa;
        aa = new PartListener();
        aa.Init();

        activePage.addPartListener(aa);

        this.CreateDocumentList(activePage);
    }

    private boolean CreateDocumentList(IWorkbenchPage page)
    {
    	Plugin plugin;
    	plugin = Plugin.This();
    	
        Infra infra;
        infra = plugin.Infra();

        IEditorReference[] k;
        k = page.getEditorReferences();

        int count;
        count = k.length;
        int i;
        i = 0;
        while (i < count)
        {
            IEditorReference ka;
            ka = k[i];

            IEditorPart kk;
            kk = ka.getEditor(false);

            if (!(kk == null))
            {
                ITextEditor ke;
                ke = infra.Editor(kk);
                
                if (!(ke == null))
                {
                    IDocument aa;
                    aa = infra.EditorDocument(ke);

                    if (!(aa == null))
                    {
                        Document a;
                        a = plugin.DocumentTable().get(aa);
                        
                        if (a == null)
                        {
                            a = infra.DocumentCreate(aa, ke);   
                        }
                        
                        infra.DocumentSchedule(a);
                    }   
                }
            }

            i = i + 1;
        }

        return true;
    }
}
