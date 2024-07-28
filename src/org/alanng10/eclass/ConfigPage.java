package org.alanng10.eclass;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
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
        ConfigIndex configIndex;
        configIndex = Plugin.This().ConfigIndex();
        
        this.addField(new StringFieldEditor(configIndex.ClassServerFilePath(), "&Class server executable file path", this.getFieldEditorParent()));
        
        this.addField(new IntegerFieldEditor(configIndex.NetworkPortHost(), "&Network port server number", this.getFieldEditorParent()));
        
        this.addField(new BooleanFieldEditor(configIndex.OutlineSort(), "&Sort outline comps alphabetically", this.getFieldEditorParent()));
        
        this.addField(new BooleanFieldEditor(configIndex.OutlineKind(), "&Group outline comps by kind", this.getFieldEditorParent()));
    }

    public void init(IWorkbench workbench)
    {
        this.setPreferenceStore(new ScopedPreferenceStore(InstanceScope.INSTANCE, Plugin.PLUGIN_ID));
        
        this.setDescription("Class programming language config");
    }
}