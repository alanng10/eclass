package org.aaabbb.e;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;

public class OutlinePage extends ContentOutlinePage
{
	public Class Class;
	
	public void createControl(Composite parent) {
		super.createControl(parent);
  
		TreeContentProvider aa;
		aa = new TreeContentProvider();
	  
		TreeLabelProvider ab;
		ab = new TreeLabelProvider();
		
		TreeViewer viewer;
		viewer = getTreeViewer();
		viewer.setContentProvider(aa);
		viewer.setLabelProvider(ab);
		viewer.addSelectionChangedListener(this);
		viewer.setInput(this.Class);
	}
}
