package visitor;

import tree.*;

/**
 * Created by yannick on 22/03/17.
 */
public class VisitorComputeArithmeticExpression implements Visitor 
{
    private int result = 0;

    public int getResult() 
    {
        return this.result;
    }

    public void visitUnaryOperator(UnaryOperator unaryOperator)
    {
        throw new UnsupportedOperationException();
    }

    public void visitMultiplication(Multiplication multiplication)
    {
        VisitorComputeArithmeticExpression calculatorLeft = new VisitorComputeArithmeticExpression();
        VisitorComputeArithmeticExpression calculatorRight = new VisitorComputeArithmeticExpression();
        multiplication.getLeftOperator().accept(calculatorLeft);
        multiplication.getRightOperator().accept(calculatorRight);

        this.result += calculatorLeft.getResult() * calculatorRight.getResult();
    }

    public void visitAddition(Addition addition)
    {
        VisitorComputeArithmeticExpression calculatorLeft = new VisitorComputeArithmeticExpression();
        VisitorComputeArithmeticExpression calculatorRight = new VisitorComputeArithmeticExpression();
        addition.getLeftOperator().accept(calculatorLeft);
        addition.getRightOperator().accept(calculatorRight);

        this.result += calculatorLeft.getResult() + calculatorRight.getResult();
    }

    public void visitConstant(Constant constant)
    {
        this.result += constant.getValue();
    }

    public void visitNegation(Negation negation)
    {
        VisitorComputeArithmeticExpression calculatorLeft = new VisitorComputeArithmeticExpression();
        negation.getLeftOperator().accept(calculatorLeft);
        this.result += -calculatorLeft.getResult();
    }
}
