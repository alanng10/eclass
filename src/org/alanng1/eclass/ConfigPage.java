package org.alanng1.eclass;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

public class ConfigPage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage
{
    public ConfigPage()
    {
        super("Class", FieldEditorPreferencePage.GRID);
    }

    protected void createFieldEditors()
    {
        this.addField(new BooleanFieldEditor("Outline.Sort", "&Sort outline Comps alphabetically", this.getFieldEditorParent()));
        
        this.addField(new BooleanFieldEditor("Outline.Kind", "&Group outline Comps by kind", this.getFieldEditorParent()));
    }

    public void init(IWorkbench workbench)
    {
        this.setPreferenceStore(new ScopedPreferenceStore(InstanceScope.INSTANCE, Plugin.PLUGIN_ID));
        
        this.setDescription("Class programming language config");
    }
}