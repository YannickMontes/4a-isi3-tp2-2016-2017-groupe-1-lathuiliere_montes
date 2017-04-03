package visitor;

import tree.*;

/**
 * Created by yannick on 22/03/17.
 */
public class PrefixTraversal implements Visitor 
{
    public void visitUnaryOperator(UnaryOperator unaryOperator)
    {
        System.out.print(unaryOperator.getOperator());
        unaryOperator.getLeftOperator().accept(this);
    }

    private void visitBinaryOperator(BinaryOperator binaryOperator)
    {
        System.out.print(binaryOperator.getOperator());
        binaryOperator.getLeftOperator().accept(this);
        binaryOperator.getRightOperator().accept(this);
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
        System.out.print(negation.getOperator());
        negation.getLeftOperator().accept(this);
    }
}
