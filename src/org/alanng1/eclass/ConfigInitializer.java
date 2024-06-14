package org.alanng1.eclass;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

public class ConfigInitializer extends AbstractPreferenceInitializer
{
    public void initializeDefaultPreferences()
    {
        ScopedPreferenceStore k;
        k = new ScopedPreferenceStore(InstanceScope.INSTANCE, Plugin.PLUGIN_ID);
        
        k.setDefault("Outline.Sort", false);
        
        k.setDefault("Outline.Kind", false);
    }
}