package org.aaabbb.eclass;

import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocumentListener;

public class DocumentListener extends Any implements IDocumentListener
{
    public Document Document()
    {
    	return this.Document_D;
    }
    
    public boolean DocumentSet(Document value)
    {
    	this.Document_D = value;
    	return true;
    }
   
    protected Document Document_D;

    public void documentAboutToBeChanged(DocumentEvent event)
    {
    }

    public void documentChanged(DocumentEvent event)
    {
        Document a;
        a = this.Document();
        
        String text;
        text = a.IDocument().get();

        a.Load().TextSet(text);

        Plugin.This().Infra().DocumentSchedule(a);
    }
}
