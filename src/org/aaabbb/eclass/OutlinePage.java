package org.aaabbb.eclass;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

public class OutlinePage extends Any implements IContentOutlinePage
{
    public boolean Init()
    {
        return true;
    }
    
    public boolean Final()
    {
        this.dispose();
        return true;
    }
    
    private Tree Tree;
    
    public void dispose()
    {
        if (!(this.Tree == null))
        {
            this.Tree.dispose();
        }
        
        this.IsFinalSet(true);
    }
    
    public boolean IsFinal()
    {
        return this.IsFinal_D;
    }
    
    public boolean IsFinalSet(boolean value)
    {
        this.IsFinal_D = value;
        return true;
    }
   
    protected boolean IsFinal_D;
    
    public Document Document()
    {
        return this.Document_D;
    }
    
    public boolean DocumentSet(Document value)
    {
        this.Document_D = value;
        return true;
    }
   
    protected Document Document_D;
    
    protected Class Data(Root root)
    {
        Class k;
        k = null;
        if (!(root == null))
        {
            k = root.Class();
        }
        Class a;
        a = k;
        return a;
    }
    
    public boolean Update()
    {
        if (this.Tree == null)
        {
            return false;
        }
        
        this.Tree.removeAll();
        
        Root root;
        root = this.Document().Load().Root();
        
        Class varClass;
        varClass = this.Data(root);
        
        if (!(varClass == null))
        {
            this.Tree.setRedraw(false);
            
            String unnamed;
            unnamed = "Unnamed";
            String unclassed;
            unclassed = "Unclassed";
            
            TreeItem item;
            String k;
            
            Comp[] array;
            array = varClass.Comp();
            
            int count;
            count = array.length;
            int i;
            i = 0;
            while (i < count)
            {
                int index;
                index = count - 1 - i;
                Comp comp;
                comp = array[index];
                
                boolean b;
                b = (comp.Kind() == 0);
                
                Image image;
                image = null;
                if (b)
                {
                    image = Plugin.This().ImageIconField();
                }
                if (!b)
                {
                    image = Plugin.This().ImageIconMaide();
                }
                
                String name;
                name = comp.Name();
                if (name == null)
                {
                    name = unnamed;
                }
                
                String cc;
                cc = comp.Class();
                if (cc == null)
                {
                    cc = unclassed;
                }
                
                String text;
                text = name + " : " + cc;
                

                item = new TreeItem(this.Tree, SWT.NONE, 0);
                item.setImage(image);
                item.setText(text);
                
                i = i + 1;
            }
            
            item = new TreeItem(this.Tree, SWT.NONE, 0);

            k = varClass.Base().Value();
            if (k == null)
            {
                k = unclassed;
            }
            item.setImage(Plugin.This().ImageIconBaseName());
            item.setText(k);
            
            
            item = new TreeItem(this.Tree, SWT.NONE, 0);
            
            k = varClass.Name().Value();
            if (k == null)
            {
                k = unnamed;
            }
            item.setImage(Plugin.This().ImageIconClassName());
            item.setText(k);
            
            this.Tree.setRedraw(true);
        }
        
        return true;
    }

    @Override
    public void createControl(Composite parent)
    {
        this.Tree = new Tree(parent, SWT.SINGLE);
        
        this.Update();
    }

    @Override
    public Control getControl()
    {
        return this.Tree;
    }

    @Override
    public void setActionBars(IActionBars actionBars)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setFocus()
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void addSelectionChangedListener(ISelectionChangedListener listener)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public ISelection getSelection()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void removeSelectionChangedListener(ISelectionChangedListener listener)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setSelection(ISelection selection)
    {
        // TODO Auto-generated method stub
        
    }
    
}
