package org.aaabbb.eclass;

public class Class extends Any
{
    public ClassName Name()
    {
        return this.Name_D;
    }
    
    public boolean NameSet(ClassName value)
    {
        this.Name_D = value;
        return true;
    }
    
    protected ClassName Name_D;
    
    public BaseName Base()
    {
        return this.Base_D;
    }
    
    public boolean BaseSet(BaseName value)
    {
        this.Base_D = value;
        return true;
    }
    
    protected BaseName Base_D;

    public Field[] Field()
    {
        return this.Field_D;
    }
    
    public boolean FieldSet(Field[] value)
    {
        this.Field_D = value;
        return true;
    }
    
    protected Field[] Field_D;

    public Maide[] Maide()
    {
        return this.Maide_D;
    }
    
    public boolean MaideSet(Maide[] value)
    {
        this.Maide_D = value;
        return true;
    }
    
    protected Maide[] Maide_D;
}