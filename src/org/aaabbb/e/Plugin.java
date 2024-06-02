package org.aaabbb.e;

import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.jface.text.IDocument;
import org.osgi.framework.BundleContext;

public class Plugin extends AbstractUIPlugin {

	public void start(BundleContext context) throws Exception
	{
		super.start(context);
		
		
	    IWorkbench workbench;
	    workbench = PlatformUI.getWorkbench();
	      
	    IWorkbenchWindow window;
	    window = workbench.getActiveWorkbenchWindow();
	      
	    IWorkbenchPage page;
	    page = window.getActivePage();
	      
	    ITextEditor editor;
	    editor = (ITextEditor)page.getActiveEditor();
		
	    IEditorInput aa;
	    aa = editor.getEditorInput();
	}
	
	
	private IFile getFileFromEditorInput(IEditorInput input)
	{
	  if (input == null)
	    return null;

	  if (input instanceof IFileEditorInput)
	    return ((IFileEditorInput)input).getFile();

	  IPath path = getPathFromEditorInput(input);
	  if (path == null)
	    return null;

	  return ResourcesPlugin.getWorkspace().getRoot().getFile(path);
	}


	private IPath getPathFromEditorInput(IEditorInput input)
	{
	  if (input instanceof ILocationProvider)
	    return ((ILocationProvider)input).getPath(input);

	  if (input instanceof IURIEditorInput)
	   {
	     URI uri = ((IURIEditorInput)input).getURI();
	     if (uri != null)
	      {
	        IPath path = URIUtil.toPath(uri);
	        if (path != null)
	          return path;
	      }
	   }

	  return null;
	}
}
