package visitor;

import tree.*;

/**
 * Created by yannick on 22/03/17.
 */
public class VisitorComputeHeightTree implements Visitor 
{
    private int height = 0;

    public int getHeight() 
    {
        return this.height;
    }

    public void visitUnaryOperator(UnaryOperator unaryOperator)
    {
        VisitorComputeHeightTree visitorLeft = new VisitorComputeHeightTree();

        unaryOperator.getLeftOperator().accept(visitorLeft);

        this.height += visitorLeft.getHeight() + 1;
    }

    public void visitBinarOperator(BinaryOperator binaryOperator)
    {
        VisitorComputeHeightTree visitorLeft = new VisitorComputeHeightTree();
        VisitorComputeHeightTree visitorRight = new VisitorComputeHeightTree();

        binaryOperator.getLeftOperator().accept(visitorLeft);
        binaryOperator.getRightOperator().accept(visitorRight);

        this.height += Math.max(visitorLeft.getHeight(), visitorRight.getHeight()) + 1;
    }

    public void visitConstant(Constant constant)
    {
        this.height += 1;
    }

    public void visitNegation(Negation negation)
    {
        this.visitUnaryOperator(negation);
    }
}
