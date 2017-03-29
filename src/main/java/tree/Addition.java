package tree;

import visitor.Visitor;

public class Addition extends BinaryOperator 
{
    public Addition(Node leftNode, Node rightNode) 
    {
        super("+", leftNode, rightNode);
    }

    public void accept(Visitor visitor)
    {
        visitor.visitBinarOperator(this);
    }
}
