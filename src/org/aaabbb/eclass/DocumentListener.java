package org.aaabbb.eclass;

import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;

public class DocumentListener implements IDocumentListener
{
    public boolean Init()
    {
        return true;
    }
    
    public Document Document;

    public void documentAboutToBeChanged(DocumentEvent event)
    {
        Log.This().Info("Document About to Change");
    }

    public void documentChanged(DocumentEvent event)
    {
        Log.This().Info("Document Changed");

        IDocument document;
        document = event.getDocument();

        String text;
        text = document.get();

        this.Document.Load.Text = text;

        this.Document.Job.Schedule(1000);

        Log.This().Info("Text: " + text);
    }
}
