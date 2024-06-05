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
	
	private Hashtable<IDocument, DocumentJob> DocumentTable_D;

	public int Init()
	{
		this.DocumentTable_D = new Hashtable<IDocument, DocumentJob>();
		return 0;
	}

	public Hashtable<IDocument, DocumentJob> DocumentTable()
	{
		return this.DocumentTable_D;
	}
	
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		
		Log.This.Info("Plugin Start");
	}

	public void stop(BundleContext context) throws Exception {
		Log.This.Info("Plugin Stop");
		
		plugin = null;
		super.stop(context);
	}
}
