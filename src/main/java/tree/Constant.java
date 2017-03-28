package tree;

import visitor.Visitor;

public class Constant implements Node 
{
    private int value;

    public Constant(int value) 
    {
        this.value = value;
    }

    public int getValue() 
    {
        return value;
    }

    public void accept(Visitor visitor)
    {
        visitor.visitConstant(this);
    }
}
