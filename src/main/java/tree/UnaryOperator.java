package tree;

public abstract class UnaryOperator implements Node 
{
    private String operator;
    private Node leftOperator;

    UnaryOperator(String operator, Node leftOperator) 
    {
        this.operator = operator;
        this.leftOperator = leftOperator;
    }

    public String getOperator() 
    {
        return this.operator;
    }

    public Node getLeftOperator() 
    {
        return this.leftOperator;
    }
}
