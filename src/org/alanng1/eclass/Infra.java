package org.alanng1.eclass;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.ITextEditor;

public class Infra extends Any
{
    public Document DocumentCreate(IDocument o, ITextEditor editor)
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
        job.Document(a);

        DocumentListener listener;
        listener = new DocumentListener();
        listener.Init();
        listener.Document(a);
        
        DocumentLoad load;
        load = new DocumentLoad();
        load.Init();
        load.Text(text);

        OutlinePage page;
        page = new OutlinePage();
        page.Init();
        page.Document(a);

        a.IDocument(o);
        a.Editor(editor);
        a.Job(job);
        a.Listener(listener);
        a.Load(load);
        a.OutlinePage(page);

        o.addDocumentListener(listener);

        Plugin.This().DocumentTable().put(a.IDocument(), a);

        return a;
    }

    public boolean DocumentSchedule(Document a)
    {
        a.Job().Schedule(1000);
        return true;
    }

    public ITextEditor Editor(IEditorPart part)
    {
        if (part instanceof ITextEditor)
        {
            ITextEditor a;
            a = (ITextEditor)part;
            return a;
        }
        return null;
    }
    
    public IDocument EditorDocument(ITextEditor editor)
    {
        IEditorInput input;
        input = editor.getEditorInput();
        
        if (!(input instanceof FileEditorInput))
        {
            return null;
        }
        
        FileEditorInput eo;
        eo = (FileEditorInput)input;

        IPath path;
        path = eo.getPath();

        String eu;
        eu = path.getFileExtension();

        if (eu == null)
        {
            return null;
        }
        
        eu = eu.toLowerCase();

        if (!eu.equals("cla"))
        {
            return null;
        }
        
        IDocument document;
        document = editor.getDocumentProvider().getDocument(input);
        return document;
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
    

    public String NameLabel(String name)
    {
        if (name == null)
        {
            return "#Unnamed";
        }
        return name;
    }
    
    public String ClassLabel(String varClass)
    {
        if (varClass == null)
        {
            return "#Unclassed";
        }
        return varClass;
    }
}
