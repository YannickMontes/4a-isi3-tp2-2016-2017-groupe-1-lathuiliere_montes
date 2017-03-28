package visitor;

import tree.Constant;
import tree.Negation;
import tree.UnaryOperator;
import tree.BinaryOperator;

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

    public void visitBinarOperator(BinaryOperator binaryOperator)
    {
        binaryOperator.getLeftOperator().accept(this);
        binaryOperator.getRightOperator().accept(this);
        System.out.print(binaryOperator.getOperator());
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
