package org.aaabbb.e;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class Plugin extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "org.aaabbb.class";

	private static Plugin plugin;

	public static Plugin Default()
	{
		return plugin;
	}

	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		Log.Info("Plugin Start");
	}

	public void stop(BundleContext context) throws Exception {
		Log.Info("Plugin Stop");
		plugin = null;
		super.stop(context);
	}
}
