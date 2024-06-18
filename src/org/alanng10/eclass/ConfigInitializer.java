package org.alanng10.eclass;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

public class ConfigInitializer extends AbstractPreferenceInitializer
{
    public void initializeDefaultPreferences()
    {
        ConfigIndex configIndex;
        configIndex = Plugin.This().ConfigIndex();
        
        ScopedPreferenceStore k;
        k = new ScopedPreferenceStore(InstanceScope.INSTANCE, Plugin.PLUGIN_ID);
        
        k.setDefault(configIndex.OutlineSort(), false);
        
        k.setDefault(configIndex.OutlineKind(), false);
    }
}