package visitor;

import tree.*;

/**
 * Created by yannick on 22/03/17.
 */
public class PostfixTraversal implements Visitor 
{
    public void visitUnaryOperator(UnaryOperator unaryOperator)
    {
        unaryOperator.getLeftOperator().accept(this);
        System.out.print(unaryOperator.getOperator());
    }

    private void visitBinaryOperator(BinaryOperator binaryOperator)
    {
        binaryOperator.getLeftOperator().accept(this);
        binaryOperator.getRightOperator().accept(this);
        System.out.print(binaryOperator.getOperator());
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
        negation.getLeftOperator().accept(this);
        System.out.print(negation.getOperator());
    }
}
