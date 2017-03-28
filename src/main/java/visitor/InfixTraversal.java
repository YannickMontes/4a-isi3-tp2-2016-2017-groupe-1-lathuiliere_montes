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

    public void visitBinarOperator(BinaryOperator binaryOperator)
    {
        if(binaryOperator instanceof Multiplication) 
        {
            System.out.print("(");
        }
        binaryOperator.getLeftOperator().accept(this);
        System.out.print(binaryOperator.getOperator());
        binaryOperator.getRightOperator().accept(this);
        if(binaryOperator instanceof Multiplication) {
            System.out.print(")");
        }
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
