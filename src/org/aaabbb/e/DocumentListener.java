package org.aaabbb.e;

import org.eclipse.jface.text.DocumentEvent;
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
    }
}
