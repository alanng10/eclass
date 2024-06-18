package org.alanng10.eclass;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ClassRead extends Any
{
	public byte[] Data()
	{
		return this.Data_D;
	}
	
	public boolean Data(byte[] value)
	{
		this.Data_D = value;
		return true;
	}
	
    protected byte[] Data_D;

    public Class Class()
    {
    	return this.Class_D;
    }
    
    public boolean Class(Class value)
    {
    	this.Class_D = value;
    	return true;
    }
    
    protected Class Class_D;
    
    public int Status()
    {
    	return this.Status_D;
    }
    
    public boolean Status(int value)
    {
    	this.Status_D = value;
    	return true;
    }
    
    protected int Status_D;

    private ByteBuffer DataBuffer;

    public boolean Execute()
    {
        this.Status(0);
        
        ByteBuffer o;
        o = ByteBuffer.wrap(this.Data());

        o.order(ByteOrder.LITTLE_ENDIAN);

        this.DataBuffer = o;

        this.Class(this.ExecuteClass());

        this.DataBuffer = null;
        
        if (!(this.Status() == 0))
        {
            return false;
        }
        
        return true;
    }

    protected Class ExecuteClass()
    {
    	boolean b;
    	b = this.ExecuteOptional();
    	if (!(this.Status() == 0))
    	{
    		return null;
    	}
    	
    	if (!b)
    	{
    		return null;
    	}
    	
        ClassName name;
        name = this.ExecuteClassName();
        if (name == null)
        {
            return null;
        }
        
        BaseName base;
        base = this.ExecuteBaseName();
        if (base == null)
        {
            return null;
        }

        Comp[] comp;
        comp = this.ExecuteCompArray();
        if (comp == null)
        {
            return null;
        }
        
        Range range;
        range = this.ExecuteRange();
        if (range == null)
        {
            return null;
        }

        Class a;
        a = new Class();
        a.Init();
        a.Name(name);
        a.Base(base);
        a.Comp(comp);
        a.Range(range);
        return a;
    }
    
    protected ClassName ExecuteClassName()
    {
    	String value;
    	value = this.ExecuteOptionalString();
    	if (!(this.Status() == 0))
    	{
    		return null;
    	}
    	
        Range range;
        range = null;
        if (!(value == null))
        {
            range = this.ExecuteRange();
            if (range == null)
            {
                return null;
            }
        }
    	
        ClassName a;
        a = new ClassName();
        a.Init();
        a.Value(value);
        a.Range(range);
        return a;
    }
    
    protected BaseName ExecuteBaseName()
    {
    	String value;
    	value = this.ExecuteOptionalString();
    	if (!(this.Status() == 0))
    	{
    		return null;
    	}
        
    	Range range;
    	range = null;
    	if (!(value == null))
    	{
    	    range = this.ExecuteRange();
            if (range == null)
            {
                return null;
            }
    	}
        
        BaseName a;
        a = new BaseName();
        a.Init();
        a.Value(value);
        a.Range(range);
        return a;
    }

    protected Comp[] ExecuteCompArray()
    {
        int count;
        count = this.ExecuteInt();
        if (count == -1)
        {
            return null;
        }
        
        Comp[] array;
        array = new Comp[count];

        int i;
        i = 0;
        while (i < count)
        {
            Comp a;
            a = this.ExecuteComp();
            if (a == null)
            {
                return null;
            }
            
            array[i] = a;

            i = i + 1;
        }
        return array;
    }

    protected Comp ExecuteComp()
    {
        int kind;
        kind = this.ExecuteByte();
        if (kind == -1)
        {
            return null;
        }
    	
    	String varClass;
    	varClass = this.ExecuteOptionalString();
    	if (!(this.Status() == 0))
    	{
    		return null;
    	}
    	
    	String name;
    	name = this.ExecuteOptionalString();
    	if (!(this.Status() == 0))
    	{
    		return null;
    	}
        
        int count;
        count = this.ExecuteByte();
        if (count == -1)
        {
            return null;
        }
        
        Range range;
        range = this.ExecuteRange();
        if (range == null)
        {
            return null;
        }
        
        Comp a;
        a = new Comp();
        a.Init();
        a.Kind(kind);
        a.Class(varClass);
        a.Name(name);
        a.Count(count);
        a.Range(range);
        return a;
    }
    
    protected Range ExecuteRange()
    {
        int index;
        index = this.ExecuteInt();
        if (index == -1)
        {
            return null;
        }
        
        int count;
        count = this.ExecuteInt();
        if (count == -1)
        {
            return null;
        }
        
        Range a;
        a = new Range();
        a.Init();
        a.Index(index);
        a.Count(count);
        return a;
    }
    
    protected String ExecuteOptionalString()
    {
    	boolean b;
    	b = this.ExecuteOptional();
    	if (!(this.Status() == 0))
    	{
    		return null;
    	}
    	
    	String a;
    	a = null;
    	if (b)
    	{
            a = this.ExecuteString();
    	}
    	return a;
    }

    protected boolean ExecuteOptional()
    {
    	int aa;
    	
    	aa = this.ExecuteByte();
    	if (aa == -1)
    	{
    		return false;
    	}
    	
    	if (aa == 0)
    	{
            return false;
    	}
    	
    	return true;
    }
    
    protected String ExecuteString()
    {
        int count;
        count = this.ExecuteInt();
        if (count == -1)
        {
            return null;
        }
        
        char[] array;
        array = new char[count];

        int i;
        i = 0;
        while (i < count)
        {
            int o;
            o = this.ExecuteByte();
            if (o == -1)
            {
                return null;
            }
            
            byte ob;
            ob = (byte)o;
            
            char oc;
            oc = (char)ob;

            array[i] = oc;

            i = i + 1;
        }

        String a;
        a = String.valueOf(array);
        return a;
    }
 
    protected int ExecuteInt()
    {
        if (this.DataBuffer.remaining() < 4)
        {
        	this.Status(2);
            return -1;
        }
        
        int a;
        a = this.DataBuffer.getInt();
        if (a < 0)
        {
        	this.Status(3);
            return -1;
        }
        
        return a;
    }

    protected int ExecuteByte()
    {
        if (this.DataBuffer.remaining() < 1)
        {
        	this.Status(1);
            return -1;
        }
        
        byte k;
        k = this.DataBuffer.get();
        
        int a;
        a = k;
        a = a & 0xff;
        return a;
    }
}
