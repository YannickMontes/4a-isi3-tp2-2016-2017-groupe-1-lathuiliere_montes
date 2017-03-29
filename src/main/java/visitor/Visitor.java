package visitor;

import tree.BinaryOperator;
import tree.Negation;
import tree.UnaryOperator;
import tree.Constant;

/**
 * Created by yannick on 22/03/17.
 */
public interface Visitor 
{
    void visitUnaryOperator(UnaryOperator unaryOp);

    void visitBinarOperator(BinaryOperator binaryOp);

    void visitConstant(Constant constantOperator);

    void visitNegation(Negation negationOperator);
}
