package tree;

public abstract class BinaryOperator extends UnaryOperator 
{
    private Node rightOperator;

    public BinaryOperator(String operator, Node leftNode, Node rightNode) 
    {
        super(operator, leftNode);
        this.rightOperator = rightNode;
    }

    public Node getRightOperator() 
    {
        return this.rightOperator;
    }
}
