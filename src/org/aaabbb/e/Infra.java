package org.aaabbb.e;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.ITextEditor;

public class Infra extends Any
{
    public Document DocumentCreate(IDocument o)
    {
        if (Plugin.This().DocumentTable().containsKey(o))
        {
            return null;
        }

        Log.This().Info("Class Document Create");

        Document a;
        a = new Document();
        a.Init();

        DocumentJob job;
        job = new DocumentJob();
        job.Document = a;

        DocumentListener listener;
        listener = new DocumentListener();
        listener.Document = a;

        DocumentLoad load;
        load = new DocumentLoad();
        load.Init();

        OutlinePage page;
        page = new OutlinePage();

        a.IDocument = o;
        a.Job = job;
        a.Listener = listener;
        a.Load = load;
        a.OutlinePage = page;

        a.IDocument.addDocumentListener(listener);

        Plugin.This().DocumentTable().put(a.IDocument, a);

        return a;
    }

    public boolean DocumentSchedule(Document a)
    {
        a.Job.Schedule(1000);
        return true;
    }

    public IDocument EditorDocument(IEditorPart editor)
    {
        IEditorInput input;
        input = editor.getEditorInput();
        if (editor instanceof ITextEditor & input instanceof FileEditorInput)
        {
            ITextEditor ee;
            ee = (ITextEditor) editor;

            FileEditorInput eo;
            eo = (FileEditorInput) input;

            IPath path;
            path = eo.getPath();

            String eu;
            eu = path.getFileExtension();

            eu = eu.toLowerCase();

            if (eu.equals("cla"))
            {
                IDocument document;
                document = ee.getDocumentProvider().getDocument(input);
                return document;
            }
        }
        return null;
    }
}
