package org.alanng10.eclass;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.ITextEditor;

public class Infra extends Any
{
    public static Infra This()
    {
        return This_D;
    }

    private static final Infra This_D = ShareCreate();

    private static Infra ShareCreate()
    {
        Infra share;
        share = new Infra();
        Any a;
        a = share;
        a.Init();
        return share;
    }
    
    public Document DocumentCreate(IDocument o, ITextEditor editor)
    {
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
        
        FileEditorInput input;
        input = this.EditorFileInput(editor);
        
        IFile file;
        file = input.getFile();

        a.IDocument(o);
        a.Editor(editor);
        a.File(file);
        a.Job(job);
        a.Listener(listener);
        a.Load(load);
        a.OutlinePage(page);

        if (!(Plugin.This().DocumentThread() == null))
        {
            o.addDocumentListener(listener);
        }
        
        Plugin.This().DocumentTable().put(a.IDocument(), a);

        return a;
    }

    public boolean DocumentSchedule(Document a)
    {
        if (Plugin.This().DocumentThread() == null)
        {
            return false;
        }
        
        a.Job().Schedule(500);
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
    
    public FileEditorInput EditorFileInput(ITextEditor editor)
    {
        IEditorInput input;
        input = editor.getEditorInput();
        
        if (!(input instanceof FileEditorInput))
        {
            return null;
        }
        
        FileEditorInput a;
        a = (FileEditorInput)input;
        
        return a;
    }
    
    public IDocument EditorDocument(ITextEditor editor)
    {   
        FileEditorInput eo;
        eo = this.EditorFileInput(editor);
        
        if (eo == null)
        {
            return null;
        }

        IPath path;
        path = eo.getPath();

        String eu;
        eu = path.getFileExtension();

        if (eu == null)
        {
            return null;
        }
        
        eu = eu.toLowerCase();

        if (!eu.equals("cl"))
        {
            return null;
        }
        
        IDocument document;
        document = editor.getDocumentProvider().getDocument(eo);
        return document;
    }
    
    public boolean CreateMarker(IFile file, Error error)
    {
        IMarker marker;
        marker = null;
        try
        {
            marker = file.createMarker(IMarker.PROBLEM);
        } catch (CoreException e)
        {
            Log.This().Error("Create marker error", e);
            return false;
        }
        
        String ka;
        ka = error.Text();
        
        String k;
        k = this.StringPosRange(error.Range());
        
        try
        {
            marker.setAttribute(IMarker.MESSAGE, ka);
            marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
            marker.setAttribute(IMarker.LOCATION, k);
        } catch (CoreException e)
        {
            Log.This().Error("Set marker attribute error", e);
            return false;
        }
        
        return true;
    }
    
    public String StringPosRange(PosRange range)
    {
        StringBuilder h;
        h = new StringBuilder();
        
        Pos start;
        Pos end;
        start = range.Start();
        end = range.End();
        
        this.StringAppendPos(h, start);
        
        h.append(" to ");
        
        this.StringAppendPos(h, end);
        
        String a;
        a = h.toString();
        return a;
    }
    
    public boolean StringAppendPos(StringBuilder h, Pos pos)
    {
        int ka;
        int kb;
        
        ka = pos.Row();
        ka = ka + 1;
        
        kb = pos.Col();
        kb = kb + 1;
        
        h.append("(Row ");
        h.append(ka);
        h.append(", Col ");
        h.append(kb);
        h.append(")");
        return true;
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

    public boolean DataSetString(byte[] data, int index, String o)
    {
        int totalCount;
        totalCount = data.length;

        int charCount;
        charCount = o.length();

        int byteCount;
        byteCount = charCount * 4;
        
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
            return "#Unname";
        }
        return name;
    }
    
    public String ClassLabel(String varClass)
    {
        if (varClass == null)
        {
            return "#Unclass";
        }
        return varClass;
    }
}
