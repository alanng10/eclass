package org.aaabbb.e;

import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;

public class DocumentListener implements IDocumentListener
{	
	public DocumentJob Job;
	
    public void documentAboutToBeChanged(DocumentEvent event)
    {
    	Log.This.Info("Document About to Change");
    }

    public void documentChanged(DocumentEvent event)
    {
        Log.This.Info("Document Changed");
        
        IDocument document;
        document = event.getDocument();

        String text;
        text = document.get();
        
        this.Job.Text = text;
        this.Job.schedule(1000);
        this.Job.wakeUp(1000);
        
        Log.This.Info("Text: " + text);
    }
}
