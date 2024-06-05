package org.aaabbb.e;

import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;

public class DocumentListener implements IDocumentListener
{	
    public void documentAboutToBeChanged(DocumentEvent event)
    {
    	Log.This.Info("Document About to Change");
    }

    public void documentChanged(DocumentEvent event)
    {
        Log.This.Info("Document Changed");
        
//        String k;
//        k = event.getText();
        
        IDocument document;
        document = event.getDocument();

        String text;
        text = document.get();
        
        Log.This.Info("Text: " + text);
//        Log.This.Info("Insert Text: " + k);
    }
}
