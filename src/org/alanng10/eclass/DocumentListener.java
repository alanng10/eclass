package org.alanng10.eclass;

//import org.eclipse.core.resources.IMarker;
//import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocumentListener;

public class DocumentListener extends Any implements IDocumentListener
{
    public Document Document()
    {
    	return this.Document_D;
    }
    
    public boolean Document(Document value)
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

        a.Load().Text(text);

        Infra.This().DocumentSchedule(a);
        
//        try
//        {
//            a.File().deleteMarkers(null, false, 0);
//        } catch (CoreException e)
//        {
//            Log.This().Error("Delete problem marker error", e);
//        }
//        
//        IMarker marker;
//        marker = null;
//        try
//        {
//            marker = a.File().createMarker(IMarker.PROBLEM);
//        } catch (CoreException e)
//        {
//            Log.This().Error("Create problem marker error", e);
//        }
//
//        try
//        {
//            marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
//            marker.setAttribute(IMarker.MESSAGE, "Demo Marker");
//            marker.setAttribute(IMarker.LOCATION, "row 3 col 4");
//        } catch (CoreException e)
//        {
//            Log.This().Error("Set problem marker error", e);
//        }
        
//        Log.This().Info("DocumentListener Changed Schedule");
    }
}
