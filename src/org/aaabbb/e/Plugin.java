package org.aaabbb.e;

import java.util.Hashtable;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class Plugin extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "org.aaabbb.class";

	private static Plugin plugin;

	public static Plugin This()
	{
		return plugin;
	}
	
	private Hashtable<IDocument, Document> DocumentTable_D;

	private DocumentThread DocumentThread_D;

	private NetworkStartThread NetworkStartThread_D;
	
	private Image ImageIconClass_D;
	
	public boolean Init()
	{
		this.DocumentTable_D = new Hashtable<IDocument, Document>();
		
		this.DocumentThread_D = new DocumentThread();
		this.DocumentThread_D.Init();
		
		this.NetworkStartThread_D = new NetworkStartThread();
		
		ImageDescriptor oo;
		oo = Plugin.imageDescriptorFromPlugin(PLUGIN_ID, "icon/class.png");
		
		Image k;
		k = oo.createImage();

		this.ImageIconClass_D = k;
		return true;
	}

	public Hashtable<IDocument, Document> DocumentTable()
	{
		return this.DocumentTable_D;
	}
	
	public DocumentThread DocumentThread()
	{
		return this.DocumentThread_D;
	}
	
	public NetworkStartThread NetworkStartThread()
	{
		return this.NetworkStartThread_D;
	}
	
	public Image ImageIconClass()
	{
		return this.ImageIconClass_D;
	}
	
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		
		Log.This.Info("Plugin Start");
		
		this.Init();
	}

	public void stop(BundleContext context) throws Exception {
		Log.This.Info("Plugin Stop");
		
		plugin = null;
		super.stop(context);
	}
}
