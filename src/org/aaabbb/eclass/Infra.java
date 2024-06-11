package org.aaabbb.eclass;

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
        
        String text;
        text = o.get();

        Document a;
        a = new Document();
        a.Init();

        DocumentJob job;
        job = new DocumentJob();
        job.Init();
        job.DocumentSet(a);

        DocumentListener listener;
        listener = new DocumentListener();
        listener.Init();
        listener.DocumentSet(a);

        DocumentLoad load;
        load = new DocumentLoad();
        load.Init();
        load.TextSet(text);

        OutlinePage page;
        page = new OutlinePage();
        page.Init();
        page.DocumentSet(a);

        a.IDocumentSet(o);
        a.JobSet(job);
        a.ListenerSet(listener);
        a.LoadSet(load);
        a.OutlinePageSet(page);

        o.addDocumentListener(listener);

        Plugin.This().DocumentTable().put(a.IDocument(), a);

        return a;
    }

    public boolean DocumentSchedule(Document a)
    {
        a.Job().Schedule(1000);
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

            if (!(eu == null))
            {
                eu = eu.toLowerCase();

                if (eu.equals("cla"))
                {
                    IDocument document;
                    document = ee.getDocumentProvider().getDocument(input);
                    return document;
                }
            }
        }
        return null;
    }
    
    public boolean CheckRange(int totalCount, int index, int count)
    {
        if (totalCount < 0)
        {
            return false;
        }
        if (index < 0)
        {
            return false;
        }
        if (count < 0)
        {
            return false;
        }
        
        if (totalCount < index + count)
        {
            return false;
        }
        return true;
    }
    
    public boolean DataSetChar(byte[] data, int index, char value)
    {
        int k;
        k = value;
        
        byte oba;
        byte obb;
        oba = (byte)k;
        obb = (byte)(k >> 8);
        
        data[index] = oba;
        data[index + 1] = obb;
        
        return true;
    }

    public boolean DataGetString(byte[] data, int index, String o)
    {
        int totalCount;
        totalCount = data.length;
        
        int charCount;
        charCount = o.length();
        
        int byteCount;
        byteCount = charCount * 2;
        
        if (!(this.CheckRange(totalCount, index, byteCount)))
        {
            return false;
        }
        
        int count;
        count = charCount;
        int i;
        i = 0;
        while (i < count)
        {
            int ka;
            ka = index + i * 2;
            
            char oc;
            oc = o.charAt(i);
            
            this.DataSetChar(data, ka, oc);
            
            i = i + 1;
        }
        return true;
    }
}
