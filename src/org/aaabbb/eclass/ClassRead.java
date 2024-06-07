package org.aaabbb.eclass;

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
        Class a;
        a = new Class();
        a.Init();

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

        Field[] field;
        field = this.ExecuteFieldArray(a);
        if (field == null)
        {
            return null;
        }
        
        Maide[] maide;
        maide = this.ExecuteMaideArray(a);
        if (maide == null)
        {
            return null;
        }

        a.Name = name;
        a.Base = base;
        a.Field = field;
        a.Maide = maide;
        return a;
    }
    
    private ClassName ExecuteClassName()
    {
        String value;
        value = this.ExecuteString();
        if (value == null)
        {
            return null;
        }
        
        ClassName a;
        a = new ClassName();
        a.Init();
        a.Value = value;
        return a;
    }
    
    private BaseName ExecuteBaseName()
    {
        String value;
        value = this.ExecuteString();
        if (value == null)
        {
            return null;
        }
        
        BaseName a;
        a = new BaseName();
        a.Init();
        a.Value = value;
        return a;
    }

    private Field[] ExecuteFieldArray(Class c)
    {
        int count;
        count = this.ExecuteInt();
        if (count == -1)
        {
            return null;
        }
        
        Field[] array;
        array = new Field[count];

        int i;
        i = 0;
        while (i < count)
        {
            Field a;
            a = this.ExecuteField(c);
            if (a == null)
            {
                return null;
            }
            
            array[i] = a;

            i = i + 1;
        }
        return array;
    }

    private Field ExecuteField(Class c)
    {
        String varClass;
        varClass = this.ExecuteString();
        if (varClass == null)
        {
            return null;
        }
        
        String name;
        name = this.ExecuteString();
        if (name == null)
        {
            return null;
        }

        int count;
        count = this.ExecuteByte();
        if (count == -1)
        {
            return null;
        }
        
        Field a;
        a = new Field();
        a.Init();
        a.Class = varClass;
        a.Name = name;
        a.Count = count;
        a.Parent = c;
        return a;
    }

    private Maide[] ExecuteMaideArray(Class c)
    {
        int count;
        count = this.ExecuteInt();
        if (count == -1)
        {
            return null;
        }
        
        Maide[] array;
        array = new Maide[count];

        int i;
        i = 0;
        while (i < count)
        {
            Maide a;
            a = this.ExecuteMaide(c);
            if (a == null)
            {
                return null;
            }

            array[i] = a;

            i = i + 1;
        }
        return array;
    }

    private Maide ExecuteMaide(Class c)
    {
        String varClass;
        varClass = this.ExecuteString();
        if (varClass == null)
        {
            return null;
        }
        
        String name;
        name = this.ExecuteString();
        if (name == null)
        {
            return null;
        }
        
        int count;
        count = this.ExecuteByte();
        if (count == -1)
        {
            return null;
        }
        
        Var[] param;
        param = this.ExecuteVarArray();
        if (param == null)
        {
            return null;
        }
        
        Maide a;
        a = new Maide();
        a.Init();
        a.Class = varClass;
        a.Name = name;
        a.Count = count;
        a.Param = param;
        a.Parent = c;
        return a;
    }

    private Var[] ExecuteVarArray()
    {
        int count;
        count = this.ExecuteInt();
        if (count == -1)
        {
            return null;
        }
        
        Var[] array;
        array = new Var[count];

        int i;
        i = 0;
        while (i < count)
        {
            Var a;
            a = this.ExecuteVar();
            if (a == null)
            {
                return null;
            }

            array[i] = a;

            i = i + 1;
        }
        return array;
    }

    private Var ExecuteVar()
    {
        String varClass;
        varClass = this.ExecuteString();
        if (varClass == null)
        {
            return null;
        }
        
        String name;
        name = this.ExecuteString();
        if (name == null)
        {
            return null;
        }
        
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
            o = this.ExecuteChar();
            if (o == -1)
            {
                return null;
            }
            
            char oc;
            oc = (char)o;

            array[i] = oc;

            i = i + 1;
        }

        String a;
        a = String.valueOf(array);
        return a;
    }
    
    private int ExecuteChar()
    {
        if (this.DataBuffer.remaining() < 2)
        {
            return -1;
        }
        
        int a;
        a = this.DataBuffer.getChar();
        return a;
    }

    private int ExecuteInt()
    {
        if (this.DataBuffer.remaining() < 4)
        {
            return -1;
        }
        
        int a;
        a = this.DataBuffer.getInt();
        if (a < 0)
        {
            return -1;
        }
        
        return a;
    }

    private int ExecuteByte()
    {
        if (this.DataBuffer.remaining() < 1)
        {
            return -1;
        }
        
        int a;
        a = this.DataBuffer.get();
        if (a < 0)
        {
            return -1;
        }
        
        return a;
    }
}
