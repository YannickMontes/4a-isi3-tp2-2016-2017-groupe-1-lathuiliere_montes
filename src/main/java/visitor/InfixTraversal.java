package visitor;

import tree.*;

/**
 * Created by yannick on 22/03/17.
 */
public class InfixTraversal implements Visitor 
{
    public void visitUnaryOperator(UnaryOperator unaryOperator)
    {
        unaryOperator.getLeftOperator().accept(this);
        System.out.print(unaryOperator.getOperator());
    }

    private void visitBinaryOperator(BinaryOperator binaryOperator)
    {
        System.out.print("(");
        binaryOperator.getLeftOperator().accept(this);
        System.out.print(binaryOperator.getOperator());
        binaryOperator.getRightOperator().accept(this);
        System.out.print(")");
    }

    public void visitMultiplication(Multiplication multiplication)
    {
        this.visitBinaryOperator(multiplication);
    }

    public void visitAddition(Addition addition)
    {
        this.visitBinaryOperator(addition);
    }

    public void visitConstant(Constant constant)
    {
        System.out.print(constant.getValue());
    }

    public void visitNegation(Negation negation)
    {
        System.out.print(String.format("(%s",negation.getOperator()));
        negation.getLeftOperator().accept(this);
        System.out.print(")");
    }
}
