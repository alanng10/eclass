package org.aaabbb.e;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

public class OutlineAdapterFactory implements IAdapterFactory
{
	@Override
	public <T> T getAdapter(Object adaptableObject, java.lang.Class<T> required)
	{
		if (IContentOutlinePage.class.equals(required))
		{
            GenericEditor editor;
            editor = (GenericEditor)adaptableObject;
    	  
    	  	OutlinePage a;
    	  	a = new OutlinePage();
            return (T) a;
		}
		return null;
   	}
 
	@Override
	public java.lang.Class<?>[] getAdapterList()
	{
		return new java.lang.Class<?>[] { IContentOutlinePage.class };
	}
}