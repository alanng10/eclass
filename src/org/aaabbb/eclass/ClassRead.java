package org.aaabbb.eclass;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ClassRead extends Any
{
	public byte[] Data()
	{
		return this.Data_D;
	}
	
	public boolean DataSet(byte[] value)
	{
		this.Data_D = value;
		return true;
	}
	
    protected byte[] Data_D;

    public Class Class()
    {
    	return this.Class_D;
    }
    
    public boolean ClassSet(Class value)
    {
    	this.Class_D = value;
    	return true;
    }
    
    protected Class Class_D;
    
    public int Status()
    {
    	return this.Status_D;
    }
    
    public boolean StatusSet(int value)
    {
    	this.Status_D = value;
    	return true;
    }
    
    protected int Status_D;

    private ByteBuffer DataBuffer;

    public boolean Execute()
    {
        ByteBuffer o;
        o = ByteBuffer.wrap(this.Data());

        o.order(ByteOrder.LITTLE_ENDIAN);

        this.DataBuffer = o;

        this.ClassSet(this.ExecuteClass());

        this.DataBuffer = null;
        return true;
    }

    private Class ExecuteClass()
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

        Class a;
        a = new Class();
        a.Init();
        a.Name(name);
        a.Base(base);
        a.Comp(comp);
        return a;
    }
    
    private ClassName ExecuteClassName()
    {
    	String value;
    	value = this.ExecuteOptionalString();
    	if (!(this.Status() == 0))
    	{
    		return null;
    	}
        
        ClassName a;
        a = new ClassName();
        a.Init();
        a.ValueSet(value);
        return a;
    }
    
    private BaseName ExecuteBaseName()
    {
    	String value;
    	value = this.ExecuteOptionalString();
    	if (!(this.Status() == 0))
    	{
    		return null;
    	}
        
        BaseName a;
        a = new BaseName();
        a.Init();
        a.ValueSet(value);
        return a;
    }

    private Comp[] ExecuteCompArray()
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

    private Comp ExecuteComp()
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
        
        Comp a;
        a = new Comp();
        a.Init();
        a.KindSet(kind);
        a.ClassSet(varClass);
        a.NameSet(name);
        a.CountSet(count);
        return a;
    }
    
    private String ExecuteOptionalString()
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

    private boolean ExecuteOptional()
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
    
    private String ExecuteString()
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
 
    private int ExecuteInt()
    {
        if (this.DataBuffer.remaining() < 4)
        {
        	this.StatusSet(2);
            return -1;
        }
        
        int a;
        a = this.DataBuffer.getInt();
        if (a < 0)
        {
        	this.StatusSet(3);
            return -1;
        }
        
        return a;
    }

    private int ExecuteByte()
    {
        if (this.DataBuffer.remaining() < 1)
        {
        	this.StatusSet(1);
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
