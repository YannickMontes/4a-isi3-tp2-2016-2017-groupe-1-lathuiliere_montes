package tree;

import visitor.Visitor;

public class Negation extends UnaryOperator 
{
    public Negation(Node n) 
    {
        super("-", n);
    }

    public void accept(Visitor visitor)
    {
        visitor.visitNegation(this);
    }
}
