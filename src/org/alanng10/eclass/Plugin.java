package org.alanng10.eclass;

import java.util.Hashtable;
import java.util.Optional;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ResourceLocator;
import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.osgi.framework.BundleContext;

public class Plugin extends AbstractUIPlugin
{
    public static final String PLUGIN_ID = "org.alanng10.eclass";

    private static Plugin plugin;

    public static Plugin This()
    {
        return plugin;
    }

    public boolean Init()
    {
        this.DocumentTable_D = new Hashtable<IDocument, Document>();

        this.ImageIconClass_D = this.CreateImageIcon(false, "obj16/class_obj");

        this.ImageIconField_D = this.CreateImageIcon(false, "obj16/methdef_obj");

        this.ImageIconMaide_D = this.CreateImageIcon(false, "obj16/methpri_obj");
        
        this.ImageIconSourceFile_D = this.CreateImageIcon(true, "sourcefile.gif");
        
        this.ImageIconClassName_D = this.CreateImageIcon(false, "obj16/methpub_obj");

        this.ImageIconBaseName_D = this.CreateImageIcon(false, "obj16/methpro_obj");
        
        this.ImageIconDescriptorSort_D = this.CreateImageIconDescriptor(false, "elcl16/alphab_sort_co");
        
        this.ImageIconDescriptorKind_D = this.CreateImageIconDescriptor(false, "elcl16/th_vertical");
        
        this.ConfigIndex_D = new ConfigIndex();
        this.ConfigIndex_D.Init();
        
        this.ResourceChangeListener_D = new ResourceChangeListener();
        this.ResourceChangeListener_D.Init();
        return true;
    }
    
    private Hashtable<IDocument, Document> DocumentTable_D;

    private DocumentThread DocumentThread_D;

    private Image ImageIconClass_D;

    private Image ImageIconField_D;

    private Image ImageIconMaide_D;
    
    private Image ImageIconSourceFile_D;
    
    private Image ImageIconClassName_D;
    
    private Image ImageIconBaseName_D;
    
    private ImageDescriptor ImageIconDescriptorSort_D;
    
    private ImageDescriptor ImageIconDescriptorKind_D;

    private ConfigIndex ConfigIndex_D;
    
    private ResourceChangeListener ResourceChangeListener_D;

    public Hashtable<IDocument, Document> DocumentTable()
    {
        return this.DocumentTable_D;
    }

    public DocumentThread DocumentThread()
    {
        return this.DocumentThread_D;
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
    
    public Image ImageIconSourceFile()
    {
        return this.ImageIconSourceFile_D;
    }
    
    public Image ImageIconClassName()
    {
        return this.ImageIconClassName_D;
    }
    
    public Image ImageIconBaseName()
    {
        return this.ImageIconBaseName_D;
    }
    
    public ImageDescriptor ImageIconDescriptorSort()
    {
        return this.ImageIconDescriptorSort_D;
    }
    
    public ImageDescriptor ImageIconDescriptorKind()
    {
        return this.ImageIconDescriptorKind_D;
    }
    
    public ConfigIndex ConfigIndex()
    {
        return this.ConfigIndex_D;
    }
    
    public ResourceChangeListener ResourceChangeListener()
    {
        return this.ResourceChangeListener_D;
    }
    
    public boolean ThreadStart()
    {
        ConfigIndex configIndex;
        configIndex = this.ConfigIndex();
        
        ScopedPreferenceStore ka;
        ka = new ScopedPreferenceStore(InstanceScope.INSTANCE, Plugin.PLUGIN_ID);

        String classServerFilePath;
        classServerFilePath = ka.getString(configIndex.ClassServerFilePath());

        int networkPortHost;
        networkPortHost = ka.getInt(configIndex.NetworkPortHost());
        
        if (classServerFilePath == null)
        {
            return false;
        }
        
        if (classServerFilePath.length() == 0)
        {
            return false;
        }
        
        if (!(0 < networkPortHost))
        {
            return false;
        }
        
        DocumentThread thread;
        thread = new DocumentThread();

        thread.ClassServerFilePath(classServerFilePath);
        thread.NetworkPortHost(networkPortHost);

        thread.Init();
        
        this.DocumentThread_D = thread;
        
        thread.start();
        return true;
    }

    private Image CreateImageIcon(boolean local, String name)
    {
        ImageDescriptor k;
        k = this.CreateImageIconDescriptor(local, name);
        
        Image a;
        a = k.createImage();

        return a;
    }
    
    private ImageDescriptor CreateImageIconDescriptor(boolean local, String name)
    {
        if (local)
        {
            return this.CreateImageDescriptor(PLUGIN_ID, "icon/" + name);
        }
         
        return this.CreateImageDescriptor("org.eclipse.jdt.ui", "icons/full/" + name + ".png");
    }
    
    private ImageDescriptor CreateImageDescriptor(String bundleName, String path)
    {
        Optional<ImageDescriptor> ka;
        ka = ResourceLocator.imageDescriptorFromBundle(bundleName, path);
        
        ImageDescriptor k;
        k = ka.get();
        return k;
    }

    public void start(BundleContext context) throws Exception
    {
        super.start(context);
        plugin = this;

        this.Init();
        
        this.ThreadStart();
    
        ResourcesPlugin.getWorkspace().addResourceChangeListener(this.ResourceChangeListener(), IResourceChangeEvent.POST_CHANGE);
    }

    public void stop(BundleContext context) throws Exception
    {
        ResourcesPlugin.getWorkspace().removeResourceChangeListener(this.ResourceChangeListener());
        
    	this.DocumentThread().Continue(false);
    	this.DocumentThread().Phore().release();
    	
        plugin = null;
        super.stop(context);
    }
}
