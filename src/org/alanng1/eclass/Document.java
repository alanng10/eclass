package org.alanng1.eclass;

import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.texteditor.ITextEditor;

public class Document extends Any
{
    public IDocument IDocument()
    {
        return this.IDocument_D;
    }

    public boolean IDocument(IDocument value)
    {
        this.IDocument_D = value;
        return true;
    }

    protected IDocument IDocument_D;

    public ITextEditor Editor()
    {
        return this.Editor_D;
    }

    public boolean Editor(ITextEditor value)
    {
        this.Editor_D = value;
        return true;
    }

    protected ITextEditor Editor_D;

    public DocumentJob Job()
    {
        return this.Job_D;
    }

    public boolean Job(DocumentJob value)
    {
        this.Job_D = value;
        return true;
    }

    protected DocumentJob Job_D;

    public DocumentListener Listener()
    {
        return this.Listener_D;
    }

    public boolean Listener(DocumentListener value)
    {
        this.Listener_D = value;
        return true;
    }

    protected DocumentListener Listener_D;

    public DocumentLoad Load()
    {
        return this.Load_D;
    }

    public boolean Load(DocumentLoad value)
    {
        this.Load_D = value;
        return true;
    }

    protected DocumentLoad Load_D;

    public OutlinePage OutlinePage()
    {
        return this.OutlinePage_D;
    }

    public boolean OutlinePage(OutlinePage value)
    {
        this.OutlinePage_D = value;
        return true;
    }

    protected OutlinePage OutlinePage_D;
}