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

    public void visitBinarOperator(BinaryOperator binaryOperator)
    {
        VisitorComputeArithmeticExpression calculatorLeft = new VisitorComputeArithmeticExpression();
        VisitorComputeArithmeticExpression calculatorRight = new VisitorComputeArithmeticExpression();
        binaryOperator.getLeftOperator().accept(calculatorLeft);
        binaryOperator.getRightOperator().accept(calculatorRight);

        if(binaryOperator instanceof Addition) {
            this.result += calculatorLeft.getResult() + calculatorRight.getResult();
        } else { // Multiplication
            this.result += calculatorLeft.getResult() * calculatorRight.getResult();
        }
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
