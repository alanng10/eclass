package org.aaabbb.e;

import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.tm4e.ui.text.TMPresentationReconciler;

public class ViewerConfiguration extends SourceViewerConfiguration
{
	@Override
	public IPresentationReconciler getPresentationReconciler(final ISourceViewer viewer)
	{
		return new TMPresentationReconciler();
	}
}
