package tree;

import visitor.Visitor;

public class Multiplication extends BinaryOperator 
{
    public Multiplication(Node leftNode, Node rightNode) 
    {
        super("*", leftNode, rightNode);
    }

    public void accept(Visitor visitor)
    {
        visitor.visitMultiplication(this);
    }
}
