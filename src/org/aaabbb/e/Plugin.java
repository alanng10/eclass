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
	
	private Image ImageIconField_D;
	
	private Image ImageIconMaide_D;
	
	private Infra Infra_D;
	
	public boolean Init()
	{
		this.DocumentTable_D = new Hashtable<IDocument, Document>();
		
		this.DocumentThread_D = new DocumentThread();
		this.DocumentThread_D.Init();
		
		this.NetworkStartThread_D = new NetworkStartThread();
		this.NetworkStartThread_D.Init();
		
		this.ImageIconClass_D = this.CreateImage("class");
		
		this.ImageIconField_D = this.CreateImage("field");
		
		this.ImageIconMaide_D = this.CreateImage("maide");
		
		this.Infra_D = new Infra();
		this.Infra_D.Init();
		
        this.DocumentThread().start();
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
	
	public Image ImageIconField()
	{
		return this.ImageIconField_D;
	}
	
	public Image ImageIconMaide()
	{
		return this.ImageIconMaide_D;
	}
	
	public Infra Infra()
	{
		return this.Infra_D;
	}
	
	private Image CreateImage(String name)
	{
		ImageDescriptor k;
        k = Plugin.imageDescriptorFromPlugin(PLUGIN_ID, "icon/" + name + ".png");
		
		Image a;
		a = k.createImage();
		
		return a;
	}
	
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		
		Log.This().Info("Plugin Start");
		
		this.Init();
	}

	public void stop(BundleContext context) throws Exception {
		Log.This().Info("Plugin Stop");
		
		plugin = null;
		super.stop(context);
	}
}
