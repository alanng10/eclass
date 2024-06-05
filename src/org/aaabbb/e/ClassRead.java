package org.aaabbb.e;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ClassRead extends Any
{
	public byte[] Data;
	
	public Class Class;
	
	private ByteBuffer DataBuffer;
	
	public boolean Execute()
	{
		ByteBuffer o;
		o = ByteBuffer.wrap(this.Data);
		
		o.order(ByteOrder.LITTLE_ENDIAN);
	
		this.DataBuffer = o;
		
		this.Class = this.ExecuteClass();
		
		this.DataBuffer = null;
		return true;
	}
	
	private Class ExecuteClass()
	{
		String name;
		name = this.ExecuteString();
		
		String base;
		base = this.ExecuteString();
		
		Field[] field;
		field = this.ExecuteFieldArray();
		
		Maide[] maide;
		maide = this.ExecuteMaideArray();
		
		Class a;
		a = new Class();
		a.Init();
		a.Name = name;
		a.Base = base;
		a.Field = field;
		a.Maide = maide;
		return a;
	}
	
	private Field[] ExecuteFieldArray()
	{
		int count;
		count = this.ExecuteInt();
		
		Field[] array;
		array = new Field[count];
		
		int i;
		i = 0;
		while (i < count)
		{
			Field a;
			a = this.ExecuteField();
			
			array[i] = a;
			
			i = i + 1;
		}
		return array;
	}
	
	private Field ExecuteField()
	{
		String varClass;
		varClass = this.ExecuteString();
		
		String name;
		name = this.ExecuteString();
		
		int count;
		count = this.ExecuteByte();
		
		Field a;
		a = new Field();
		a.Init();
		a.Class = varClass;
		a.Name = name;
		a.Count = count;
		return a;
	}
	
	private Maide[] ExecuteMaideArray()
	{
		int count;
		count = this.ExecuteInt();
		
		Maide[] array;
		array = new Maide[count];
		
		int i;
		i = 0;
		while (i < count)
		{
			Maide a;
			a = this.ExecuteMaide();
			
			array[i] = a;
			
			i = i + 1;
		}
		return array;
	}
	
	private Maide ExecuteMaide()
	{
		String varClass;
		varClass = this.ExecuteString();
		
		String name;
		name = this.ExecuteString();
		
		int count;
		count = this.ExecuteByte();
		
		Var[] param;
		param = this.ExecuteVarArray();
		
		Maide a;
		a = new Maide();
		a.Init();
		a.Class = varClass;
		a.Name = name;
		a.Count = count;
		a.Param = param;
		return a;
	}
	
	private Var[] ExecuteVarArray()
	{
		int count;
		count = this.ExecuteInt();
		
		Var[] array;
		array = new Var[count];
		
		int i;
		i = 0;
		while (i < count)
		{
			Var a;
			a = this.ExecuteVar();
			
			array[i] = a;
			
			i = i + 1;
		}
		return array;
	}
	
	private Var ExecuteVar()
	{
		String varClass;
		varClass = this.ExecuteString();
		
		String name;
		name = this.ExecuteString();
		
		Var a;
		a = new Var();
		a.Init();
		a.Class = varClass;
		a.Name = name;
		return a;
	}
	
	private String ExecuteString()
	{
		int count;
		count = this.ExecuteInt();
		
		char[] array;
		array = new char[count];
		
		int i;
		i = 0;
		while (i < count)
		{
			char oc;
			oc = this.DataBuffer.getChar();
			
			array[i] = oc;
			
			i = i + 1;
		}
		
		String a;
		a = String.valueOf(array);
		return a;
	}
	
	private int ExecuteInt()
	{
		int a;
		a = this.DataBuffer.getInt();
		return a;
	}
	
	private int ExecuteByte()
	{
		int a;
		a = this.DataBuffer.get();
		return a;
	}
}
