package org.aaabbb.e;

import java.util.Hashtable;
import org.eclipse.jface.text.IDocument;
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
	
	public boolean Init()
	{
		this.DocumentTable_D = new Hashtable<IDocument, Document>();
		
		this.DocumentThread_D = new DocumentThread();
		this.DocumentThread_D.Init();
		
		this.NetworkStartThread_D = new NetworkStartThread();
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
	
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		
		this.Init();
		
		Log.This.Info("Plugin Start");
	}

	public void stop(BundleContext context) throws Exception {
		Log.This.Info("Plugin Stop");
		
		plugin = null;
		super.stop(context);
	}
}
