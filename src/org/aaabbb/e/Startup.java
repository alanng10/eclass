package org.aaabbb.e;

import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public class Startup implements IStartup
{
    public void earlyStartup()
    {
        Log.This().Info("Startup AaaBbb Class");

        IWorkbench k;
        k = PlatformUI.getWorkbench();

        IWorkbenchWindow window;
        window = k.getWorkbenchWindows()[0];

        IWorkbenchPage activePage;
        activePage = window.getActivePage();

        PartListener aa;
        aa = new PartListener();

        activePage.addPartListener(aa);

        this.CreateDocumentList(activePage);
    }

    private boolean CreateDocumentList(IWorkbenchPage page)
    {
        Infra infra;
        infra = Plugin.This().Infra();

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
                IDocument aa;
                aa = infra.EditorDocument(kk);

                if (!(aa == null))
                {
                    Document a;
                    a = infra.DocumentCreate(aa);

                    if (!(a == null))
                    {
                        infra.DocumentSchedule(a);
                    }
                }
            }

            i = i + 1;
        }

        return true;
    }
}
